package games.IMC.view;

import games.IMC.model.ImcGraphModel;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Collections;
import javax.swing.JOptionPane;

public class ImcGraphView extends javax.swing.JPanel {

    ImcGraphModel model;
    private boolean viewCorrectAnswer = false;

    public ImcGraphView() {
        setBackground(new Color(0, 0, 0, 0));
        setOpaque(false);
        initComponents();
        model = new ImcGraphModel();
        model.setNumCities(5);
        model.generateMatrix();
        model.generateCityPoints();
        setPreferredSize(new Dimension(600, 600));
        setBackground(Color.decode("#87CBB9"));
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int clickedEdge = model.getClickedEdge(e.getX(), e.getY());
                if (clickedEdge != -1) {
                    if (model.getSelectedEdges().contains(clickedEdge)) {
                        model.getSelectedEdges().remove(Integer.valueOf(clickedEdge));
                    } else {
                        model.getSelectedEdges().add(clickedEdge);
                    }
                    repaint();
                }
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setStroke(new BasicStroke(1));

        Color[] lineColors = new Color[]{Color.RED, Color.BLUE, Color.GREEN, Color.ORANGE, Color.MAGENTA,
            Color.CYAN, Color.RED, Color.PINK, Color.GRAY, Color.LIGHT_GRAY};

        g2d.setFont(new Font("Arial", Font.BOLD, 12));

        for (int r = 0; r < model.getNumCities(); r++) {
            for (int c = 0; c < r; c++) {
                Point cityR = model.getCityPoints().get(r);
                Point cityC = model.getCityPoints().get(c);
                g2d.setColor(lineColors[r % lineColors.length]);
                g2d.setStroke(new BasicStroke(3));
                g2d.drawLine(cityR.x, cityR.y, cityC.x, cityC.y);
                var matrix = model.getMatrix();
                String distanceText = String.valueOf(matrix[r][c]);
                int textX = (cityR.x + cityC.x) / 2;
                int textY = (cityR.y + cityC.y) / 2;

                g2d.setColor(Color.WHITE);
                g2d.fillRect(textX - 10, textY - 10, 20, 20);

                g2d.setColor(lineColors[r % lineColors.length]);
                g2d.drawString(distanceText, textX - 5, textY + 5);

                if (model.getSelectedEdges().contains(r * model.getNumCities() + c)) {
                    g2d.setColor(Color.YELLOW);
                    g2d.drawLine(cityR.x, cityR.y, cityC.x, cityC.y);
                }

                if (viewCorrectAnswer) {
                    if (model.getCorrectEdges().contains(r * model.getNumCities() + c)
                            || model.getCorrectEdges().contains(c * model.getNumCities() + r)) {
                        g2d.setColor(Color.BLACK);
                        g2d.setStroke(new BasicStroke(5));
                        g2d.drawLine(cityR.x, cityR.y, cityC.x, cityC.y);
                        distanceText = String.valueOf(matrix[r][c]);
                        textX = (cityR.x + cityC.x) / 2;
                        textY = (cityR.y + cityC.y) / 2;

                        g2d.setColor(Color.WHITE);
                        g2d.fillRect(textX - 10, textY - 10, 20, 20);
                        g2d.setColor(Color.BLACK);
                        g2d.drawString(distanceText, textX - 5, textY + 5);
                    }
                }
            }
        }

        for (int i = 0; i < model.getNumCities(); i++) {
            Point city = model.getCityPoints().get(i);

            g2d.setColor(Color.BLACK);
            g2d.fillOval(city.x - 5, city.y - 5, 10, 10);
            String cityName = String.valueOf((char) ('A' + i));
            g2d.drawString(cityName, city.x + 10, city.y + 10);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new common.viewmodel.CustomButton();
        jButton2 = new common.viewmodel.CustomButton();

        jButton1.setText("Submit Answer");
        jButton1.setFocusPainted(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("View Answer");
        jButton2.setFocusPainted(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 301, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(465, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton1ActionPerformed
        model.getCorrectEdges().clear();
        ImcGraphModel.primMST(model.getMatrix());
        Collections.sort(model.getCorrectEdges());
        Collections.sort(model.getSelectedEdges());
        boolean match =false;
        for(int a :model.getCorrectEdges())
        {
          match = model.getSelectedEdges().contains(a)|| model.getMirrorSelectedEdges().contains(a);
        }
        repaint();

        if (match && model.getCorrectEdges().size() == model.getSelectedEdges().size()) {
            JOptionPane.showMessageDialog(null, "Congratulations! You win!");
        } else {
            JOptionPane.showMessageDialog(null, "You lose. Please try again later.");
        }
    }// GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton2ActionPerformed
        model.getCorrectEdges().clear();
        viewCorrectAnswer = !viewCorrectAnswer;
        ImcGraphModel.primMST(model.getMatrix());
        // for(int a:model.getCorrectEdges()){ System.out.println(a);}
        repaint();
    }// GEN-LAST:event_jButton2ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private common.viewmodel.CustomButton jButton1;
    private common.viewmodel.CustomButton jButton2;
    // End of variables declaration//GEN-END:variables
}
