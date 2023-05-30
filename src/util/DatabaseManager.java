package util;

import com.google.gson.JsonElement;
import java.io.IOException;
import java.sql.*;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import common.events.QueryExecutionListener;
import java.io.BufferedReader;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class DatabaseManager {

    private static String DBURL;
    private static String DATABASE;
    private static String DBUSER;
    private static String DBPASSWORD;
    private static String JSONQUERYFOLDER;
    private Connection connection;
    private final GameConfiguration configuration;
    private final GameSuiteLogger logger;
    private QueryExecutionListener listener;
    private static volatile DatabaseManager instance;

    public QueryExecutionListener getProgressListener() {
        return listener;
    }

    public void addProgressListener(QueryExecutionListener listener) {
        this.listener = listener;
    }

    private DatabaseManager() {
        configuration = GameConfiguration.getInstance();
        logger = GameSuiteLogger.getInstance();
        DATABASE = configuration.getProperty("DATABASE");
        DBUSER = configuration.getProperty("DBUSER");
        DBPASSWORD = configuration.getProperty("DBPASSWORD");
        DBURL = configuration.getProperty("DBURL");
        JSONQUERYFOLDER = configuration.getProperty("JSONQUERYFOLDER");
        createDatabaseIfNotExist();
    }

    public static DatabaseManager getInstance() {
        if (instance == null) {
            synchronized (DatabaseManager.class) {
                if (instance == null) {
                    instance = new DatabaseManager();
                }
            }
        }
        return instance;
    }

    public void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                logger.logError(DatabaseManager.class.getName(), e);
            }
        }
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DBURL, DBUSER, DBPASSWORD);
    }

    private PreparedStatement prepareStatement(String namespace, String statementName, JsonObject params)
            throws SQLException {
        String query;
        query = getStatementFromJSON(namespace, statementName);
        connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        if (params != null) {
            int idx = 0;
            for (String paramName : params.keySet()) {
                JsonElement ele = params.get(paramName);
                if (ele.isJsonPrimitive()) {
                    JsonPrimitive jsonPrimitive = ele.getAsJsonPrimitive();
                    if (jsonPrimitive.isJsonPrimitive() && jsonPrimitive.getAsString().startsWith("base64:")) {
                        String base64Data = jsonPrimitive.getAsString().substring(7);
                        byte[] byteArrayData = java.util.Base64.getDecoder().decode(base64Data);
                        preparedStatement.setBytes(++idx, byteArrayData);
                    } else if (ele.getAsJsonPrimitive().isString()) {
                        preparedStatement.setString(++idx, ele.getAsString());
                    } else if (ele.getAsJsonPrimitive().isBoolean()) {
                        preparedStatement.setBoolean(++idx, ele.getAsBoolean());
                    } else if (ele.getAsJsonPrimitive().isNumber()) {
                        if (ele.getAsString().contains(".")) {
                            preparedStatement.setDouble(++idx, ele.getAsDouble());
                        } else {
                            preparedStatement.setInt(++idx, ele.getAsInt());
                        }
                    } else {
                        throw new IllegalArgumentException("Unsupported data type for parameter.");
                    }
                } else if (ele.isJsonNull()) {
                    preparedStatement.setNull(++idx, Types.NULL);
                }
            }
        }
        return preparedStatement;
    }

    public int executeUpdate(String namespace, String statementName, JsonObject params) throws SQLException {
        int rowsAffected = 0;
        try ( PreparedStatement preparedStatement = prepareStatement(namespace, statementName, params)) {
            rowsAffected = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            closeConnection();
        }
        return rowsAffected;
    }

    public ResultSet executeQuery(String namespace, String statementName, JsonObject params) throws SQLException {
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = prepareStatement(namespace, statementName, params);
            resultSet = preparedStatement.executeQuery();
        } catch (SQLException e) {
            throw e;
        }
        return resultSet;
    }

    private String getStatementFromJSON(String namespace, String statementName) {
        return Utilities
                .getValueFromJsonFile(JSONQUERYFOLDER.concat("/") + namespace.concat(".json"), statementName);
    }

    public final boolean checkDatabaseExists() {
        try {
            connection = getConnection();
            ResultSet resultSet = connection.getMetaData().getCatalogs();
            while (resultSet.next()) {
                String existingDatabaseName = resultSet.getString(1);
                if (existingDatabaseName.equalsIgnoreCase(DATABASE)) {
                    return true;
                }
            }
        } catch (SQLException ex) {
            logger.logError(DatabaseManager.class.getName(), ex);
        } finally {
            closeConnection();
        }
        return false;
    }

    private String readFile(String filePath) throws IOException {
        Path path = Paths.get(filePath);
        StringBuilder sb = new StringBuilder();
        try ( BufferedReader reader = Files.newBufferedReader(path)) {
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line).append(System.lineSeparator());
            }
        }
        return sb.toString();
    }

    private List<String> splitQueries(String sql) {
        String[] qrs = sql.split(";");
        List<String> queries = Arrays.asList(qrs);
        queries.stream().forEach(q -> q.trim());
        return queries;
    }

    private void executeDBCreation(List<String> queries) {
        try {
            connection = getConnection();
            Statement statement = connection.createStatement();
            int executedQueries = 0;
            for (String query : queries) {
                statement.addBatch(query);
                executedQueries++;
            }
            int[] executeBatch = statement.executeBatch();
            if (executeBatch.length > 0) {
                logger.logInfo("Database created successfully.");
                String conString = DBURL + DATABASE;
                DBURL = conString;
            }
        } catch (SQLException ex) {
            logger.logError(DatabaseManager.class.getName(), ex);
        } finally {
            closeConnection();
        }
    }

    private static boolean isCommentQuery(String query) {
        query = query.trim();
        return query.startsWith("--") || query.startsWith("/*");
    }

    private void createDatabaseIfNotExist() {
        boolean exists = checkDatabaseExists();
        if (!exists) {
            logger.logInfo("Staring to create the database because" + DATABASE + "does not exist.");
            File latestSQLFile = getLatestSQLFile(JSONQUERYFOLDER);
            if (latestSQLFile.canRead()) {
                try {
                    String sql = readFile(latestSQLFile.getAbsolutePath());
                    List<String> queris = splitQueries(sql);
                    List<String> refineQueryList = refineQueryList(queris);
                    executeDBCreation(refineQueryList);
                } catch (IOException ex) {
                    logger.logError(DatabaseManager.class.getName(), ex);
                }
            }
        } else {
            String conString = DBURL + DATABASE;
            DBURL = conString;
        }

    }

    private File getLatestSQLFile(String folderPath) {
        List<File> sqlFiles = new ArrayList<>();
        File folder = new File(folderPath);
        File[] files = folder.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile() && file.getName().endsWith(".sql")) {
                    sqlFiles.add(file);
                }
            }
        }
        sqlFiles.sort(Comparator.comparingLong(File::lastModified).reversed());
        return sqlFiles.get(0);
    }

    private List<String> refineQueryList(List<String> queris) {
        return queris
                .stream()
                .filter(q -> !q.isBlank() || isCommentQuery(q))
                .collect(Collectors.toList());
    }

}
