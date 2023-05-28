package test;

import com.formdev.flatlaf.FlatDarculaLaf;

public class Test2 extends javax.swing.JFrame {

    public Test2() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        customLabel1 = new common.viewmodel.CustomLabel();
        customLabel2 = new common.viewmodel.CustomLabel();
        customButton1 = new common.viewmodel.CustomButton();
        jButton1 = new javax.swing.JButton();
        liquidProgress1 = new common.viewmodel.LiquidProgress();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        customLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/common/icons/8-queens.png"))); // NOI18N
        customLabel1.setOverlayColor(new java.awt.Color(255, 102, 102));
        customLabel1.setOverlayOpacity(64);

        customLabel2.setBackground(new java.awt.Color(64, 66, 88));
        customLabel2.setForeground(new java.awt.Color(255, 255, 255));
        customLabel2.setText("Ssample Text");
        customLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        customLabel2.setIsHighlighted(true);
        customLabel2.setOpaque(true);
        customLabel2.setOverlayColor(new java.awt.Color(0, 204, 255));

        customButton1.setFocusPainted(false);
        customButton1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/common/icons/lightbulb-line.png"))); // NOI18N
        customButton1.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/common/icons/lightbulb-fill.png"))); // NOI18N

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/common/icons/lightbulb-line.png"))); // NOI18N
        jButton1.setFocusPainted(false);
        jButton1.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/common/icons/lightbulb-fill.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(customLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(liquidProgress1, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(customLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(customButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(38, 38, 38))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(customLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31)
                                .addComponent(customButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(180, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(customLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(liquidProgress1, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        jButton1.setSelected(!jButton1.isSelected());
    }//GEN-LAST:event_jButton1ActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            FlatDarculaLaf.setup();
            new Test2().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private common.viewmodel.CustomButton customButton1;
    private common.viewmodel.CustomLabel customLabel1;
    private common.viewmodel.CustomLabel customLabel2;
    private javax.swing.JButton jButton1;
    private common.viewmodel.LiquidProgress liquidProgress1;
    // End of variables declaration//GEN-END:variables
}
