package games.ttt.model;

import common.events.GameWin;
import common.viewmodel.CustomButton;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import util.GameSuiteLogger;

public class TttBoardModel extends JPanel implements ActionListener {

    private JPanel pnlTitle, btnPanel, startButtonPanel;
    private final GameSuiteLogger logger;
    public JLabel textfield;
    public CustomButton[] btns;
    private CustomButton btnStart;
    boolean playerTurn;
    private Color colorBgTitle, colorFgTitle, colorBgCell, colorX, colorO, colorBtnPanel;
    private Font fontTitle, fontCell;
    private GameWin win;
    public final static int GAME_ID = 2;

    public GameWin getWin() {
        return win;
    }

    public void setWin(GameWin win) {
        this.win = win;
    }

    public Color getColorBtnPanel() {
        return colorBtnPanel;
    }

    public void setColorBtnPanel(Color colorBtnPanel) {
        this.colorBtnPanel = colorBtnPanel;
        btnPanel.setBackground(colorBtnPanel);
    }

    public Color getColorX() {
        return colorX;
    }

    public void setColorX(Color colorX) {
        this.colorX = colorX;
    }

    public Color getColorO() {
        return colorO;
    }

    public void setColorO(Color colorO) {
        this.colorO = colorO;
    }

    public Color getColorBgCell() {
        return colorBgCell;
    }

    public void setColorBgCell(Color colorBgCell) {
        this.colorBgCell = colorBgCell;
        Component[] cmpts = btnPanel.getComponents();
        for (Component cmpt : cmpts) {
            if (cmpt instanceof CustomButton btn) {
                btn.setBackground(colorBgCell);
            }
        }
        btnStart.setBackground(colorBgCell);
    }

    public Font getFontCell() {
        return fontCell;
    }

    public void setFontCell(Font fontCell) {
        this.fontCell = fontCell;
        Component[] cmpts = btnPanel.getComponents();
        for (Component cmpt : cmpts) {
            if (cmpt instanceof CustomButton btn) {
                btn.setFont(fontCell);
            }
        }
    }

    public Font getFontTitle() {
        return fontTitle;
    }

    public void setFontTitle(Font fontTitle) {
        this.fontTitle = fontTitle;
        textfield.setFont(this.fontTitle);
        btnStart.setFont(fontTitle.deriveFont(16F));
    }

    public Color getColorFgTitle() {
        return colorFgTitle;
    }

    public void setColorFgTitle(Color colorFgTitle) {
        this.colorFgTitle = colorFgTitle;
        textfield.setForeground(colorFgTitle);
        btnStart.setForeground(colorFgTitle);
    }

    public Color getColorBgTitle() {
        return colorBgTitle;
    }

    public void setColorBgTitle(Color colorBgTitle) {
        this.colorBgTitle = colorBgTitle;
        textfield.setBackground(colorBgTitle);
    }

    public TttBoardModel() {
        setOpaque(false);
        setBackground(new Color(0, 0, 0, 0));
        initCOmponents();
        logger = GameSuiteLogger.getInstance();
    }

    private void initCOmponents() {
        pnlTitle = new JPanel();
        btnPanel = new JPanel();
        textfield = new JLabel();
        colorBgTitle = Color.WHITE;
        colorFgTitle = Color.ORANGE;
        colorBgCell = Color.WHITE;
        colorBtnPanel = Color.GRAY;
        colorO = Color.BLUE;
        colorX = Color.RED;
        fontTitle = new Font("Ink Free", Font.BOLD, 50);
        fontCell = new Font("MV Boli", Font.BOLD, 50);
        btns = new CustomButton[9];
        playerTurn = false;
        btnStart = new CustomButton();
        btnStart.setText("Start Game");
        btnStart.setFocusPainted(false);
        btnStart.setBackground(colorBgCell);
        btnStart.setForeground(colorFgTitle);
        btnStart.setFont(fontTitle.deriveFont(16F));
        textfield.setBackground(colorBgTitle);
        textfield.setForeground(colorFgTitle);
        textfield.setFont(fontTitle);
        textfield.setHorizontalAlignment(JLabel.CENTER);
        textfield.setVerticalAlignment(JLabel.CENTER);
        textfield.setText("Tic-Tac-Toe");
        textfield.setOpaque(true);
        pnlTitle.setLayout(new BorderLayout());
        pnlTitle.setBounds(0, 0, 800, 100);
        btnPanel.setLayout(new GridLayout(3, 3, 1, 1));
        btnPanel.setBackground(colorBtnPanel);
        for (int i = 0; i < 9; i++) {
            btns[i] = new CustomButton();
            btnPanel.add(btns[i]);
            btns[i].setFont(fontCell);
            btns[i].setBackground(colorBgCell);
            btns[i].setRoundness(0);
            btns[i].setFocusable(false);
            btns[i].addActionListener(this);
            btns[i].setEnabled(false);
            btns[i].setBorderPainted(true);
        }
        pnlTitle.add(textfield, BorderLayout.CENTER);
        startButtonPanel = new JPanel();
        startButtonPanel.setLayout(new BorderLayout());
        startButtonPanel.add(btnStart, BorderLayout.CENTER);
        btnStart.addActionListener((ActionEvent e) -> {
            String buttonText = btnStart.getText();
            if (buttonText.equals("Start Game")) {
                startGame();
                btnStart.setText("Reset Game");
            } else if (buttonText.equals("Reset Game")) {
                resetGame();
                btnStart.setText("Start Game");
            }
        });
        setLayout(new BorderLayout());
        add(pnlTitle, BorderLayout.NORTH);
        add(btnPanel, BorderLayout.CENTER);
        add(startButtonPanel, BorderLayout.SOUTH);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            for (int i = 0; i < 9; i++) {
                if (e.getSource() == btns[i]) {
                    if (playerTurn) {
                        if (btns[i].getText().equals("")) {
                            btns[i].setForeground(colorX);
                            btns[i].setText("X");
                            playerTurn = false;
                            textfield.setText("O turn");
                            if (!checkGameOver()) {
                                makeComputerMove();
                            }
                        }
                    }
                }
            }
        } catch (Exception ex) {
            logger.logError(TttBoardModel.class.getName(), ex);
        }
    }

    private void startGame() {
        playerTurn = true;
        textfield.setText("X turn");
        for (int i = 0; i < 9; i++) {
            btns[i].setEnabled(true);
            btns[i].setBackground(colorBgCell);
        }
    }

    private void resetGame() {
        for (int i = 0; i < 9; i++) {
            btns[i].setText("");
            btns[i].setEnabled(false);
            btns[i].setBackground(UIManager.getColor("Button.background"));
            textfield.setText("Tic-Tac-Toe");
        }
    }

    public boolean checkGameOver() {
        try {
            if (checkWin("X")) {
                int[] winningRow = getWinningRow("X");
                gameOver("X wins", winningRow);
                win.onGameWin("X", winningRow);
                return true;
            } else if (checkWin("O")) {
                int[] winningRow = getWinningRow("O");
                win.onGameWin("O", winningRow);
                gameOver("O wins", winningRow);
                return true;
            } else if (isBoardFull()) {
                gameOver("It's a draw", null);
                return true;
            }
            return false;
        } catch (Exception ex) {
            logger.logError(TttBoardModel.class.getName(), ex);
            return false;
        }
    }

    private boolean checkWin(String player) {
        try {
            String[][] board = new String[3][3];

            // Copy button texts to the 2D array
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    board[i][j] = btns[i * 3 + j].getText();
                }
            }

            // Define the winning conditions using indexes in the 2D array
            int[][] winningConditions = {
                {0, 1, 2}, // Rows
                {3, 4, 5},
                {6, 7, 8},
                {0, 3, 6}, // Columns
                {1, 4, 7},
                {2, 5, 8},
                {0, 4, 8}, // Diagonals
                {2, 4, 6}
            };

            // Check for a win
            for (int[] condition : winningConditions) {
                if (board[condition[0] / 3][condition[0] % 3].equals(player)
                        && board[condition[1] / 3][condition[1] % 3].equals(player)
                        && board[condition[2] / 3][condition[2] % 3].equals(player)) {
                    return true;
                }
            }

            return false;
        } catch (Exception ex) {
            logger.logError(TttBoardModel.class.getName(), ex);
            return false;
        }
    }

    private int[] getWinningRow(String symbol) {
        try {
            int[][] winningConditions = {
                {0, 1, 2}, // Rows
                {3, 4, 5},
                {6, 7, 8},
                {0, 3, 6}, // Columns
                {1, 4, 7},
                {2, 5, 8},
                {0, 4, 8}, // Diagonals
                {2, 4, 6}
            };

            for (int[] condition : winningConditions) {
                if (btns[condition[0]].getText().equals(symbol)
                        && btns[condition[1]].getText().equals(symbol)
                        && btns[condition[2]].getText().equals(symbol)) {
                    return condition;
                }
            }

            return null;
        } catch (Exception ex) {
            logger.logError(TttBoardModel.class.getName(), ex);
            return null;
        }
    }

    private boolean isBoardFull() {
        try {
            for (int i = 0; i < 9; i++) {
                if (btns[i].getText().equals("")) {
                    return false;
                }
            }
            return true;
        } catch (Exception ex) {
            logger.logError(TttBoardModel.class.getName(), ex);
            return false;
        }
    }

    private void gameOver(String message, int[] winningRow) {
        for (int i = 0; i < 9; i++) {
            btns[i].setEnabled(false);
            if (winningRow != null && isInWinningRow(i, winningRow)) {
                btns[i].setBackground(Color.GREEN);
            }
        }
        textfield.setText(message);
    }

    private boolean isInWinningRow(int buttonIndex, int[] winningRow) {
        for (int index : winningRow) {
            if (buttonIndex == index) {
                return true;
            }
        }
        return false;
    }

    private void makeComputerMove() {
        try {
            int bestScore = Integer.MIN_VALUE;
            int bestMove = -1;
            String[] board = new String[9];

            // Copy button texts to the array
            for (int i = 0; i < 9; i++) {
                board[i] = btns[i].getText();
            }

            // Find the best move using the Minimax algorithm
            for (int i = 0; i < 9; i++) {
                if (board[i].equals("")) {
                    board[i] = "O";
                    int score = minimax(board, 0, false);
                    board[i] = "";

                    if (score > bestScore) {
                        bestScore = score;
                        bestMove = i;
                    }
                }
            }

            // If no valid move found, choose a random available move
            if (bestMove == -1) {
                for (int i = 0; i < 9; i++) {
                    if (board[i].equals("")) {
                        bestMove = i;
                        break;
                    }
                }
            }

            // Make the optimal move for the computer
            btns[bestMove].setForeground(colorO);
            btns[bestMove].setText("O");
            playerTurn = true;
            textfield.setText("X turn");

            // Check if the game is over
            checkGameOver();
        } catch (Exception ex) {
            logger.logError(TttBoardModel.class.getName(), ex);
        }
    }

    private int minimax(String[] board, int depth, boolean isMaximizingPlayer) {
        if (checkWin("X")) {
            return -1; // X wins
        } else if (checkWin("O")) {
            return 1; // O wins
        } else if (isBoardFull()) {
            return 0; // Draw
        }

        if (isMaximizingPlayer) {
            int bestScore = Integer.MIN_VALUE;
            for (int i = 0; i < 9; i++) {
                if (board[i].equals("")) {
                    board[i] = "O";
                    int score = minimax(board, depth + 1, false);
                    board[i] = "";
                    bestScore = Math.max(score, bestScore);
                }
            }
            return bestScore;
        } else {
            int bestScore = Integer.MAX_VALUE;
            for (int i = 0; i < 9; i++) {
                if (board[i].equals("")) {
                    board[i] = "X";
                    int score = minimax(board, depth + 1, true);
                    board[i] = "";
                    bestScore = Math.min(score, bestScore);
                }
            }
            return bestScore;
        }
    }

    public void redo() {
    }

    public void undo() {
    }
}
