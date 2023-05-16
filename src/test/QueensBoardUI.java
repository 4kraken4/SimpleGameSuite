package test;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class QueensBoardUI extends JPanel {

    private static final int BOARD_SIZE = 8;
    private static final int SQUARE_SIZE = 50;

    private int[] queens = new int[BOARD_SIZE];

    private int draggingPiece = -1;
    private Point draggingOffset = new Point();

    public QueensBoardUI() {
        setLayout(new GridLayout(BOARD_SIZE, BOARD_SIZE));
        setPreferredSize(new Dimension(BOARD_SIZE * SQUARE_SIZE, BOARD_SIZE * SQUARE_SIZE));
        for (int i = 0; i < BOARD_SIZE; i++) {
            queens[i] = 0;
        }
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                int row = e.getY() / SQUARE_SIZE;
                int col = e.getX() / SQUARE_SIZE;
                if (queens[row] == col) {
                    draggingPiece = row;
                    draggingOffset.setLocation(e.getX() - queens[row] * SQUARE_SIZE, e.getY() - row * SQUARE_SIZE);
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                if (draggingPiece != -1) {
                    queens[draggingPiece] = e.getX() / SQUARE_SIZE;
                    draggingPiece = -1;
                    repaint();
                }
            }
        });
        addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                if (draggingPiece != -1) {
                    queens[draggingPiece] = (e.getX() - draggingOffset.x) / SQUARE_SIZE;
                    queens[draggingPiece] = Math.max(0, Math.min(BOARD_SIZE - 1, queens[draggingPiece]));
                    repaint();
                }
            }
        });
    }

    public void solve() {
        solve(0);
    }

    private boolean solve(int row) {
        if (row == BOARD_SIZE) {
            return true;
        }
        for (int col = 0; col < BOARD_SIZE; col++) {
            if (isValid(row, col)) {
                queens[row] = col;
                if (solve(row + 1)) {
                    return true;
                }
                queens[row] = 0;
            }
        }
        return false;
    }

    private boolean isValid(int row, int col) {
        for (int i = 0; i < row; i++) {
            if (queens[i] == col || queens[i] - col == i - row || queens[i] - col == row - i) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Draw the board
        for (int row = 0; row < BOARD_SIZE; row++) {
            for (int col = 0; col < BOARD_SIZE; col++) {
                if ((row + col) % 2 == 0) {
                    g.setColor(Color.WHITE);
                } else {
                    g.setColor(Color.GRAY);
                }
                g.fillRect(col * SQUARE_SIZE, row * SQUARE_SIZE, SQUARE_SIZE, SQUARE_SIZE);
            }
        }
        // Draw the queens
        for (int row = 0; row < BOARD_SIZE; row++) {
            g.setColor(Color.BLACK);
            g.fillOval(queens[row] * SQUARE_SIZE + SQUARE_SIZE / 4, row * SQUARE_SIZE + SQUARE_SIZE / 4,
                    SQUARE_SIZE / 2, SQUARE_SIZE / 2);
        }
        // Draw the dragging queen
        if (draggingPiece != -1) {
            g.setColor(Color.RED);
            g.fillOval(queens[draggingPiece] * SQUARE_SIZE + draggingOffset.x - SQUARE_SIZE / 4,
                    draggingPiece * SQUARE_SIZE + draggingOffset.y - SQUARE_SIZE / 4, SQUARE_SIZE / 2, SQUARE_SIZE / 2);
        }
    }

    public static void main(String[] args) {
        QueensBoardUI boardUI = new QueensBoardUI();
        JFrame frame = new JFrame("8 Queens Problem");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(boardUI);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

}
