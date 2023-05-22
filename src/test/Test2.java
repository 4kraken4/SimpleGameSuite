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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(customLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addComponent(customLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(customLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(92, 92, 92)
                        .addComponent(customLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(35, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            FlatDarculaLaf.setup();
            new Test2().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private common.viewmodel.CustomLabel customLabel1;
    private common.viewmodel.CustomLabel customLabel2;
    // End of variables declaration//GEN-END:variables
}
