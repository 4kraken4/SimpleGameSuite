package common.components;

public class SidePanel extends javax.swing.JPanel {

    public SidePanel() {
        initComponents();
        setDescription();
    }

    public void setDescription() {
        lblDescription.setText(
                "<html>"
                + "<p align=\"justify\">"
                + "Lorem ipsum dolor sit amet, consectetur adipiscing elit. "
                + "Vivamus convallis blandit sollicitudin. Quisque volutpat quam vel arcu tristique accumsan. "
                + "Aliquam erat volutpat. Nulla auctor nulla at vestibulum sollicitudin. "
                + "Donec placerat libero a mi laoreet pellentesque. "
                + "Fusce varius quis eros et ornare. "
                + "Integer viverra, sapien non bibendum fringilla, tellus urna finibus mauris, non hendrerit elit diam aliquet arcu. "
                + "Donec vel neque interdum, fringilla tellus sed, viverra lacus. "
                + "Ut rutrum, dolor nec fringilla tincidunt, dolor dui pharetra velit, sit amet accumsan ligula lorem ac orci. "
                + "Mauris eget congue est. "
                + "Quisque egestas id nibh eget fringilla. "
                + "Donec accumsan leo vel risus porta, at consectetur odio consectetur. "
                + "Morbi massa nisl, laoreet porttitor posuere vel, rutrum molestie est."
                + "</p>"
                + "</html>");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        lblDescription = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        customLabel1 = new common.viewmodel.CustomLabel();

        jPanel1.setLayout(new java.awt.BorderLayout());

        jLabel1.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("8 Queens Problem");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel1.add(jLabel1, java.awt.BorderLayout.NORTH);

        lblDescription.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        lblDescription.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDescription.setText("<html><p align=\"justify\">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vivamus convallis blandit sollicitudin. Quisque volutpat quam vel arcu tristique accumsan. Aliquam erat volutpat. Nulla auctor nulla at vestibulum sollicitudin. Donec placerat libero a mi laoreet pellentesque. Fusce varius quis eros et ornare. Integer viverra, sapien non bibendum fringilla, tellus urna finibus mauris, non hendrerit elit diam aliquet arcu. Donec vel neque interdum, fringilla tellus sed, viverra lacus. Ut rutrum, dolor nec fringilla tincidunt, dolor dui pharetra velit, sit amet accumsan ligula lorem ac orci. Mauris eget congue est. Quisque egestas id nibh eget fringilla. Donec accumsan leo vel risus porta, at consectetur odio consectetur. Morbi massa nisl, laoreet porttitor posuere vel, rutrum molestie est.</p></html>");
        lblDescription.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lblDescription.setPreferredSize(new java.awt.Dimension(400, 250));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(lblDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblDescription, javax.swing.GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.add(jPanel3, java.awt.BorderLayout.CENTER);

        customLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/common/icons/8-queens.png"))); // NOI18N
        customLabel1.setIconSize(new java.awt.Dimension(350, 350));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(customLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(customLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 368, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private common.viewmodel.CustomLabel customLabel1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lblDescription;
    // End of variables declaration//GEN-END:variables
}
