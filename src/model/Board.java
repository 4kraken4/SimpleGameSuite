package model;

public final class Board {

    private Piece[][] board;

    public Board(int x, int y) {
        board = new Piece[x][y];
    }

    public boolean isEmptyPosition(int xLocation, int yLocation) {
        return isInBounds(xLocation, yLocation) && board[xLocation][yLocation] == null;
    }

    public Piece getPieceAt(int xLocation, int yLocation) {
        return isInBounds(xLocation, yLocation) ? board[xLocation][yLocation] : null;
    }

    public boolean isInBounds(int xLocation, int yLocation) {
        return xLocation >= 0 && xLocation < getXDimension() && yLocation >= 0 && yLocation < getYDimension();
    }

    public int getXDimension() {
        return board[0].length;
    }

    public int getYDimension() {
        return board.length;
    }

    public Piece[][] getBoard() {
        return board;
    }

    public void removePiece(Piece piece) {
        board[piece.getXLocation()][piece.getYLocation()] = null;
    }

    public void placePiece(Piece piece, int xPosition, int yPosition) {
        if (isInBounds(xPosition, yPosition)) {
            board[xPosition][yPosition] = piece;
        }
    }

    public void renderBOard() {
        for (int i = 0; i < getXDimension(); i++) {
            for (int j = 0; j < getYDimension(); j++) {

            }
        }
    }
}
