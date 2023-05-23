package test;

public class Demo {
    private static int[][] board;
    private static int boardSize;

    public static void main(String[] args) {
        int n = 8;
        solveNQueens(n);
        printBoard();
    }

    private static void solveNQueens(int n) {
        boardSize = n;
        board = new int[boardSize][boardSize];

        if (placeQueens(0)) {
            System.out.println("Queens successfully placed!");
        } else {
            System.out.println("No solution exists for the given board size.");
        }
    }

    private static boolean placeQueens(int column) {
        if (column >= boardSize) {
            return true;
        }
        for (int row = 0; row < boardSize; row++) {
            if (isSafe(row, column)) {
                board[row][column] = 1;

                if (placeQueens(column + 1)) {
                    return true;
                }
                board[row][column] = 0;
            }
        }
        return false;
    }

    private static boolean isSafe(int row, int column) {
        for (int i = 0; i < column; i++) {
            if (board[row][i] == 1) {
                return false;
            }
        }
        for (int i = row, j = column; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }
        for (int i = row, j = column; i < boardSize && j >= 0; i++, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }
        return true;
    }

    private static void printBoard() {
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
