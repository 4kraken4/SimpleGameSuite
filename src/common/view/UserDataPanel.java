package common.view;

import common.events.UserActionPerformed;
import javax.swing.JFrame;

public class UserDataPanel extends javax.swing.JPanel {

    public UserDataPanel() {
        initComponents();
    }

    public UserActionPerformed getUap() {
        return uap;
    }

    public void setUap(UserActionPerformed uap) {
        this.uap = uap;
    }
    
    public void setPlayAsDefaultButton(JFrame frame) {
        frame.getRootPane().setDefaultButton(btnPlay);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        txtUsername = new common.viewmodel.CustomTextField();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btnPlay = new common.viewmodel.CustomButton();

        setLayout(new java.awt.GridBagLayout());

        jPanel4.setMinimumSize(new java.awt.Dimension(400, 250));
        jPanel4.setPreferredSize(new java.awt.Dimension(400, 250));
        jPanel4.setLayout(new java.awt.GridLayout(3, 1));

        jLabel2.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(231, 91, 76));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/common/icons/logo.png"))); // NOI18N
        jLabel2.setPreferredSize(new java.awt.Dimension(400, 70));
        jPanel4.add(jLabel2);

        jPanel2.setPreferredSize(new java.awt.Dimension(400, 100));

        txtUsername.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtUsername.setPreferredSize(new java.awt.Dimension(200, 30));

        jLabel1.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("Username");
        jLabel1.setPreferredSize(new java.awt.Dimension(70, 30));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(44, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jPanel4.add(jPanel2);

        jPanel1.setPreferredSize(new java.awt.Dimension(400, 68));

        btnPlay.setBackground(new java.awt.Color(19, 156, 151));
        btnPlay.setForeground(new java.awt.Color(255, 255, 255));
        btnPlay.setText("Play Game!");
        btnPlay.setEffectColor(new java.awt.Color(204, 255, 238));
        btnPlay.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        btnPlay.setPreferredSize(new java.awt.Dimension(335, 35));
        btnPlay.setRoundness(35);
        btnPlay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPlayActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnPlay, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(33, Short.MAX_VALUE)
                .addComponent(btnPlay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );

        jPanel4.add(jPanel1);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(25, 0, 25, 0);
        add(jPanel4, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void btnPlayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPlayActionPerformed
        String username = txtUsername.getText();
        this.uap.userInitialized(username);
    }//GEN-LAST:event_btnPlayActionPerformed

    private UserActionPerformed uap;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private common.viewmodel.CustomButton btnPlay;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private common.viewmodel.CustomTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
