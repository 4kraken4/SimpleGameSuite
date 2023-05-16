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
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel2 = new javax.swing.JPanel();
        gameMenu2 = new common.components.GameMenu();
        sidePanel1 = new common.components.SidePanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setLayout(new java.awt.GridBagLayout());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(182, 6, 120, 4);
        jPanel2.add(gameMenu2, gridBagConstraints);

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);
        getContentPane().add(sidePanel1, java.awt.BorderLayout.WEST);

        setSize(new java.awt.Dimension(807, 728));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private common.components.GameMenu gameMenu2;
    private javax.swing.JPanel jPanel2;
    private common.components.SidePanel sidePanel1;
    // End of variables declaration//GEN-END:variables
}
