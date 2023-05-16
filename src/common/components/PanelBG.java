package common.components;

import java.awt.*;
import javax.swing.*;

public class PanelBG extends JPanel {

    private Icon image;

    public Icon getImage() {
        return image;
    }

    public void setImage(Icon image) {
        this.image = image;
        repaint();
    }

    public PanelBG() {
        setOpaque(false);
        setBackground(new Color(0, 0, 0, 0));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (image != null) {
            drawImmage(g);
        }
    }

    public void drawImmage(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.drawImage(((ImageIcon) image).getImage(), getWidth(), getHeight(), null);
        g2d.dispose();
    }
}
