package util;

import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DatabaseManager {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/simple-game-suite";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "";

    private Connection connection;

    public DatabaseManager() throws SQLException {
        try {
            connection = getConnection();
        } catch (SQLException e) {
            Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, e);
            throw e;
        }
    }

    public void closeConnection() throws SQLException {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, e);
                throw e;
            }
        }
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
    }

    private PreparedStatement prepareStatement(String statementName, JsonObject params) throws SQLException {
        String query = "";
        try {
            query = getStatementFromJSON(statementName);
        } catch (IOException ex) {
            Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        if (params != null) {
            int idx = 0;
            for (String paramName : params.keySet()) {
                Object paramValue = params.get(paramName);
                preparedStatement.setObject(++idx, paramValue);
            }
        }

        return preparedStatement;
    }

    public int executeUpdate(String statementName, JsonObject params) throws SQLException {
        int rowsAffected = 0;
        try ( PreparedStatement preparedStatement = prepareStatement(statementName, params)) {
            rowsAffected = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, e);
            throw e;
        }
        return rowsAffected;
    }

    public ResultSet executeQuery(String statementName, JsonObject params) throws SQLException {
        ResultSet resultSet = null;
        try {
            PreparedStatement preparedStatement = prepareStatement(statementName, params);
            resultSet = preparedStatement.executeQuery();
        } catch (SQLException e) {
            Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, e);
            throw e;
        }
        return resultSet;
    }

    private String getStatementFromJSON(String statementName) throws IOException {
        String query = null;
        try ( FileReader reader = new FileReader("sqlstatements.json")) {
            JsonObject jsonObject = JsonParser.parseReader(reader).getAsJsonObject();
            query = jsonObject.get(statementName).getAsString();
        } catch (IOException e) {
            Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, e);
            throw e;
        }
        return query;
    }
}
