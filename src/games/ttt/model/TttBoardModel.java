package games.ttt.model;

import common.viewmodel.CustomButton;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;

public class TttBoardModel extends JPanel implements ActionListener {

    private boolean isdraw = true;
    private Random random;
    private JPanel pnlTitle, btnPanel, startButtonPanel;
    private JLabel textfield;
    private CustomButton[] btns;
    private CustomButton btnStart;
    boolean playerTurn;
    private Color colorBgTitle, colorFgTitle, colorBgCell, colorX, colorO, colorBtnPanel;
    private Font fontTitle, fontCell;

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
    }

    private void initCOmponents() {
        random = new Random();
        pnlTitle = new JPanel();
        btnPanel = new JPanel();
        textfield = new JLabel();
        colorBgTitle = Color.WHITE;
        colorFgTitle = Color.ORANGE;
        colorBgCell = Color.WHITE;
        colorBtnPanel = Color.GRAY;
        colorO = Color.RED;
        colorX = Color.BLUE;
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
        for (int i = 0; i < 9; i++) {
            if (e.getSource() == btns[i]) {
                if (playerTurn) {
                    if (btns[i].getText().equals("")) {
                        btns[i].setForeground(colorO);
                        btns[i].setText("X");
                        playerTurn = false;
                        textfield.setText("O turn");
                        check();
                    }
                } else {
                    if (btns[i].getText().equals("")) {
                        btns[i].setForeground(colorX);
                        btns[i].setText("O");
                        playerTurn = true;
                        textfield.setText("X turn");
                        check();
                    }
                }
            }
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

    private void firstTurn() {
        if (random.nextInt(2) == 0) {
            playerTurn = true;
            textfield.setText("X turn");
        } else {
            playerTurn = false;
            textfield.setText("O turn");
        }
    }

    private void resetGame() {
        for (int i = 0; i < 9; i++) {
            btns[i].setText("");
            btns[i].setEnabled(false);
            btns[i].setBackground(UIManager.getColor("Button.background"));
        }
    }

    private void check() {
       
            if (btns[0].getText().equals("X") && btns[1].getText().equals("X") && btns[2].getText().equals("X")) {
                isdraw = xWins(0, 1, 2);
            }
            if (btns[3].getText().equals("X") && btns[4].getText().equals("X") && btns[5].getText().equals("X")) {
                isdraw = xWins(3, 4, 5);
            }
            if (btns[6].getText().equals("X") && btns[7].getText().equals("X") && btns[8].getText().equals("X")) {
                isdraw = xWins(6, 7, 8);
            }
            if (btns[0].getText().equals("X") && btns[3].getText().equals("X") && btns[6].getText().equals("X")) {
                isdraw = xWins(0, 3, 6);
            }
            if (btns[1].getText().equals("X") && btns[4].getText().equals("X") && btns[7].getText().equals("X")) {
                isdraw = xWins(1, 4, 7);
            }
            if (btns[2].getText().equals("X") && btns[5].getText().equals("X") && btns[8].getText().equals("X")) {
                isdraw = xWins(2, 5, 8);
            }
            if (btns[0].getText().equals("X") && btns[4].getText().equals("X") && btns[8].getText().equals("X")) {
                isdraw = xWins(0, 4, 8);
            }
            if (btns[2].getText().equals("X") && btns[4].getText().equals("X") && btns[6].getText().equals("X")) {
                isdraw = xWins(2, 4, 6);
            }
            if (btns[0].getText().equals("O") && btns[1].getText().equals("O") && btns[2].getText().equals("O")) {
                isdraw = oWins(0, 1, 2);
            }
            if (btns[3].getText().equals("O") && btns[4].getText().equals("O") && btns[5].getText().equals("O")) {
                isdraw = oWins(3, 4, 5);
            }
            if (btns[6].getText().equals("O") && btns[7].getText().equals("O") && btns[8].getText().equals("O")) {
                isdraw = oWins(6, 7, 8);
            }
            if (btns[0].getText().equals("O") && btns[3].getText().equals("O") && btns[6].getText().equals("O")) {
                oWins(0, 3, 6);
            }
            if (btns[1].getText().equals("O") && btns[4].getText().equals("O") && btns[7].getText().equals("O")) {
                isdraw = oWins(1, 4, 7);
            }
            if (btns[2].getText().equals("O") && btns[5].getText().equals("O") && btns[8].getText().equals("O")) {
                isdraw = oWins(2, 5, 8);
            }
            if (btns[0].getText().equals("O") && btns[4].getText().equals("O") && btns[8].getText().equals("O")) {
                isdraw = oWins(0, 4, 8);
            }
            if (btns[2].getText().equals("O") && btns[4].getText().equals("O") && btns[6].getText().equals("O")) {
                isdraw = oWins(2, 4, 6);
            }
        
        boolean draw = true;
        for (int i = 0; i < 9; i++) {
            if (btns[i].getText().equals("")) {
                draw = false;
                break;
            }
        }
        if (draw) {
            for (int i = 0; i < 9; i++) {
                btns[i].setEnabled(false);
            }
            if (isdraw) {
                textfield.setText("It's a draw");
            }
        }
    }

    private boolean xWins(int a, int b, int c) {
        btns[a].setBackground(Color.GREEN);
        btns[b].setBackground(Color.GREEN);
        btns[c].setBackground(Color.GREEN);
        for (int i = 0; i < 9; i++) {
            btns[i].setEnabled(false);
        }
        textfield.setText("X wins");
        return false;
    }

    private boolean oWins(int a, int b, int c) {
        btns[a].setBackground(Color.GREEN);
        btns[b].setBackground(Color.GREEN);
        btns[c].setBackground(Color.GREEN);
        for (int i = 0; i < 9; i++) {
            btns[i].setEnabled(false);
        }
        textfield.setText("O wins");
        return false;
    }

    public void redo() {
    }

    public void undo() {
    }
}
