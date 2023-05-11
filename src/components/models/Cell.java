package components.models;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JPanel;

public class Cell extends JPanel {

    public Cell() {
        super();
        setOpaque(false);
        setBackground(new Color(0, 0, 0, 0));
        setMinimumSize(new Dimension(70, 70));
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON
        );
        g2.drawRect(0, 0, 70, 70);
        g2.dispose();
        super.paintComponent(g);
    }
    
    private void adaptToPosition(int rowIndex, int columnIndex) {
        if ((rowIndex + columnIndex) % 2 == 0) {
            setBackground(Color.decode("#404258"));
        } else {
            setBackground(Color.decode("#F1F6F9"));
        }
    }
    
}
