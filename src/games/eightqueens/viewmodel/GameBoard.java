package games.eightqueens.viewmodel;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class GameBoard extends JPanel {

    private int boardSize;
    private ImageIcon icn;
    private int[] queens;
    private JLabel[][] squares;

    public ImageIcon getIcn() {
        return icn;
    }

    public void setIcn(ImageIcon icn) {
        this.icn = icn;
    }

    public int getBoardSize() {
        return boardSize;
    }

    public void setBoardSize(int boardSize) {
        this.boardSize = boardSize;
    }

    public GameBoard() {
        setOpaque(false);
        setBackground(new Color(0, 0, 0, 0));
        initBoard();
    }

    public final void initBoard() {
        icn = setQueenIcon();
        boardSize = 8;
        queens = new int[boardSize];
        for (int i = 0; i < boardSize; i++) {
            queens[i] = -1;
        }
        this.setLayout(new GridLayout(boardSize, boardSize));
        squares = new JLabel[boardSize][boardSize];
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                squares[i][j] = new JLabel();
                squares[i][j].setOpaque(true);
                if ((i + j) % 2 == 0) {
                    squares[i][j].setBackground(Color.decode("#404258"));
                } else {
                    squares[i][j].setBackground(Color.decode("#F1F6F9"));
                }
                squares[i][j].setHorizontalAlignment(SwingConstants.CENTER);
                squares[i][j].setVerticalAlignment(SwingConstants.CENTER);
                final int row = i;
                final int col = j;
                squares[i][j].addMouseListener(new MouseAdapter() {
                    @Override
                    public void mousePressed(MouseEvent e) {
                        moveQueen(row, col);
                    }
                });
                add(squares[i][j]);
            }
        }
    }

    private void moveQueen(int row, int col) {
        if (queens != null) {
            if (queens[col] != -1) {
                squares[queens[col]][col].setIcon(null);
                queens[col] = -1;
            }
            if (squares[row][col].getIcon() == null) {
                squares[row][col].setIcon(icn);
                queens[col] = row;
            } else {
                squares[row][col].setIcon(null);
                queens[col] = -1;
            }
        }
    }

    private ImageIcon setQueenIcon() {
        ImageIcon imageIcon = null;
        File f = new File("src\\common\\icons\\chess-queen-gold.png");
        if (f.exists()) {
            try {
                BufferedImage bi = ImageIO.read(f);
                Image scaledInstance = bi.getScaledInstance(50, 50, BufferedImage.SCALE_SMOOTH);
                imageIcon = new ImageIcon(scaledInstance);
            } catch (IOException ex) {
                Logger.getLogger(GameBoard.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return imageIcon;
    }
}
