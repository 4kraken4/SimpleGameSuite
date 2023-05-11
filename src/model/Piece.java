package model;

public class Piece {

    public static final int BLACK = 0;
    public static final int WHITE = 1;
    private int xLocation;
    private int yLocation;
    private int color;
    protected boolean hasMoved;
    protected Board chessBoard;

    public Piece(Board board, int color) {
        this.chessBoard = board;
        this.color = color;
        hasMoved = false;
        xLocation = -1;
        yLocation = -1;
    }

    public Piece(Board board, int color, int xLocation, int yLocation) {
        this.chessBoard = board;
        this.color = color;
        this.hasMoved = false;
        this.xLocation = xLocation;
        this.yLocation = yLocation;
        chessBoard.placePiece(this, xLocation, yLocation);
    }

    public boolean canMoveTo(int xPosition, int yPosition) {
        return canMoveToGenerics(xPosition, yPosition);
    }

    protected boolean canMoveToGenerics(int xPosition, int yPosition) {
        if (chessBoard.isInBounds(xPosition, yPosition)) {
            Piece location = chessBoard.getPieceAt(xPosition, yPosition);
            if (location == null) {
                return true;
            }
            if (location.getColor() != this.color) {
                return true;
            }
        }
        return false;
    }

    public void moveTo(int xPosition, int yPosition) {
        if (chessBoard.getPieceAt(xLocation, yLocation) == this) {
            chessBoard.removePiece(this);
        }
        this.xLocation = xPosition;
        this.yLocation = yPosition;
        Piece target = chessBoard.getPieceAt(xPosition, yPosition);
        if (target != null) {
            this.capturePiece(target);
        }

        chessBoard.placePiece(this, xPosition, yPosition);
        hasMoved = true;
    }

    protected boolean isMovingStraight(int xPosition, int yPosition) {
        int currX = this.getXLocation();
        int currY = this.getYLocation();
        int smallerVal;
        int largerVal;
        if (currX == xPosition) {
            if (currY > yPosition) {
                smallerVal = yPosition;
                largerVal = currY;
            } else if (yPosition > currY) {
                smallerVal = currY;
                largerVal = yPosition;
            } else {
                return false;
            }
            smallerVal++;
            for (; smallerVal < largerVal; smallerVal++) {
                if (chessBoard.getPieceAt(currX, smallerVal) != null) {
                    return false;
                }
            }
            return true;
        }
        if (currY == yPosition) {
            if (currX > xPosition) {
                smallerVal = xPosition;
                largerVal = currX;
            } else if (xPosition > currX) {
                smallerVal = currX;
                largerVal = xPosition;
            } else {
                return false;
            }
            smallerVal++;
            for (; smallerVal < largerVal; smallerVal++) {
                if (chessBoard.getPieceAt(smallerVal, currY) != null) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    protected boolean isMovingDiagonal(int xPosition, int yPosition) {
        int xStart = 0;
        int yStart = 0;
        int xFinish = 1;
        int xTotal = Math.abs(xPosition - this.getXLocation());
        int yTotal = Math.abs(yPosition - this.getYLocation());
        if (xTotal == yTotal) {
            if (xPosition < this.getXLocation()) {
                xStart = xPosition;
                xFinish = this.getXLocation();
            } else if (xPosition > this.getXLocation()) {
                xStart = this.getXLocation();
                xFinish = xPosition;
            } else {
                return false;
            }
            if (yPosition < this.getYLocation()) {
                yStart = yPosition;
            } else if (yPosition > this.getYLocation()) {
                yStart = this.getYLocation();
            } else {
                return false;
            }
            xStart++;
            yStart++;
            for (; xStart < xFinish; xStart++, yStart++) {
                if (chessBoard.getPieceAt(xStart, yStart) != null) {
                    return false;
                }
            }

            return true;
        }

        return false;
    }

    public void removePiece() {
        chessBoard.removePiece(this);
        xLocation = -1;
        yLocation = -1;
    }

    public boolean onBoard() {
        return chessBoard.isInBounds(xLocation, yLocation);
    }

    public void capturePiece(Piece capturedPiece) {
        capturedPiece.removePiece();
    }

    public int getXLocation() {
        return xLocation;
    }

    public int getYLocation() {
        return yLocation;
    }

    private int getColor() {
        return color;
    }

}
