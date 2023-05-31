package common.view;

import common.model.EightQueens;
import common.model.HuffmanED;
import common.model.TicTacToe;
import games.IMC.model.IMCGraphModel;
import games.SP.model.SPGraphModel;
import javax.swing.ImageIcon;
import util.GameSuiteLogger;
import util.TranslationHandler;

public final class SidePanel extends javax.swing.JPanel {

    public SidePanel() {
        initComponents();
        logger = GameSuiteLogger.getInstance();
        translations = TranslationHandler.getInstance();
        setDescription();
    }

    public void setDescription() {
        ImageIcon imageIcon = new javax.swing.ImageIcon(getClass().getResource("/common/icons/8-queens.png"));
        String title = translations.getTranslation("games-data", "TITLE_EIGHTQUEENS");
        String description = translations.getTranslation("games-data", "DESC_EIGHTQUEENS");
        gameImage.setIcon(imageIcon);
        gameTitle.setText(title);
        gameDescription.setText("<html>"
                + "<p align=\"justify\">" + description
                + "</p>"
                + "</html>");
    }

    public void changeSidepanelData(int gameId) {
        ImageIcon imageIcon = new javax.swing.ImageIcon(getClass().getResource("/common/icons/8-queens.png"));
        String title = "";
        String description = "";
        switch (gameId) {
            case EightQueens.GAME_ID -> {
                imageIcon = new javax.swing.ImageIcon(getClass().getResource("/common/icons/8-queens.png"));
                title = translations.getTranslation("games-data", "TITLE_EIGHTQUEENS");
                description = translations.getTranslation("games-data", "DESC_EIGHTQUEENS");
            }
            case TicTacToe.GAME_ID -> {
                imageIcon = new javax.swing.ImageIcon(getClass().getResource("/common/icons/TicTacToe.png"));
                title = translations.getTranslation("games-data", "TITLE_TICTACTOE");
                description = translations.getTranslation("games-data", "DESC_TICTACTOE");
            }
            case HuffmanED.GAME_ID -> {
                imageIcon = new javax.swing.ImageIcon(getClass().getResource("/common/icons/8-queens.png"));
                title = translations.getTranslation("games-data", "TITLE_HUFFMANED");
                description = translations.getTranslation("games-data", "DESC_HUFFMANED");
            }
            case IMCGraphModel.GAME_ID -> {
                imageIcon = new javax.swing.ImageIcon(getClass().getResource("/common/icons/8-queens.png"));
                title = translations.getTranslation("games-data", "TITLE_MINIMUMSPANNINGTREE");
                description = translations.getTranslation("games-data", "DESC_MINIMUMSPANNINGTREE");
            }
            case SPGraphModel.GAME_ID -> {
                imageIcon = new javax.swing.ImageIcon(getClass().getResource("/common/icons/8-queens.png"));
                title = translations.getTranslation("games-data", "TITLE_SHORTESTPATH");
                description = translations.getTranslation("games-data", "DESC_SHORTESTPATH");
            }
            default ->
                throw new AssertionError();
        }
        gameImage.setIcon(imageIcon);
        gameTitle.setText(title);
        gameDescription.setText("<html>"
                + "<p align=\"justify\">" + description
                + "</p>"
                + "</html>");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        gameTitle = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        gameDescription = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        gameImage = new common.viewmodel.CustomLabel();

        jPanel1.setLayout(new java.awt.BorderLayout());

        gameTitle.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 36)); // NOI18N
        gameTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        gameTitle.setText("8 Queens Problem");
        gameTitle.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel1.add(gameTitle, java.awt.BorderLayout.NORTH);

        gameDescription.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        gameDescription.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        gameDescription.setText("<html><p align=\"justify\">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vivamus convallis blandit sollicitudin. Quisque volutpat quam vel arcu tristique accumsan. Aliquam erat volutpat. Nulla auctor nulla at vestibulum sollicitudin. Donec placerat libero a mi laoreet pellentesque. Fusce varius quis eros et ornare. Integer viverra, sapien non bibendum fringilla, tellus urna finibus mauris, non hendrerit elit diam aliquet arcu. Donec vel neque interdum, fringilla tellus sed, viverra lacus. Ut rutrum, dolor nec fringilla tincidunt, dolor dui pharetra velit, sit amet accumsan ligula lorem ac orci. Mauris eget congue est. Quisque egestas id nibh eget fringilla. Donec accumsan leo vel risus porta, at consectetur odio consectetur. Morbi massa nisl, laoreet porttitor posuere vel, rutrum molestie est.</p></html>");
        gameDescription.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        gameDescription.setPreferredSize(new java.awt.Dimension(400, 250));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(gameDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(gameDescription, javax.swing.GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.add(jPanel3, java.awt.BorderLayout.CENTER);

        gameImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/common/icons/8-queens.png"))); // NOI18N
        gameImage.setIconSize(new java.awt.Dimension(350, 350));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(gameImage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(gameImage, javax.swing.GroupLayout.DEFAULT_SIZE, 368, Short.MAX_VALUE)
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

    private final TranslationHandler translations;
    private final GameSuiteLogger logger;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel gameDescription;
    private common.viewmodel.CustomLabel gameImage;
    private javax.swing.JLabel gameTitle;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    // End of variables declaration//GEN-END:variables
}
