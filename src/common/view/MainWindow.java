package common.view;

import common.events.MenuItemSelected;
import games.eightqueens.view.EQBoardPanel;
import games.eightqueens.model.EQBoardModel;
import java.awt.Cursor;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import util.Utilities;

public class MainWindow extends javax.swing.JFrame {
    
    public MainWindow() {
        initComponents();
        setUpCursor();
        setMenuActions();
    }

    private void setMenuActions() {
        var mis = (MenuItemSelected) (ActionEvent evt) -> {
            String acmd = evt.getActionCommand();
            switch (acmd) {
                case "8 Queens" -> {
                    EQBoardPanel eqb = new EQBoardPanel();
                    setEQueenBtnActions(eqb);
                    Utilities.setUI(mainContainer, eqb);
                }
                case "Tic Tac Toe" -> {
                    EQBoardModel eq = new EQBoardModel();
                    Utilities.setUI(mainContainer, eq);
                }
                default ->
                    throw new AssertionError();
            }
        };
        gameMenu.setMis(mis);
    }

    private void setEQueenBtnActions(EQBoardPanel eqb) {
        var mis = (MenuItemSelected) (ActionEvent evt) -> {
            String acmd = evt.getActionCommand();
            switch (acmd) {
                case "close" -> {
                    Utilities.setUI(mainContainer, gameMenu);
                }
                default ->
                    throw new AssertionError();
            }
        };
        eqb.setMis(mis);
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

        mainContainer = new javax.swing.JPanel();
        gameMenu = new common.components.GameMenu();
        sidePanel1 = new common.components.SidePanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1200, 730));
        setResizable(false);

        mainContainer.setLayout(new java.awt.BorderLayout());
        mainContainer.add(gameMenu, java.awt.BorderLayout.CENTER);

        getContentPane().add(mainContainer, java.awt.BorderLayout.CENTER);
        getContentPane().add(sidePanel1, java.awt.BorderLayout.WEST);

        setSize(new java.awt.Dimension(1216, 738));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private common.components.GameMenu gameMenu;
    private javax.swing.JPanel mainContainer;
    private common.components.SidePanel sidePanel1;
    // End of variables declaration//GEN-END:variables
}
