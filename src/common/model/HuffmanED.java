package common.model;

import java.util.Objects;

public class HuffmanED extends Game {
    private String answer;
    private boolean isEncode;
    private String question;
    public static final int GAME_ID = 3;

    public HuffmanED(String answer, boolean isEncode, String question) {
        this.answer = answer;
        this.isEncode = isEncode;
        this.question = question;
    }

    public HuffmanED(String answer, boolean isEncode, String question, int gameId, String gameTitle,
            String gameDescription, boolean isActive) {
        super(gameId, gameTitle, gameDescription, isActive);
        this.answer = answer;
        this.isEncode = isEncode;
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public boolean isIsEncode() {
        return isEncode;
    }

    public void setIsEncode(boolean isEncode) {
        this.isEncode = isEncode;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.answer);
        hash = 47 * hash + (this.isEncode ? 1 : 0);
        hash = 47 * hash + Objects.hashCode(this.question);
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
        final HuffmanED other = (HuffmanED) obj;
        if (this.isEncode != other.isEncode) {
            return false;
        }
        if (!Objects.equals(this.answer, other.answer)) {
            return false;
        }
        return Objects.equals(this.question, other.question);
    }

    @Override
    public String toString() {
        return "HuffmanED{" + "answer=" + answer + ", isEncode=" + isEncode + ", question=" + question + '}';
    }

}
