package common.controller;

import com.google.gson.JsonObject;
import common.model.Game;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import util.DatabaseManager;
import util.GameSuiteLogger;

public class GameController {

    private Game game;
    private final String namespace = "game";

    public void setGame(Game game) {
        this.game = game;
    }

    public GameController(Game game) {
        this.game = game;
        db = DatabaseManager.getInstance();
    }

    public int saveGame() {
        JsonObject params = new JsonObject();
        params.addProperty("Username", game.getGameTitle().toLowerCase());
        int executeUpdate = 0;
        try {
            executeUpdate = db.executeUpdate(namespace, "SaveGame", params);
        } catch (SQLException ex) {
            logger.logError(UserController.class.getName(), ex);
        }
        return executeUpdate;
    }

    public List<Game> getGames() {
        List<Game> games = new ArrayList<>();
        ResultSet resultSet = null;
        try {
            resultSet = db.executeQuery(namespace, "GetGames", new JsonObject());
            while (resultSet.next()) {
                Game g = new Game(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getBoolean(5)
                );
                games.add(g);
            }
        } catch (SQLException ex) {
            logger.logError(UserController.class.getName(), ex);
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    logger.logError(UserController.class.getName(), e);
                }
            }
            db.closeConnection();
        }
        return games;
    }

    public Game getGame() {
        JsonObject params = new JsonObject();
        params.addProperty("GameId", game.getGameId());
        params.addProperty("GameTitle", game.getGameTitle());
        params.addProperty("GameDescription", game.getGameDescription());
        params.addProperty("IsActive", game.isActive());
        try {
            ResultSet executeQuery = db.executeQuery(namespace, "GetUser", params);
            while (executeQuery.next()) {
                game.setGameId(executeQuery.getInt(1));
                game.setGameTitle(executeQuery.getString(2));
                game.setGameDescription(executeQuery.getString(3));
                game.setActive(executeQuery.getBoolean(4));
            }
        } catch (SQLException ex) {
            logger.logError(UserController.class.getName(), ex);
        }
        return game;
    }

    public Game updateGame() {
        JsonObject params = new JsonObject();
        params.addProperty("GameId", game.getGameId());
        params.addProperty("GameTitle", game.getGameTitle());
        params.addProperty("GameDescription", game.getGameTitle());
        params.addProperty("IsActive", game.getGameTitle());
        try {
            int executeUpdate = db.executeUpdate(namespace, "UpdateGame", params);
            if (executeUpdate > 0) {
                logger.logInfo("User updated successfully.");
            }
        } catch (SQLException ex) {
            logger.logError(UserController.class.getName(), ex);
        }
        return game;
    }

    private static final GameSuiteLogger logger = GameSuiteLogger.getInstance();
    private final DatabaseManager db;
}
