package common.controller;

import com.google.gson.JsonObject;
import common.events.ExceptionThrown;
import common.model.User;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import util.DatabaseManager;
import util.GameSuiteLogger;
import util.TranslationHandler;

public class UserController implements ExceptionThrown {

    private User user;
    private final String namespace = "user";

    public void setUser(User user) {
        this.user = user;
    }

    public UserController(User user) {
        this.user = user;
        db = DatabaseManager.getInstance();
        translations = TranslationHandler.getInstance();
    }

    public int saveUser() throws SQLException {
        JsonObject params = new JsonObject();
        params.addProperty("Username", user.getUsername().toLowerCase());
        int executeUpdate = 0;
        try {
            executeUpdate = db.executeUpdate(namespace, "SaveUser", params);
        } catch (SQLException ex) {
            logger.logError(UserController.class.getName(), ex);
            throw ex;
        }
        return executeUpdate;
    }

    public List<User> getUsers() {
        List<User> users = new ArrayList<>();
        try {
            ResultSet executeQuery = db.executeQuery(namespace, "GetUsers", new JsonObject());
            while (executeQuery.next()) {
                User u = new User(
                        executeQuery.getInt(1),
                        executeQuery.getString(2)
                );
                users.add(u);
            }
        } catch (SQLException ex) {
            logger.logError(UserController.class.getName(), ex);
        }
        return users;
    }

    public User getUser() {
        JsonObject params = new JsonObject();
        params.addProperty("Userid", user.getUserId());
        params.addProperty("Username", user.getUsername());
        try {
            ResultSet executeQuery = db.executeQuery(namespace, "GetUser", params);
            while (executeQuery.next()) {
                user.setUserId(executeQuery.getInt(1));
                user.setUsername(executeQuery.getString(2));
            }
        } catch (SQLException ex) {
            logger.logError(UserController.class.getName(), ex);
        }
        return user;
    }

    public User updateUser() throws SQLException {
        JsonObject params = new JsonObject();
        params.addProperty("Userid", user.getUserId());
        params.addProperty("Username", user.getUsername());
        try {
            int executeUpdate = db.executeUpdate(namespace, "UpdateUser", params);
            if (executeUpdate > 0) {
                logger.logInfo("User updated successfully.");
            }
        } catch (SQLException ex) {
            logger.logError(UserController.class.getName(), ex);
            throw ex;
        }
        return user;
    }

    @Override
    public String handleSqlExceptions(SQLException e) {
        int errorCode = e.getErrorCode();
        String errMsg = "";
        switch (errorCode) {
            case 1062 ->
                errMsg = translations.getTranslation(TranslationHandler.SCHEMMA_ERROR_TRANSLATION, "ERRMSG_DUPLICATEUSER");
            case 1451 ->
                errMsg = translations.getTranslation(TranslationHandler.SCHEMMA_ERROR_TRANSLATION, "ERRMSG_DBPERMISSIONDENIED");
            case 1045 ->
                errMsg = translations.getTranslation(TranslationHandler.SCHEMMA_ERROR_TRANSLATION, "ERRMSG_DBFAILEDUPDATE");
            default ->
                errMsg = translations.getTranslation(TranslationHandler.SCHEMMA_ERROR_TRANSLATION, "ERRMSG_DBERRORDEFAULT");
        }
        return errMsg;
    }

    private static final GameSuiteLogger logger = GameSuiteLogger.getInstance();
    private final DatabaseManager db;
    private final TranslationHandler translations;
}
