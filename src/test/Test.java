package test;

public class Test extends javax.swing.JFrame {

    public Test() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tttBoardModel1 = new games.ttt.model.TttBoardModel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(550, 550));

        tttBoardModel1.setFontTitle(new java.awt.Font("Arial Rounded MT Bold", 0, 36)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tttBoardModel1, javax.swing.GroupLayout.DEFAULT_SIZE, 557, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tttBoardModel1, javax.swing.GroupLayout.DEFAULT_SIZE, 520, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new Test().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private games.ttt.model.TttBoardModel tttBoardModel1;
    // End of variables declaration//GEN-END:variables
}
