package test;

import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.FlatLightLaf;
import javax.swing.JButton;
import javax.swing.Timer;
import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class CloseButton extends JButton {

    private static final float MAXIMUM_VALUE = 1f;
    private static final float MINIMUM_VALUE = 0.35f;

    private float alpha = MINIMUM_VALUE;
    private boolean isHovered = false;

    private final Timer fadeTimer;

    private final ActionListener actionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            alpha += (isHovered ? 1 : -1) * 0.1f;
            alpha = isHovered ? Math.min(alpha, MAXIMUM_VALUE) : Math.max(alpha, MINIMUM_VALUE);
            if (alpha == MINIMUM_VALUE || alpha == MAXIMUM_VALUE) {
                fadeTimer.stop();
            }
            repaint();
        }
    };

    public CloseButton() {
        super("Play");
        fadeTimer = new Timer(45, actionListener);
        addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent e) {
                isHovered = true;
                if (!fadeTimer.isRunning()) {
                    fadeTimer.restart();
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                isHovered = false;
                if (!fadeTimer.isRunning()) {
                    fadeTimer.restart();
                }
            }

        });

        setBorderPainted(false);
        setContentAreaFilled(false);
        setFocusPainted(false);
        setFont(getFont().deriveFont(10.5f));

        fadeTimer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, alpha));
        g2d.drawString(getText(), getWidth() / 2 - g.getFontMetrics().stringWidth(getText()) / 2,
                getHeight() / 2 + g.getFontMetrics().getDescent());
    }

    public static void main(String[] args) {
        FlatLaf.setup(new FlatLightLaf());
        final javax.swing.JFrame frame = new javax.swing.JFrame("Test");
        javax.swing.JPanel panel = new javax.swing.JPanel();
        panel.add(new javax.swing.JLabel("Some random text"));
        CloseButton button = new CloseButton();
        button.addActionListener((java.awt.event.ActionEvent event) -> {
            java.awt.Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(
                    new java.awt.event.WindowEvent(frame, java.awt.event.WindowEvent.WINDOW_CLOSING));
        });
        panel.add(button);
        frame.add(panel);
        frame.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

}
