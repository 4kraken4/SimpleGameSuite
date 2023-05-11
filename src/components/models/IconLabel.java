package components.models;

import java.awt.Color;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class IconLabel extends JLabel {

    private int iconSize;

    public int getIconSize() {
        return iconSize;
    }

    public void setIconSize(int iconSize) {
        this.iconSize = iconSize;
        reSizeIcon();
    }
    
    public IconLabel() {
        setBackground(new Color(0, 0, 0, 0));
        setOpaque(false);
        iconSize = 64;
        reSizeIcon();
    }
    
    
    private void reSizeIcon() {
        if (getIcon() != null) {
            ImageIcon resizedIcon = new ImageIcon(((ImageIcon) getIcon())
                    .getImage()
                    .getScaledInstance(100, 100, Image.SCALE_SMOOTH));
            setIcon(resizedIcon);
        }
    }

}
