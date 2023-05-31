package games.unitTests;

import games.ttt.model.TttBoardModel;

public class TicTacToeTest {

    private TttBoardModel game;

    public void setUp() {
        game = new TttBoardModel();
    }

    public void testPlayerWins() {
        game.btns[0].setText("X");
        game.btns[1].setText("O");
        game.btns[3].setText("X");
        game.btns[4].setText("O");
        game.btns[6].setText("X");

        boolean gameOver = game.checkGameOver();

        System.out.println("isGameOver: " + gameOver);
        System.out.println("X wins" + game.textfield.getText());
    }

    public void testDraw() {
        game.btns[0].setText("X");
        game.btns[1].setText("O");
        game.btns[2].setText("X");
        game.btns[3].setText("X");
        game.btns[4].setText("O");
        game.btns[5].setText("X");
        game.btns[6].setText("O");
        game.btns[7].setText("X");
        game.btns[8].setText("O");

        boolean gameOver = game.checkGameOver();

        System.out.println("isGameOver: " + gameOver);
        System.out.println("It's a draw" + game.textfield.getText());
    }

    public void testGameContinues() {
        game.btns[0].setText("X");
        game.btns[1].setText("O");
        game.btns[3].setText("X");
        game.btns[4].setText("O");

        boolean gameOver = game.checkGameOver();

        System.out.println("isGameOver: " + gameOver);
        System.out.println("O turn" + game.textfield.getText());
    }
}
