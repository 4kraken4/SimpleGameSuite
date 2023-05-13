package games.eightqueens.datamodel;

public final class Queen extends Piece {

    public Queen(Board board, int color, int xLoc, int yLoc) {
        super(board, color, xLoc, yLoc);
    }

    public boolean canMoveTo(int xPosition, int yPosition) {
        return canMoveToGenerics(xPosition, yPosition)
                ? queenMovement(xPosition, yPosition) : false;
    }

    private boolean queenMovement(int xPosition, int yPosition) {
        return isMovingStraight(xPosition, yPosition) || isMovingDiagonal(xPosition, yPosition);
    }
}
