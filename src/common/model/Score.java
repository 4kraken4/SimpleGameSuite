package common.model;

import java.time.LocalDate;
import java.util.Objects;

public class Score {

    protected int scoreId;
    protected Game game;
    protected User user;
    protected int value;
    protected LocalDate lastUpdated;

    public int getScoreId() {
        return scoreId;
    }

    public void setScoreId(int scoreId) {
        this.scoreId = scoreId;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public LocalDate getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(LocalDate lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public Score() {
    }

    public Score(int scoreId, Game game, User user, int value, LocalDate lastUpdated) {
        this.scoreId = scoreId;
        this.game = game;
        this.user = user;
        this.value = value;
        this.lastUpdated = lastUpdated;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + this.scoreId;
        hash = 71 * hash + Objects.hashCode(this.game);
        hash = 71 * hash + Objects.hashCode(this.user);
        hash = 71 * hash + this.value;
        hash = 71 * hash + Objects.hashCode(this.lastUpdated);
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
        final Score other = (Score) obj;
        if (this.scoreId != other.scoreId) {
            return false;
        }
        if (this.value != other.value) {
            return false;
        }
        if (!Objects.equals(this.game, other.game)) {
            return false;
        }
        if (!Objects.equals(this.user, other.user)) {
            return false;
        }
        return Objects.equals(this.lastUpdated, other.lastUpdated);
    }

    @Override
    public String toString() {
        return "Score{" + "scoreId=" + scoreId + ", game=" + game + ", user=" + user + ", value=" + value + ", lastUpdated=" + lastUpdated + '}';
    }
}
