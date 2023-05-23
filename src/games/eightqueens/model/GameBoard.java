package games.eightqueens.model;

import common.viewmodel.CustomLabel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class GameBoard extends JPanel {

    private int boardSize;
    private Icon icn;
    private int[] queens;
    private CustomLabel[][] squares;
    private Stack<Point> undo;
    private Stack<Point> redo;

    public Icon getIcn() {
        return icn;
    }

    public void setIcn(Icon icn) {
        this.icn = icn;
        setQueenIcon();
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
        undo = new Stack<>();
        redo = new Stack<>();
        initBoard();
    }

    public final void initBoard() {
        setQueenIcon();
        boardSize = 8;
        queens = new int[boardSize];
        for (int i = 0; i < boardSize; i++) {
            queens[i] = -1;
        }
        this.setLayout(new GridLayout(boardSize, boardSize));
        squares = new CustomLabel[boardSize][boardSize];
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                squares[i][j] = new CustomLabel();
                squares[i][j].setOpaque(true);
                squares[i][j].setIconSize(new Dimension(50, 50));
                squares[i][j].setOverlayOpacity(128);
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
                visualHints(new Point(row, col));
            } else {
                squares[row][col].setIcon(null);
                queens[col] = -1;
            }
        }
    }

    public void visualHints(Point current) {
        for (int i = 0; i < squares.length; i++) {
            for (int j = 0; j < squares[i].length; j++) {
                markCollisions(new Point(i, j), current);
//                highlightMovables(new Point(i, j), current);
            }
        }
    }

    public void markCollisions(Point p, Point current) {
        int i = p.x;
        int j = p.y;
        boolean horizonal = i == current.x || j == current.y;
        boolean diagonal = Math.abs(i - current.x) == Math.abs(j - current.y);
        if (horizonal || diagonal) {
            if (!p.equals(current)) {
                int preOpacity = squares[i][j].getOverlayOpacity();
                if (queens[j] == i) {
                    squares[i][j].setOverlayOpacity(150);
                    squares[i][j].setIsHighlighted(true);
                } else {
                    squares[i][j].setIsHighlighted(false);
                    squares[i][j].setOverlayOpacity(preOpacity);
                }
            } else {
                squares[i][j].setIsHighlighted(false);
            }
        } else {
            squares[i][j].setIsHighlighted(false);
        }
    }

    public void highlightMovables(Point p, Point current) {
        int i = p.x;
        int j = p.y;
        boolean horizonal = i == current.x || j == current.y;
        boolean diagonal = Math.abs(i - current.x) == Math.abs(j - current.y);
        if (horizonal || diagonal) {
            squares[i][j].setIsHighlighted(true);
            if (p.equals(current)) {
                squares[i][j].setIsHighlighted(false);
            }
        } else {
            squares[i][j].setIsHighlighted(false);
        }
    }

    private void setQueenIcon() {
        BufferedImage bi = null;
        if (icn != null) {
            bi = new BufferedImage(icn.getIconWidth(), icn.getIconHeight(), BufferedImage.TYPE_INT_ARGB);
            Graphics2D g2 = bi.createGraphics();
            g2.drawImage(((ImageIcon) icn).getImage(), 0, 0, null);
            g2.dispose();
        } else {
            File f = new File("src\\common\\icons\\chess-queen-gold.png");
            if (f.exists()) {
                try {
                    bi = ImageIO.read(f);
                } catch (IOException ex) {
                    Logger.getLogger(GameBoard.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        if (bi != null) {
            Image scaledInstance = bi.getScaledInstance(40, 40, BufferedImage.SCALE_SMOOTH);
            icn = new ImageIcon(scaledInstance);
            return;
        }
        bi = new BufferedImage(50, 50, BufferedImage.SCALE_SMOOTH);
        Graphics2D g2 = bi.createGraphics();
        g2.drawOval(0, 0, 50, 50);
        g2.dispose();
        icn = new ImageIcon(bi);
    }
}
