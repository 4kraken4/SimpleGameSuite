package games.hed.view;

import common.events.GameWin;
import games.hed.model.HuffmanCodes;
import java.awt.Color;
import java.awt.event.ActionListener;

public class HedAnswerPanel extends javax.swing.JPanel {

    public HedAnswerPanel() {
        initComponents();
        textPane.setBackground(new Color(0, 0, 0, 0));
        textPane.setSelectionColor(new Color(48, 170, 63, 200));
        textPane.setOpaque(false);
        textPane.setForeground(Color.decode("#1E1E1E"));
        setBackBtnActions();
    }

    public GameWin getWin() {
        return win;
    }

    public void setWin(GameWin win) {
        this.win = win;
    }
    
    private void setBackBtnActions() {
        btnBack.setIcon(new javax.swing.ImageIcon(getClass().getResource(iconBackNormal)));
    }
    
    public void onBack(ActionListener evt) {
        btnBack.addActionListener(evt);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        txtEncoded = new common.viewmodel.CustomTextField();
        txtAnswer = new common.viewmodel.CustomTextField();
        customButton1 = new common.viewmodel.CustomButton();
        btnBack = new common.viewmodel.CustomButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        textPane = new javax.swing.JTextPane();

        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 51)));
        setPreferredSize(new java.awt.Dimension(700, 500));
        setLayout(new java.awt.BorderLayout());

        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPanel1.setPreferredSize(new java.awt.Dimension(700, 500));
        jPanel1.setLayout(new java.awt.GridBagLayout());

        txtEncoded.setEditable(false);
        txtEncoded.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtEncoded.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        txtEncoded.setPreferredSize(new java.awt.Dimension(300, 50));
        txtEncoded.setRound(35);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 275;
        gridBagConstraints.ipady = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(69, 6, 0, 5);
        jPanel1.add(txtEncoded, gridBagConstraints);

        txtAnswer.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtAnswer.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        txtAnswer.setPreferredSize(new java.awt.Dimension(300, 50));
        txtAnswer.setRound(35);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 275;
        gridBagConstraints.ipady = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(30, 6, 0, 5);
        jPanel1.add(txtAnswer, gridBagConstraints);

        customButton1.setText("Submit");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.ipadx = 92;
        gridBagConstraints.ipady = 15;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(41, 91, 0, 0);
        jPanel1.add(customButton1, gridBagConstraints);

        btnBack.setActionCommand("undo");
        btnBack.setIconSize(new java.awt.Dimension(24, 24));
        btnBack.setMaximumSize(new java.awt.Dimension(30, 30));
        btnBack.setMinimumSize(new java.awt.Dimension(30, 30));
        btnBack.setPreferredSize(new java.awt.Dimension(30, 30));
        btnBack.setRoundness(100);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(7, 7, 0, 0);
        jPanel1.add(btnBack, gridBagConstraints);

        jScrollPane1.setBorder(null);

        textPane.setBorder(null);
        jScrollPane1.setViewportView(textPane);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 341;
        gridBagConstraints.ipady = 417;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(6, 7, 5, 0);
        jPanel1.add(jScrollPane1, gridBagConstraints);

        add(jPanel1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    
    private final String iconBackNormal = "/common/icons/back-line.png";
    
    private GameWin win;
    private HuffmanCodes codes;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private common.viewmodel.CustomButton btnBack;
    private common.viewmodel.CustomButton customButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextPane textPane;
    private common.viewmodel.CustomTextField txtAnswer;
    private common.viewmodel.CustomTextField txtEncoded;
    // End of variables declaration//GEN-END:variables
}
