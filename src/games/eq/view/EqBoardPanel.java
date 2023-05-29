package games.eq.view;

import common.controller.UserController;
import common.events.DatabaseUpdated;
import common.events.GameWin;
import common.events.MenuItemSelected;
import common.model.Game;
import common.model.Score;
import common.model.User;
import common.viewmodel.CustomButton;
import games.eq.model.EqBoardModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import javax.swing.ImageIcon;

public class EqBoardPanel extends javax.swing.JPanel {

    private MenuItemSelected mis;
    private DatabaseUpdated du;
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public MenuItemSelected getMenuItemSelectedEvent() {
        return mis;
    }

    public void setMenuItemSelectedEvent(MenuItemSelected mis) {
        this.mis = mis;
    }

    public DatabaseUpdated getDatabaseUpdatedEvent() {
        return du;
    }

    public void setDatabaseUpdatedEvent(DatabaseUpdated du) {
        this.du = du;
    }

    public EqBoardPanel() {
        initComponents();
        setHeaderButtonIcons();
        setHeaderButtonActions();
        purgeOnWin();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        btnRedo = new common.viewmodel.CustomButton();
        btnUndo = new common.viewmodel.CustomButton();
        jPanel3 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        btnHint = new common.viewmodel.CustomButton();
        btnClose = new common.viewmodel.CustomButton();
        jPanel7 = new javax.swing.JPanel();
        gameBoard1 = new games.eq.model.EqBoardModel();

        setMaximumSize(new java.awt.Dimension(612, 709));
        setLayout(new java.awt.BorderLayout());

        jPanel2.setLayout(new java.awt.GridBagLayout());

        btnRedo.setActionCommand("redo");
        btnRedo.setIconSize(new java.awt.Dimension(24, 24));
        btnRedo.setMaximumSize(new java.awt.Dimension(30, 30));
        btnRedo.setMinimumSize(new java.awt.Dimension(30, 30));
        btnRedo.setPreferredSize(new java.awt.Dimension(30, 30));
        btnRedo.setRoundness(100);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(21, 18, 22, 16);
        jPanel2.add(btnRedo, gridBagConstraints);

        btnUndo.setActionCommand("undo");
        btnUndo.setIconSize(new java.awt.Dimension(24, 24));
        btnUndo.setMaximumSize(new java.awt.Dimension(30, 30));
        btnUndo.setMinimumSize(new java.awt.Dimension(30, 30));
        btnUndo.setPreferredSize(new java.awt.Dimension(30, 30));
        btnUndo.setRoundness(100);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(21, 6, 22, 0);
        jPanel2.add(btnUndo, gridBagConstraints);

        jPanel1.add(jPanel2);

        jPanel5.setLayout(new java.awt.GridBagLayout());

        jLabel2.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("05");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(19, 18, 24, 0);
        jPanel5.add(jLabel2, gridBagConstraints);

        jLabel1.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Time");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(19, 20, 24, 0);
        jPanel5.add(jLabel1, gridBagConstraints);

        jLabel3.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("59");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(19, 6, 24, 0);
        jPanel5.add(jLabel3, gridBagConstraints);

        jLabel4.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText(":");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(19, 6, 24, 0);
        jPanel5.add(jLabel4, gridBagConstraints);

        jLabel5.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("s");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(19, 6, 24, 16);
        jPanel5.add(jLabel5, gridBagConstraints);

        jPanel3.add(jPanel5);

        jPanel6.setLayout(new java.awt.BorderLayout());

        jLabel6.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Highest Score");
        jPanel6.add(jLabel6, java.awt.BorderLayout.NORTH);

        jLabel7.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 51, 51));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("58");
        jPanel6.add(jLabel7, java.awt.BorderLayout.CENTER);

        jPanel3.add(jPanel6);

        jPanel1.add(jPanel3);

        jPanel4.setLayout(new java.awt.GridBagLayout());

        btnHint.setActionCommand("hint");
        btnHint.setIconSize(new java.awt.Dimension(24, 24));
        btnHint.setMaximumSize(new java.awt.Dimension(50, 30));
        btnHint.setMinimumSize(new java.awt.Dimension(50, 30));
        btnHint.setPreferredSize(new java.awt.Dimension(50, 30));
        btnHint.setRoundness(10);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(28, 6, 17, 0);
        jPanel4.add(btnHint, gridBagConstraints);

        btnClose.setActionCommand("close");
        btnClose.setIconSize(new java.awt.Dimension(24, 24));
        btnClose.setMaximumSize(new java.awt.Dimension(30, 30));
        btnClose.setMinimumSize(new java.awt.Dimension(30, 30));
        btnClose.setPreferredSize(new java.awt.Dimension(30, 30));
        btnClose.setRoundness(100);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(28, 18, 17, 16);
        jPanel4.add(btnClose, gridBagConstraints);

        jPanel1.add(jPanel4);

        add(jPanel1, java.awt.BorderLayout.NORTH);

        jPanel7.setLayout(new java.awt.GridBagLayout());

        gameBoard1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        gameBoard1.setMaximumSize(new java.awt.Dimension(600, 600));
        gameBoard1.setMinimumSize(new java.awt.Dimension(600, 600));
        gameBoard1.setPreferredSize(new java.awt.Dimension(600, 600));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 6, 18, 6);
        jPanel7.add(gameBoard1, gridBagConstraints);

        add(jPanel7, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void setHeaderButtonActions() {
        btnUndo.addActionListener((e) -> {
            gameBoard1.undo();
        });
        btnRedo.addActionListener((e) -> {
            gameBoard1.redo();
        });
        btnHint.addActionListener(e -> {
            gameBoard1.setPathHighlighted(!gameBoard1.isPathHighlighted());
        });
        btnClose.addActionListener((e) -> {
            mis.itemSelected(e);
        });
    }

    private void setHeaderButtonIcons() {
        List<CustomButton> btns = Arrays.asList(btnUndo, btnRedo, btnHint, btnClose);
        btns.forEach(btn -> {
            String s1 = "";
            String s2 = "";
            switch (btn.getActionCommand()) {
                case "undo" -> {
                    s1 = iconUndoNormal;
                    s2 = iconUndoHover;
                }
                case "redo" -> {
                    s1 = iconRedoNormal;
                    s2 = iconRedoHover;
                }
                case "hint" -> {
                    s1 = iconHintNormal;
                    s2 = iconHintHover;
                }
                case "close" -> {
                    s1 = iconCloseNormal;
                    s2 = iconCloseHover;
                }
            }
            btn.setIcon(new ImageIcon(getClass().getResource(s1)));
            final String me = s1;
            final String ml = s2;
            btn.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    btn.setIcon(new javax.swing.ImageIcon(getClass().getResource(ml)));
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    btn.setIcon(new javax.swing.ImageIcon(getClass().getResource(me)));
                }
            });
        });
    }

    private void purgeOnWin() {
        var win = (GameWin) (Object data, Object helperData) -> {
            Score score = new Score(0, 0, data, helperData, LocalDate.now());
            Game game = new Game(EqBoardModel.GAME_ID, "", "", true, score);
            user.setGame(game);
            UserController uc = new UserController(user);
            int purgeAnswer = uc.saveAnswer();
            boolean isUpdated = purgeAnswer > 0;
            du.onDatabseUpdate(EqBoardModel.GAME_ID, isUpdated);
        };
        gameBoard1.setWin(win);
    }

    private final String iconUndoNormal = "/common/icons/undo-black.png";
    private final String iconRedoNormal = "/common/icons/redo-black.png";
    private final String iconHintNormal = "/common/icons/lightbulb-line.png";
    private final String iconCloseNormal = "/common/icons/cancel-line.png";
    private final String iconUndoHover = "/common/icons/undo-yellow.png";
    private final String iconRedoHover = "/common/icons/redo-yellow.png";
    private final String iconHintHover = "/common/icons/lightbulb-fill.png";
    private final String iconCloseHover = "/common/icons/cancel-fill.png";
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private common.viewmodel.CustomButton btnClose;
    private common.viewmodel.CustomButton btnHint;
    private common.viewmodel.CustomButton btnRedo;
    private common.viewmodel.CustomButton btnUndo;
    private games.eq.model.EqBoardModel gameBoard1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    // End of variables declaration//GEN-END:variables

}
