package test;

import com.formdev.flatlaf.ui.FlatLineBorder;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Test2 {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Chess Board UI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 1000);
        frame.setLayout(new GridBagLayout());
        JPanel board = new JPanel(new GridLayout(8, 8));
        board.setBorder(new FlatLineBorder(new Insets(1, 1, 1, 1), Color.BLACK));
        board.setPreferredSize(new Dimension(720, 720));
        Color darkSquareColor = Color.decode("#404258");
        Color lightSquareColor = Color.decode("#F1F6F9");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                JPanel square = new JPanel();
                if ((i + j) % 2 == 0) {
                    square.setBackground(lightSquareColor);
                } else {
                    square.setBackground(darkSquareColor);
                }
                board.add(square);
            }
        }
        frame.add(board);
        frame.setVisible(true);
    }
}
