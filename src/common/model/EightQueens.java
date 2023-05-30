package common.model;

import java.util.Arrays;

public class EightQueens extends Game {

    public EightQueens() {
        answer = new int[8];
    }

    public EightQueens(int gameId, String gameTitle, String gameDescription, boolean isActive) {
        super(gameId, gameTitle, gameDescription, isActive);
        answer = new int[8];
    }

    public int[] getAnswer() {
        return answer;
    }

    public void setAnswer(int[] answer) {
        this.answer = answer;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 83 * hash + Arrays.hashCode(this.answer);
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
        final EightQueens other = (EightQueens) obj;
        return Arrays.equals(this.answer, other.answer);
    }

    @Override
    public String toString() {
        return "EightQueens{" + "answer=" + Arrays.toString(answer) + '}';
    }

    private int[] answer;
    public static final int GAME_ID = 1;
}
