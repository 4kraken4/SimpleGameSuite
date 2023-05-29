package common.model;

import java.time.LocalDate;
import java.util.Objects;

public class Score {

    private int scoreId;
    private int value;
    private Object answer;
    private Object helperData;
    private LocalDate lastUpdated;

    public Object getAnswer() {
        return answer;
    }

    public void setAnswer(Object answer) {
        this.answer = answer;
    }

    public Object getHelperData() {
        return helperData;
    }

    public void setHelperData(Object helperData) {
        this.helperData = helperData;
    }

    public int getScoreId() {
        return scoreId;
    }

    public void setScoreId(int scoreId) {
        this.scoreId = scoreId;
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

    public Score(int scoreId, int value, LocalDate lastUpdated) {
        this.scoreId = scoreId;
        this.value = value;
        this.lastUpdated = lastUpdated;
    }

    public Score(int scoreId, int value, Object answer, Object helperData, LocalDate lastUpdated) {
        this.scoreId = scoreId;
        this.value = value;
        this.answer = answer;
        this.helperData = helperData;
        this.lastUpdated = lastUpdated;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + this.scoreId;
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
        return Objects.equals(this.lastUpdated, other.lastUpdated);
    }

    @Override
    public String toString() {
        return "Score{" + "scoreId=" + scoreId + ", value=" + value + ", lastUpdated=" + lastUpdated + '}';
    }
}
