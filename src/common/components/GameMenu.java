package common.components;

import common.events.MenuItemSelected;

public class GameMenu extends javax.swing.JPanel implements MenuItemSelected {

    public GameMenu() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        customButton1 = new common.viewmodel.CustomButton();
        customButton2 = new common.viewmodel.CustomButton();
        customButton3 = new common.viewmodel.CustomButton();
        customButton4 = new common.viewmodel.CustomButton();
        customButton5 = new common.viewmodel.CustomButton();

        setLayout(new java.awt.GridBagLayout());

        jPanel1.setLayout(new java.awt.GridLayout(5, 1, 0, 10));

        customButton1.setBackground(new java.awt.Color(36, 49, 54));
        customButton1.setForeground(new java.awt.Color(255, 255, 255));
        customButton1.setText("8 Queens");
        customButton1.setEffectColor(new java.awt.Color(116, 144, 155));
        customButton1.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 36)); // NOI18N
        jPanel1.add(customButton1);

        customButton2.setText("customButton2");
        jPanel1.add(customButton2);

        customButton3.setText("customButton3");
        jPanel1.add(customButton3);

        customButton4.setText("customButton4");
        jPanel1.add(customButton4);

        customButton5.setText("customButton5");
        jPanel1.add(customButton5);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 248;
        gridBagConstraints.ipady = 101;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 6, 6, 6);
        add(jPanel1, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private common.viewmodel.CustomButton customButton1;
    private common.viewmodel.CustomButton customButton2;
    private common.viewmodel.CustomButton customButton3;
    private common.viewmodel.CustomButton customButton4;
    private common.viewmodel.CustomButton customButton5;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

    @Override
    public void itemSelected(int itemIndex) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
