package common.model;

import java.util.Arrays;

public class TicTacToe extends Game {

    public TicTacToe() {
        answer = new int[3];
    }

    public TicTacToe(int gameId, String gameTitle, String gameDescription, boolean isActive) {
        super(gameId, gameTitle, gameDescription, isActive);
        answer = new int[3];
    }

    public int[] getAnswer() {
        return answer;
    }

    public void setAnswer(int[] answer) {
        this.answer = answer;
    }

    public boolean isIsX() {
        return isX;
    }

    public void setIsX(boolean isX) {
        this.isX = isX;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Arrays.hashCode(this.answer);
        hash = 67 * hash + (this.isX ? 1 : 0);
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
        final TicTacToe other = (TicTacToe) obj;
        if (this.isX != other.isX) {
            return false;
        }
        return Arrays.equals(this.answer, other.answer);
    }

    @Override
    public String toString() {
        return "TicTacToe{" + "answer=" + Arrays.toString(answer) + ", isX=" + isX + '}';
    }

    private int[] answer;
    private boolean isX;
    public static final int GAME_ID = 2;
}
