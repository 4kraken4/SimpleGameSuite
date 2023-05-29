package games.eq.model;

import common.events.GameWin;
import common.events.MenuItemSelected;
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
import java.util.Arrays;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class EqBoardModel extends JPanel {

    private int boardSize;
    private Icon icn;
    private int[] queens;
    private CustomLabel[][] squares;
    private Stack<Point> undo;
    private Stack<Point> redo;
    private int ubdoStepCount;
    private MenuItemSelected mis;
    private boolean isPathHighlighted;
    private GameWin win;
    public final static int GAME_ID = 1;

    public GameWin getWin() {
        return win;
    }

    public void setWin(GameWin win) {
        this.win = win;
    }

    public boolean isPathHighlighted() {
        return isPathHighlighted;
    }

    public void setPathHighlighted(boolean isPathHighlighted) {
        this.isPathHighlighted = isPathHighlighted;
    }

    public MenuItemSelected getMis() {
        return mis;
    }

    public void setMis(MenuItemSelected mis) {
        this.mis = mis;
    }

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

    public EqBoardModel() {
        setOpaque(false);
        setBackground(new Color(0, 0, 0, 0));
        ubdoStepCount = 5;
        isPathHighlighted = false;
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
        Point p = new Point(row, col);
        if (queens != null) {
            if (queens[p.y] != -1) {
                squares[queens[p.y]][p.y].setIcon(null);
                queens[p.y] = -1;
            }
            if (squares[p.x][p.y].getIcon() == null) {
                squares[p.x][p.y].setIcon(icn);
                queens[p.y] = row;
                stackMovesToUndo(p);
                visualHints(p);
                setUiForSolved();
            } else {
                squares[p.x][p.y].setIcon(null);
                queens[p.y] = -1;
            }
        }
    }

    private void setUiForSolved() {
        if (Arrays.stream(queens).filter(i -> i == -1).count() <= 0) {
            if (isSolved()) {
                for (int i = 0; i < queens.length; i++) {
                    squares[queens[i]][i].setOverlayColor(CustomLabel.COLOR_SOLVED);
                    squares[queens[i]][i].setIsHighlighted(true);
                }
                win.onGameWin(queens, null);
            } else {
                for (CustomLabel[] labels : squares) {
                    for (CustomLabel label : labels) {
                        label.setOverlayColor(CustomLabel.COLOR_COLLISION);
                    }
                }
            }
        }
    }

    private void stackMovesToUndo(Point p) {
        if (undo.size() >= ubdoStepCount) {
            undo.remove(undo.firstElement());
        }
        undo.push(p);
        redo.clear();
    }

    public void undo() {
        if (!undo.empty() && redo.size() < ubdoStepCount) {
            Point pop = undo.pop();
            moveQueen(pop.x, pop.y);
            redo.push(pop);
        }
    }

    public void redo() {
        if (!redo.empty() && undo.size() < ubdoStepCount) {
            Point pop = redo.pop();
            moveQueen(pop.x, pop.y);
            undo.push(pop);
        }
    }

    public void visualHints(Point current) {
        for (int row = 0; row < squares.length; row++) {
            for (int col = 0; col < squares[row].length; col++) {
                markCollisions(new Point(row, col), current);
                if (isPathHighlighted) {
                    highlightMovables(new Point(row, col), current);
                }
            }
        }
    }

    private void markCollisions(Point p, Point current) {
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

    private void highlightMovables(Point p, Point current) {
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

    private boolean isSolved() {
        int[][] qns = new int[squares.length][squares[0].length];
        for (int col = 0; col < queens.length; col++) {
            qns[queens[col]][col] = 1;
        }
        for (int i = 0; i < qns.length; i++) {
            for (int j = 0; j < qns[i].length; j++) {
                if (qns[i][j] == 1) {
                    if (!isSafe(qns, i, j)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private boolean isSafe(int[][] qns, int row, int col) {
        int BOARD_SIZE = qns.length;
        for (int i = 0; i < BOARD_SIZE; i++) {
            if (qns[row][i] == 1 && i != col) {
                return false;
            }
            if (qns[i][col] == 1 && i != row) {
                return false;
            }
        }
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (qns[i][j] == 1) {
                return false;
            }
        }
        for (int i = row - 1, j = col + 1; i >= 0 && j < BOARD_SIZE; i--, j++) {
            if (qns[i][j] == 1) {
                return false;
            }
        }
        for (int i = row + 1, j = col - 1; i < BOARD_SIZE && j >= 0; i++, j--) {
            if (qns[i][j] == 1) {
                return false;
            }
        }
        for (int i = row + 1, j = col + 1; i < BOARD_SIZE && j < BOARD_SIZE; i++, j++) {
            if (qns[i][j] == 1) {
                return false;
            }
        }
        return true;
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
                    Logger.getLogger(EqBoardModel.class.getName()).log(Level.SEVERE, null, ex);
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
