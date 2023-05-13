package test;

import games.eightqueens.viewmodel.Cell;
import java.awt.GridLayout;

public class Test extends javax.swing.JFrame {

    public Test() {
        initComponents();
        setUpGrid();
    }

    private void setUpGrid() {
        GridLayout gridLayout = new GridLayout(8, 8);
        setLayout(gridLayout);
        int rows = gridLayout.getRows();
        int cols = gridLayout.getColumns();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                Cell cell = new Cell(i, j);
                add(cell);
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridLayout(8, 8));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new Test().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
