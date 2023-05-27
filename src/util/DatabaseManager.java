package util;

import com.google.gson.JsonElement;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public abstract class DatabaseManager {

    private static String DATABASE;
    private static String DBUSER;
    private static String DBPASSWORD;
    private static String JSONQUERYPATH;
    private Connection connection;
    private GameConfiguration configuration;
    private GameSuiteLogger logger;

    public DatabaseManager() {
        try {
            configuration = GameConfiguration.getInstance();
            logger = GameSuiteLogger.getInstance();
            connection = getConnection();
        } catch (SQLException e) {
            logger.logError(DatabaseManager.class.getName(), e);                    
        }
    }

    public void closeConnection() throws SQLException {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                logger.logError(DatabaseManager.class.getName(), e); 
                throw e;
            }
        }
    }

    private Connection getConnection() throws SQLException {
        DATABASE = configuration.getProperty("DATABASE");
        DBUSER = configuration.getProperty("DBUSER");
        DBPASSWORD = configuration.getProperty("DBPASSWORD");
        JSONQUERYPATH = configuration.getProperty("JSONQUERYPATH");
        String dburl = "jdbc:mysql://localhost:3306/" + DATABASE;
        return DriverManager.getConnection(dburl, DBUSER, DBPASSWORD);
    }

    private PreparedStatement prepareStatement(String namespace, String statementName, JsonObject params)
            throws SQLException {
        String query;
        query = getStatementFromJSON(namespace, statementName);
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        if (params != null) {
            int idx = 0;
            for (String paramName : params.keySet()) {
                JsonElement ele = params.get(paramName);
                if (ele.isJsonPrimitive()) {
                    if (ele.getAsJsonPrimitive().isString()) {
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
        try {
            PreparedStatement preparedStatement = prepareStatement(namespace, statementName, params);
            resultSet = preparedStatement.executeQuery();
        } catch (SQLException e) {
            throw e;
        } finally {
            closeConnection();
        }
        return resultSet;
    }

    private String getStatementFromJSON(String namespace, String statementName) {
        String query = null;
        try ( FileReader reader = new FileReader(JSONQUERYPATH + "/" + namespace + ".json")) {
            JsonObject jsonObject = JsonParser.parseReader(reader).getAsJsonObject();
            query = jsonObject.get(statementName).getAsString();
        } catch (IOException e) {
            logger.logError(DatabaseManager.class.getName(), e); 
        }
        return query;
    }

    public abstract String handleSQLException(SQLException e);
}
