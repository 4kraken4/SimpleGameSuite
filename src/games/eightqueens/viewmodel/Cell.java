package games.eightqueens.viewmodel;

import java.awt.Color;
import javax.swing.JPanel;

public class Cell extends JPanel {

    public Cell() {
        setOpaque(true);
        setBackground(new Color(0, 0, 0, 0));
    }
    
    public Cell(int row, int col) {
        setOpaque(true);
        setBackground(new Color(0, 0, 0, 0));
        adaptToPosition(row, col);
    }

    private void adaptToPosition(int rowIndex, int columnIndex) {
        if ((rowIndex + columnIndex) % 2 == 0) {
            setBackground(Color.decode("#404258"));
        } else {
            setBackground(Color.decode("#F1F6F9"));
        }
    }

}
