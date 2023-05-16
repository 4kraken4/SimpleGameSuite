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
        lblDescription = new javax.swing.JLabel();
        resizableIcon1 = new common.viewmodel.ResizableIcon();

        jPanel1.setLayout(new java.awt.BorderLayout());

        jLabel1.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("8 Queens Problem");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel1.add(jLabel1, java.awt.BorderLayout.PAGE_START);

        lblDescription.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDescription.setText("<html><p align=\"justify\">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vivamus convallis blandit sollicitudin. Quisque volutpat quam vel arcu tristique accumsan. Aliquam erat volutpat. Nulla auctor nulla at vestibulum sollicitudin. Donec placerat libero a mi laoreet pellentesque. Fusce varius quis eros et ornare. Integer viverra, sapien non bibendum fringilla, tellus urna finibus mauris, non hendrerit elit diam aliquet arcu. Donec vel neque interdum, fringilla tellus sed, viverra lacus. Ut rutrum, dolor nec fringilla tincidunt, dolor dui pharetra velit, sit amet accumsan ligula lorem ac orci. Mauris eget congue est. Quisque egestas id nibh eget fringilla. Donec accumsan leo vel risus porta, at consectetur odio consectetur. Morbi massa nisl, laoreet porttitor posuere vel, rutrum molestie est.</p></html>");
        lblDescription.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel1.add(lblDescription, java.awt.BorderLayout.CENTER);

        resizableIcon1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        resizableIcon1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/common/icons/8-queens.png"))); // NOI18N
        resizableIcon1.setMaximumSize(new java.awt.Dimension(350, 350));
        resizableIcon1.setMinimumSize(new java.awt.Dimension(350, 350));
        resizableIcon1.setPreferredSize(new java.awt.Dimension(350, 350));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(resizableIcon1, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(resizableIcon1, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 358, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblDescription;
    private common.viewmodel.ResizableIcon resizableIcon1;
    // End of variables declaration//GEN-END:variables
}
