/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

/**
 *
 * @author Shenal Ockersz
 */
import games.ttt.model.TttBoardModel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TicTacToeTest {
    private TttBoardModel game;

    @BeforeEach
    public void setUp() {
        game = new TttBoardModel();
    }

    @Test
    public void testPlayerWins() {
        game.btns[0].setText("X");
        game.btns[1].setText("O");
        game.btns[3].setText("X");
        game.btns[4].setText("O");
        game.btns[6].setText("X");

        boolean gameOver = game.checkGameOver();

        Assertions.assertTrue(gameOver);
        Assertions.assertEquals("X wins", game.textfield.getText());
    }

    @Test
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

        Assertions.assertTrue(gameOver);
        Assertions.assertEquals("It's a draw", game.textfield.getText());
    }

    @Test
    public void testGameContinues() {
        game.btns[0].setText("X");
        game.btns[1].setText("O");
        game.btns[3].setText("X");
        game.btns[4].setText("O");

        boolean gameOver = game.checkGameOver();

        Assertions.assertFalse(gameOver);
        Assertions.assertEquals("O turn", game.textfield.getText());
    }
}
