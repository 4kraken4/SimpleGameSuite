package components.view;

public class GameMenu extends javax.swing.JPanel {

    public GameMenu() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        customButton1 = new components.models.CustomButton();
        customButton2 = new components.models.CustomButton();
        customButton3 = new components.models.CustomButton();
        customButton4 = new components.models.CustomButton();
        customButton5 = new components.models.CustomButton();

        setLayout(new java.awt.GridBagLayout());

        jPanel1.setLayout(new java.awt.GridLayout(5, 1, 0, 10));

        customButton1.setBackground(new java.awt.Color(36, 49, 54));
        customButton1.setForeground(new java.awt.Color(255, 255, 255));
        customButton1.setText("8 Queens");
        customButton1.setEffectColor(new java.awt.Color(124, 166, 180));
        customButton1.setFont(new java.awt.Font("Samsung Sans", 0, 24)); // NOI18N
        customButton1.setRoundness(0);
        jPanel1.add(customButton1);

        customButton2.setText("customButton2");
        customButton2.setRoundness(0);
        jPanel1.add(customButton2);

        customButton3.setText("customButton3");
        customButton3.setRoundness(0);
        jPanel1.add(customButton3);

        customButton4.setText("customButton4");
        customButton4.setRoundness(0);
        jPanel1.add(customButton4);

        customButton5.setText("customButton5");
        customButton5.setRoundness(0);
        jPanel1.add(customButton5);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 287;
        gridBagConstraints.ipady = 159;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 6, 6, 6);
        add(jPanel1, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private components.models.CustomButton customButton1;
    private components.models.CustomButton customButton2;
    private components.models.CustomButton customButton3;
    private components.models.CustomButton customButton4;
    private components.models.CustomButton customButton5;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
