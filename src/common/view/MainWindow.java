package common.view;

import common.components.GameMenu;
import common.events.MenuItemSelected;
import games.eq.view.EqBoardPanel;
import games.ttt.view.TttBoardPanel;
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
//        setUpCursor();
//        setMenuActions();
    }

    private void setMenuActions() {
        var mis = (MenuItemSelected) (ActionEvent evt) -> {
            String acmd = evt.getActionCommand();
            switch (acmd) {
                case "8 Queens" -> {
                    EqBoardPanel eqb = new EqBoardPanel();
                    setEQueenBtnActions(eqb);
                    Utilities.setUI(mainContainer, eqb);
                }
                case "Tic Tac Toe" -> {
                    TttBoardPanel tbp = new TttBoardPanel();
                    setTttBtnActions(tbp);
                    Utilities.setUI(mainContainer, tbp);
                }
                case "Huff-Man Encrypt" -> {
                    TttBoardPanel tbp = new TttBoardPanel();
                    setTttBtnActions(tbp);
                    Utilities.setUI(mainContainer, tbp);
                }
                case "Get Me Out" -> {
                    TttBoardPanel tbp = new TttBoardPanel();
                    setTttBtnActions(tbp);
                    Utilities.setUI(mainContainer, tbp);
                }
                case "Uncle Prim" -> {
                    TttBoardPanel tbp = new TttBoardPanel();
                    setTttBtnActions(tbp);
                    Utilities.setUI(mainContainer, tbp);
                }
            }
        };
//        gameMenu.setMis(mis);
    }

    private void setEQueenBtnActions(EqBoardPanel eqb) {
        var mis = (MenuItemSelected) (ActionEvent evt) -> {
            String acmd = evt.getActionCommand();
            switch (acmd) {
                case "undo" -> {
                }
                case "redo" -> {
                }
                case "hint" -> {
                }
                case "close" -> {
//                    Utilities.setUI(mainContainer, gameMenu);
                }
            }
        };
        eqb.setMis(mis);
    }

    private void setTttBtnActions(TttBoardPanel tbp) {
        var mis = (MenuItemSelected) (ActionEvent evt) -> {
            String acmd = evt.getActionCommand();
            switch (acmd) {
                case "undo" -> {
                }
                case "redo" -> {
                }
                case "hint" -> {
                }
                case "close" -> {
//                    Utilities.setUI(mainContainer, gameMenu);
                }
            }
        };
        tbp.setMis(mis);
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
        userDataPanel1 = new common.view.UserDataPanel();
        sidePanel1 = new common.components.SidePanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1200, 730));
        setResizable(false);

        mainContainer.setLayout(new java.awt.BorderLayout());
        mainContainer.add(userDataPanel1, java.awt.BorderLayout.CENTER);

        getContentPane().add(mainContainer, java.awt.BorderLayout.CENTER);
        getContentPane().add(sidePanel1, java.awt.BorderLayout.WEST);

        setSize(new java.awt.Dimension(1216, 738));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    
    private GameMenu menu;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel mainContainer;
    private common.components.SidePanel sidePanel1;
    private common.view.UserDataPanel userDataPanel1;
    // End of variables declaration//GEN-END:variables
}
