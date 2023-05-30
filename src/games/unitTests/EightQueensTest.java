package games.unitTests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class EightQueensTest {
    
    private boolean isSafe(int[][] qns, int row, int col) {
        int BOARD_SIZE = qns.length;
        for (int i = 0; i < BOARD_SIZE; i++) {
            if (qns[row][i] == 1 && i != col) {
                return false;
            }
            if (qns[i][col] == 1 && i != row) {
                return false;
            }
        }
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (qns[i][j] == 1) {
                return false;
            }
        }
        for (int i = row - 1, j = col + 1; i >= 0 && j < BOARD_SIZE; i--, j++) {
            if (qns[i][j] == 1) {
                return false;
            }
        }
        for (int i = row + 1, j = col - 1; i < BOARD_SIZE && j >= 0; i++, j--) {
            if (qns[i][j] == 1) {
                return false;
            }
        }
        for (int i = row + 1, j = col + 1; i < BOARD_SIZE && j < BOARD_SIZE; i++, j++) {
            if (qns[i][j] == 1) {
                return false;
            }
        }
        return true;
    }
    
    @Test
    public void testSafe() {
        int[][] qns = {
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0}
        };
        int[] queens = {6, 4, 2, 0, 5, 7, 1, 3};

        for (int col = 0; col < queens.length; col++) {
            qns[queens[col]][col] = 1;
        }

        for (int i = 0; i < qns.length; i++) {
            for (int j = 0; j < qns[i].length; j++) {
                if (qns[i][j] == 1) {
                    Assertions.assertTrue(isSafe(qns, i, j));
                }
            }
        }
    }
}
