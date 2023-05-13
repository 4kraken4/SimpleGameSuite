package games.eightqueens.datamodel;

import java.util.LinkedList;
import java.util.List;

public class Game {

    private Board board;
    private List<Piece> pieces;

    public Game() {
        board = new Board(8, 8);
        pieces = new LinkedList<>();
    }

    public void gameLoop() {
        boolean continueGame = true;
        while (continueGame) {

        }
    }
}
