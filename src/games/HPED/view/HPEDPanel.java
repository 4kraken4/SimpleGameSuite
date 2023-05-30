/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package games.HPED.view;

import games.HPED.model.HedModel;
import java.util.Map;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class HPEDPanel extends javax.swing.JPanel {

    HedModel model;

 
    public HPEDPanel(HedModel model) {
        initComponents();
        this.model = model;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Sp Graph Panel");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            HedModel model = new HedModel(5);
            frame.getContentPane().add(new HPEDPanel(model));
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        txtHufmanCodes = new javax.swing.JTextArea();
        lblText = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtEncodedText = new javax.swing.JTextField();
        txtDecodedText = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnSubmit = new javax.swing.JButton();
        chkDecode = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();

        setMaximumSize(new java.awt.Dimension(500, 500));
        setMinimumSize(new java.awt.Dimension(500, 500));
        setPreferredSize(new java.awt.Dimension(500, 500));

        txtHufmanCodes.setColumns(20);
        txtHufmanCodes.setRows(5);
        jScrollPane1.setViewportView(txtHufmanCodes);

        lblText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblText.setText("jLabel1");

        jLabel1.setText("Given String");

        jLabel2.setText("Encoded Text");

        jLabel3.setText("Decoded Text");

        btnSubmit.setText("Submit");
        btnSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitActionPerformed(evt);
            }
        });

        chkDecode.setText("Decode");
        chkDecode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkDecodeActionPerformed(evt);
            }
        });

        jCheckBox2.setText("Encode ");
        jCheckBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblText, javax.swing.GroupLayout.PREFERRED_SIZE, 373, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(jCheckBox2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(chkDecode)
                .addGap(144, 144, 144))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtEncodedText, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDecodedText, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSubmit)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBox2)
                    .addComponent(chkDecode))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblText, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEncodedText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDecodedText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSubmit)
                .addContainerGap(50, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jCheckBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox2ActionPerformed

        if (jCheckBox2.isSelected()) {
            chkDecode.setSelected(false);
            lblText.setText(model.getInput());
            model.setHuffmancodes(HedModel.encode(model.getInput()));
            for (Map.Entry<Character, String> entry : model.getHuffmancodes().entrySet()) {
                txtHufmanCodes.setText(txtHufmanCodes.getText() + "\n" + entry.getKey() + ": " + entry.getValue());
            }
            txtEncodedText.setEnabled(true);
            txtEncodedText.setText("");
            txtDecodedText.setText("");
            txtDecodedText.setEnabled(false);

        } else {
            lblText.setText("");
        }
    }//GEN-LAST:event_jCheckBox2ActionPerformed

    private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitActionPerformed

        if (jCheckBox2.isSelected()) {
            if ((HedModel.decode(txtEncodedText.getText(), model.getHuffmancodes())).equals(model.getInput())) {
                JOptionPane.showMessageDialog(null, "Taraaa");
            } else {
                JOptionPane.showMessageDialog(null, "Boooooo");
            }
        } else if (chkDecode.isSelected()) {

            String check = HedModel.decode(lblText.getText(), model.getHuffmancodes());
          
            if (check.equals(txtDecodedText.getText())) {
                JOptionPane.showMessageDialog(null, "WINNER :CHECK WAS : "+check+" and Answer was "+txtDecodedText.getText());
            } else {
               JOptionPane.showMessageDialog(null, "BOOO    :CHECK WAS : "+check+" and Answer was "+txtDecodedText.getText());
            }

        }


    }//GEN-LAST:event_btnSubmitActionPerformed

    private void chkDecodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkDecodeActionPerformed

        if (chkDecode.isSelected()) {
            jCheckBox2.setSelected(false);
            txtEncodedText.setText("");
            txtDecodedText.setText("");
            txtDecodedText.setEnabled(true);
            txtEncodedText.setEnabled(false);
            lblText.setText("");
            for (char c : model.getInput().toCharArray()) {
                lblText.setText(lblText.getText() + model.getHuffmancodes().get(c));
            }

        }

    }//GEN-LAST:event_chkDecodeActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSubmit;
    private javax.swing.JCheckBox chkDecode;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblText;
    private javax.swing.JTextField txtDecodedText;
    private javax.swing.JTextField txtEncodedText;
    private javax.swing.JTextArea txtHufmanCodes;
    // End of variables declaration//GEN-END:variables
}
