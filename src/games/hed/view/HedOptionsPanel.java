package games.hed.view;

import java.awt.event.ActionListener;

public class HedOptionsPanel extends javax.swing.JPanel {

    public HedOptionsPanel() {
        initComponents();
    }
    
    public void onSelectEncode(ActionListener evt) {
        btnEncode.addActionListener(evt);
    }
    
    public void onSelectDecode(ActionListener evt) {
        btnDecode.addActionListener(evt);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btnDecode = new common.viewmodel.CustomButton();
        btnEncode = new common.viewmodel.CustomButton();

        setMaximumSize(new java.awt.Dimension(300, 200));
        setMinimumSize(new java.awt.Dimension(300, 200));
        setPreferredSize(new java.awt.Dimension(300, 200));
        setLayout(new java.awt.GridBagLayout());

        jPanel2.setPreferredSize(new java.awt.Dimension(300, 200));
        jPanel2.setLayout(new java.awt.BorderLayout(0, 50));

        jLabel1.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Select An Option.");
        jPanel2.add(jLabel1, java.awt.BorderLayout.NORTH);

        jPanel1.setLayout(new java.awt.GridLayout(2, 1, 0, 20));

        btnDecode.setText("DECODE");
        btnDecode.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        btnDecode.setPreferredSize(new java.awt.Dimension(70, 40));
        btnDecode.setRoundness(10);
        jPanel1.add(btnDecode);

        btnEncode.setText("ENCODE");
        btnEncode.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        btnEncode.setRoundness(10);
        jPanel1.add(btnEncode);

        jPanel2.add(jPanel1, java.awt.BorderLayout.CENTER);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 62;
        gridBagConstraints.ipady = 18;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 6, 6, 0);
        add(jPanel2, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private common.viewmodel.CustomButton btnDecode;
    private common.viewmodel.CustomButton btnEncode;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
