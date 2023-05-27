package common.view;

import common.events.MenuItemSelected;
import common.viewmodel.CustomButton;
import java.awt.Component;

public class GameMenu extends javax.swing.JPanel {

    private MenuItemSelected mis;

    public MenuItemSelected getMis() {
        return mis;
    }

    public void setMis(MenuItemSelected mis) {
        this.mis = mis;
    }

    public GameMenu() {
        initComponents();
        attachActionHandlers();
    }

    private void attachActionHandlers() {
        Component[] components = container.getComponents();
        for (Component component : components) {
            if (component instanceof CustomButton btn) {
                btn.addActionListener((e) -> {
                    mis.itemSelected(e);
                });
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        container = new javax.swing.JPanel();
        mi8Queens = new common.viewmodel.CustomButton();
        miTicTacToe = new common.viewmodel.CustomButton();
        customButton3 = new common.viewmodel.CustomButton();
        customButton4 = new common.viewmodel.CustomButton();
        customButton5 = new common.viewmodel.CustomButton();

        setLayout(new java.awt.GridBagLayout());

        container.setLayout(new java.awt.GridLayout(5, 1, 0, 10));

        mi8Queens.setBackground(new java.awt.Color(36, 49, 54));
        mi8Queens.setForeground(new java.awt.Color(255, 255, 255));
        mi8Queens.setText("8 Queens");
        mi8Queens.setEffectColor(new java.awt.Color(215, 215, 215));
        mi8Queens.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 28)); // NOI18N
        mi8Queens.setRoundness(20);
        container.add(mi8Queens);

        miTicTacToe.setBackground(new java.awt.Color(36, 49, 54));
        miTicTacToe.setForeground(new java.awt.Color(255, 255, 255));
        miTicTacToe.setText("Tic Tac Toe");
        miTicTacToe.setEffectColor(new java.awt.Color(215, 215, 215));
        miTicTacToe.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 28)); // NOI18N
        miTicTacToe.setRoundness(20);
        container.add(miTicTacToe);

        customButton3.setBackground(new java.awt.Color(36, 49, 54));
        customButton3.setForeground(new java.awt.Color(255, 255, 255));
        customButton3.setText("Huff-Man Encrypt");
        customButton3.setEffectColor(new java.awt.Color(215, 215, 215));
        customButton3.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 28)); // NOI18N
        customButton3.setRoundness(20);
        container.add(customButton3);

        customButton4.setBackground(new java.awt.Color(36, 49, 54));
        customButton4.setForeground(new java.awt.Color(255, 255, 255));
        customButton4.setText("Get Me Out");
        customButton4.setEffectColor(new java.awt.Color(215, 215, 215));
        customButton4.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 28)); // NOI18N
        customButton4.setRoundness(20);
        container.add(customButton4);

        customButton5.setBackground(new java.awt.Color(36, 49, 54));
        customButton5.setForeground(new java.awt.Color(255, 255, 255));
        customButton5.setText("Uncle Prim");
        customButton5.setEffectColor(new java.awt.Color(215, 215, 215));
        customButton5.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 28)); // NOI18N
        customButton5.setRoundness(20);
        container.add(customButton5);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 190;
        gridBagConstraints.ipady = 151;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        add(container, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel container;
    private common.viewmodel.CustomButton customButton3;
    private common.viewmodel.CustomButton customButton4;
    private common.viewmodel.CustomButton customButton5;
    private common.viewmodel.CustomButton mi8Queens;
    private common.viewmodel.CustomButton miTicTacToe;
    // End of variables declaration//GEN-END:variables

}
