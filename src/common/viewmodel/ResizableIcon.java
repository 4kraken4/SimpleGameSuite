package common.viewmodel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.image.BufferedImage;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class ResizableIcon extends JLabel {

    private Dimension iconSize;
    private Icon originalIcon;

    public Dimension getIconSize() {
        return iconSize;
    }

    public void setIconSize(Dimension iconSize) {
        this.iconSize = iconSize;
        ImageIcon im = scaleIcon((ImageIcon) originalIcon, (int) iconSize.getWidth(), (int) iconSize.getHeight());
        super.setIcon(im);
        setSize(new Dimension((int) iconSize.getWidth(), (int) iconSize.getHeight()));
    }

    public ResizableIcon() {
        setBackground(new Color(0, 0, 0, 0));
        setOpaque(false);
//        setHorizontalAlignment(JLabel.CENTER);
//        setVerticalAlignment(JLabel.CENTER);
//        setMaximumSize(new Dimension(Integer.MAX_VALUE, Integer.MAX_VALUE));
        iconSize = new Dimension(64, 64);
        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                if (getIcon() != null) {
                    setIconSize(new Dimension(getWidth(), getHeight()));
                }
                super.componentResized(e);
            }
        });
    }

    @Override
    public void setIcon(Icon icon) {
        originalIcon = icon;
        ImageIcon scaledIcon = null;
        if (icon != null) {
            scaledIcon = scaleIcon((ImageIcon) icon, (int) iconSize.getWidth(), (int) iconSize.getHeight());
        }
        super.setIcon(scaledIcon);
    }

    private ImageIcon scaleIcon(ImageIcon icn, int maxWidth, int maxHeight) {
        BufferedImage image = new BufferedImage(icn.getIconWidth(), icn.getIconHeight(), BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = image.createGraphics();
        g2d.drawImage(icn.getImage(), 0, 0, null);
        g2d.dispose();
        int originalWidth = image.getWidth();
        int originalHeight = image.getHeight();
        double scaleFactor = Math.min((double) maxWidth / originalWidth, (double) maxHeight / originalHeight);
        int newWidth = (int) Math.round(originalWidth * scaleFactor);
        int newHeight = (int) Math.round(originalHeight * scaleFactor);
        Image scaledImage = image.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
        return new ImageIcon(scaledImage);
    }

}
