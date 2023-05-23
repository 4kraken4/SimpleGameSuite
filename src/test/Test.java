package test;

public class Test extends javax.swing.JFrame {

    public Test() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        gameBoard1 = new games.eq.model.EqBoardModel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(550, 550));

        gameBoard1.setIcn(null);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(gameBoard1, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(gameBoard1, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new Test().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private games.eq.model.EqBoardModel gameBoard1;
    // End of variables declaration//GEN-END:variables
}
