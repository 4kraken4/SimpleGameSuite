package common.view;

import java.awt.Cursor;
import java.awt.Point;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

public class MainWindow extends javax.swing.JFrame {

    public MainWindow() {
        initComponents();
        setUpCursor();
    }

    private void setUpCursor() {
        File f = new File("src\\common\\icons\\cursor-arrow.png");
        if (f.exists()) {
            try {
                Cursor customCursor = Toolkit.getDefaultToolkit().createCustomCursor(
                        ImageIO.read(f),
                        new Point(0, 0),
                        "Custom Cursor default"
                );
                setCursor(customCursor);
            } catch (IOException ex) {
                Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        gameMenu1 = new common.components.GameMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridBagLayout());
        getContentPane().add(gameMenu1, new java.awt.GridBagConstraints());

        setSize(new java.awt.Dimension(465, 464));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private common.components.GameMenu gameMenu1;
    // End of variables declaration//GEN-END:variables
}
