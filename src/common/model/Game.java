package common.model;

import java.util.Objects;

public class Game {

    protected int gameId;
    protected String gameTitle;
    protected String gameDescription;
    protected boolean isActive;
    private Score score;

    public Score getScore() {
        return score;
    }

    public void setScore(Score score) {
        this.score = score;
    }

    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    public String getGameTitle() {
        return gameTitle;
    }

    public void setGameTitle(String gameTitle) {
        this.gameTitle = gameTitle;
    }

    public String getGameDescription() {
        return gameDescription;
    }

    public void setGameDescription(String gameDescription) {
        this.gameDescription = gameDescription;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean isActive) {
        this.isActive = isActive;
    }

    public Game() {
    }

    public Game(int gameId) {
        this.gameId = gameId;
    }

    public Game(int gameId, String gameTitle, String gameDescription, boolean isActive) {
        this.gameId = gameId;
        this.gameTitle = gameTitle;
        this.gameDescription = gameDescription;
        this.isActive = isActive;
    }

    public Game(int gameId, String gameTitle, String gameDescription, boolean isActive, Score score) {
        this.gameId = gameId;
        this.gameTitle = gameTitle;
        this.gameDescription = gameDescription;
        this.isActive = isActive;
        this.score = score;
    }
    
    

    @Override
    public String toString() {
        return "Game{" + "gameId=" + gameId + ", gameTitle=" + gameTitle + ", gameDescription=" + gameDescription + ", isActive=" + isActive + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 73 * hash + this.gameId;
        hash = 73 * hash + Objects.hashCode(this.gameTitle);
        hash = 73 * hash + Objects.hashCode(this.gameDescription);
        hash = 73 * hash + (this.isActive ? 1 : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Game other = (Game) obj;
        if (this.gameId != other.gameId) {
            return false;
        }
        if (this.isActive != other.isActive) {
            return false;
        }
        if (!Objects.equals(this.gameTitle, other.gameTitle)) {
            return false;
        }
        return Objects.equals(this.gameDescription, other.gameDescription);
    }

}
