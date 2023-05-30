package games.SP.view;

import common.events.GameWin;
import games.SP.model.SPGraphModel;
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
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Collections;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

public class SPGraphView extends javax.swing.JPanel {

    SPGraphModel model;
    private boolean viewCorrectAnswer = false;
    private GameWin win;

    public SPGraphView() {
        setBackground(new Color(0, 0, 0, 0));
        setOpaque(false);
        initComponents();
        model = new SPGraphModel(10);
        model.generateMatrix();
        model.generateCityPoints();
        try {
            this.cityImage = ImageIO.read(new File("src\\common\\icons\\cityBuildingimg.png"));
            this.targetcityImage = ImageIO.read(new File("src\\common\\icons\\targetCity.png"));
            this.homecityImage = ImageIO.read(new File("src\\common\\icons\\HomeCity.png"));
        } catch (IOException e) {

        }
        setPreferredSize(new Dimension(500, 500));
        this.setBackground(Color.WHITE);
        this.lblInstruction.setText(
                "Find the Shortest Path from City A to City " + String.valueOf((char) ('A' + model.getTargetNode())));
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

        Color[] lineColors = new Color[] { Color.decode("#618C03"), Color.decode("#F2B705"), Color.decode("#D97904"),
                Color.decode("#D92B04"), Color.decode("#551073"),
                Color.decode("#3B3F8C"), Color.decode("#8C0E03"), Color.decode("#5C8EF2"), Color.decode("#618C03"),
                Color.decode("#3B3F8C") };

        g2d.setFont(new Font("Arial", Font.BOLD, 12));
        var matrix = model.getMatrix();
        for (int r = 0; r < model.getNumCities(); r++) {
            for (int c = 0; c < r; c++) {
                Point cityR = model.getCityPoints().get(r);
                Point cityC = model.getCityPoints().get(c);
                if (matrix[r][c] > 0) {
                    g2d.setColor(lineColors[r % lineColors.length]);
                    g2d.setStroke(new BasicStroke(3));
                    g2d.drawLine(cityR.x, cityR.y, cityC.x, cityC.y);
                    if (model.getSelectedEdges().contains(r * model.getNumCities() + c)) {
                        g2d.setColor(Color.decode("#04BF7B"));
                        g2d.setStroke(new BasicStroke(6));
                        g2d.drawLine(cityR.x, cityR.y, cityC.x, cityC.y);
                    }
                    if (viewCorrectAnswer) {
                        if (model.getCorrectEdges().contains(c * model.getNumCities() + r)
                                || model.getCorrectEdges().contains(r * model.getNumCities() + c)) {
                            g2d.setColor(Color.RED);
                            g2d.setStroke(new BasicStroke(7));
                            g2d.drawLine(cityR.x, cityR.y, cityC.x, cityC.y);
                        }
                    }

                }
            }
        }
        for (int r = 0; r < model.getNumCities(); r++) {
            for (int c = 0; c < r; c++) {
                if (matrix[r][c] > 0) {
                    Point cityR = model.getCityPoints().get(r);
                    Point cityC = model.getCityPoints().get(c);
                    String distanceText = String.valueOf(matrix[r][c]);
                    int textX = (cityR.x + cityC.x) / 2;
                    int textY = (cityR.y + cityC.y) / 2;
                    g2d.setColor(Color.decode("#ECF23D"));
                    g2d.fillOval(textX - 10, textY - 10, 20, 20);
                    g2d.setColor(Color.BLACK);
                    g2d.drawString(distanceText, textX - 5, textY + 5);
                    if (viewCorrectAnswer) {
                        if (model.getCorrectEdges().contains(c * model.getNumCities() + r)
                                || model.getCorrectEdges().contains(r * model.getNumCities() + c)) {
                            g2d.setColor(Color.GREEN);
                            g2d.fillOval(textX - 10, textY - 10, 20, 20);
                            g2d.setColor(Color.BLACK);
                            g2d.drawString(distanceText, textX - 5, textY + 5);
                        }
                    }
                }
            }
        }
        for (int i = 0; i < model.getNumCities(); i++) {
            Point city = model.getCityPoints().get(i);
            if (model.getTargetNode() == i) {
                g2d.drawImage(targetcityImage, city.x - 5, city.y - 30, 35, 35, null);
            } else if (i == 0) {
                g2d.drawImage(homecityImage, city.x - 5, city.y - 30, 30, 30, null);
            } else {
                g2d.drawImage(cityImage, city.x - 5, city.y - 30, 30, 30, null);
            }
            g2d.setColor(Color.BLACK);
            String cityName = "City " + String.valueOf((char) ('A' + i));
            g2d.drawString(cityName, city.x, city.y + 10);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        lblInstruction = new javax.swing.JLabel();

        jButton1.setText("Submit Answer");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("View Answer");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        lblInstruction.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblInstruction.setText("Test 002");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 109,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 309,
                                        Short.MAX_VALUE)
                                .addComponent(jButton1)
                                .addGap(34, 34, 34))
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lblInstruction, javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap()));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lblInstruction, javax.swing.GroupLayout.PREFERRED_SIZE, 41,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 486,
                                        Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButton1)
                                        .addComponent(jButton2))
                                .addGap(25, 25, 25)));
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton1ActionPerformed

        model.getCorrectEdges().clear();
        model.getShortestPaths(model.getMatrix(), 0);
        Collections.sort(model.getCorrectEdges());
        Collections.sort(model.getMirrorSelectedEdges());
        boolean match = false;
        for (int a : model.getCorrectEdges()) {
            match = model.getSelectedEdges().contains(a) || model.getMirrorSelectedEdges().contains(a);
        }
        if (match && model.getCorrectEdges().size() == model.getMirrorSelectedEdges().size()) {
            win.onGameWin(model.getMirrorSelectedEdges(), model.getMatrix());
            model.getCorrectEdges().clear();
            model.getSelectedEdges().clear();
        } else {
            JOptionPane.showMessageDialog(null, "You lose. Please try again later.");
        }
        repaint();
    }// GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton2ActionPerformed
        model.getCorrectEdges().clear();
        viewCorrectAnswer = !viewCorrectAnswer;
        model.getShortestPaths(model.getMatrix(), 0);
        repaint();
    }// GEN-LAST:event_jButton2ActionPerformed

    private BufferedImage homecityImage;
    private BufferedImage targetcityImage;
    private BufferedImage cityImage;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel lblInstruction;
    // End of variables declaration//GEN-END:variables

    void undo() {
    }

    void redo() {
    }

    GameWin getWin() {
        return win;
    }

    void setWin(GameWin win) {
        this.win = win;
    }
}
