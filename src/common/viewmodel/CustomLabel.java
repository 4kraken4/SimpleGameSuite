package common.viewmodel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class CustomLabel extends JLabel {

    private boolean isHighlighted;
    private int overlayOpacity;
    private Color overlayColor;
    private Dimension iconSize;
    private ImageIcon iconOrg;
    public static Color COLOR_COLLISION = Color.RED, COLOR_SOLVED = Color.GREEN;

    @Override
    public void setIcon(Icon icon) {
        iconOrg = (ImageIcon) icon;
        if (icon != null) {
            ImageIcon scaleIcon = scaleIcon((ImageIcon) iconOrg, iconSize.width, iconSize.width);
            icon = scaleIcon;
        }
        super.setIcon(icon);
    }

    public int getOverlayOpacity() {
        return overlayOpacity;
    }

    public void setOverlayOpacity(int overlayOpacity) {
        this.overlayOpacity = overlayOpacity;
    }

    public Dimension getIconSize() {
        return iconSize;
    }

    public void setIconSize(Dimension iconSize) {
        this.iconSize = iconSize;
        this.setIcon(iconOrg);
    }

    public Color getOverlayColor() {
        return overlayColor;
    }

    public void setOverlayColor(Color overlayColor) {
        this.overlayColor = overlayColor;
    }

    public boolean isIsHighlighted() {
        return isHighlighted;
    }

    public void setIsHighlighted(boolean isHighlighted) {
        this.isHighlighted = isHighlighted;
        repaint();
    }

    public CustomLabel() {
        setOpaque(false);
        setBackground(new Color(0, 0, 0, 0));
        overlayOpacity = 128;
        setHorizontalAlignment(SwingUtilities.CENTER);
        setVerticalAlignment(SwingUtilities.CENTER);
        overlayColor = new Color(255, 0, 0, overlayOpacity);
        iconSize = new Dimension(256, 256);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        if (isHighlighted) {
            int width = getWidth();
            int height = getHeight();
            g2.setColor(new Color(overlayColor.getRed(), overlayColor.getGreen(), overlayColor.getBlue(), overlayOpacity));
            g2.fillRect(0, 0, width, height);
        }
        g2.dispose();
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
