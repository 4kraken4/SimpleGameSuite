package common.view;

import com.google.gson.JsonObject;
import common.components.GlassPanePopup;
import common.events.MenuItemSelected;
import common.events.UserActionPerformed;
import games.eq.view.EqBoardPanel;
import games.ttt.view.TttBoardPanel;
import java.awt.Cursor;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import javax.imageio.ImageIO;
import util.DatabaseManager;
import util.GameConfiguration;
import util.GameSuiteLogger;
import util.TranslationHandler;
import util.Utilities;
import util.Validator;

public class MainWindow extends javax.swing.JFrame {

    public MainWindow() {
        initComponents();
        configuration = GameConfiguration.getInstance();
        translations = TranslationHandler.getInstance();
        logger = GameSuiteLogger.getInstance();
        GlassPanePopup.install(this);
        setupUserDataPanel();
        setupCursor();
    }

    private void setMenuActions() {
        menu = new GameMenu();
        Utilities.setUI(mainContainer, menu);
        var mis = (MenuItemSelected) (ActionEvent evt) -> {
            String acmd = evt.getActionCommand();
            switch (acmd) {
                case "8 Queens" -> {
                    EqBoardPanel eqb = new EqBoardPanel();
                    setEQueenBtnActions(eqb);
                    Utilities.setUI(mainContainer, eqb);
                }
                case "Tic Tac Toe" -> {
                    TttBoardPanel tbp = new TttBoardPanel();
                    setTttBtnActions(tbp);
                    Utilities.setUI(mainContainer, tbp);
                }
                case "Huff-Man Encrypt" -> {
                    TttBoardPanel tbp = new TttBoardPanel();
                    setTttBtnActions(tbp);
                    Utilities.setUI(mainContainer, tbp);
                }
                case "Get Me Out" -> {
                    TttBoardPanel tbp = new TttBoardPanel();
                    setTttBtnActions(tbp);
                    Utilities.setUI(mainContainer, tbp);
                }
                case "Uncle Prim" -> {
                    TttBoardPanel tbp = new TttBoardPanel();
                    setTttBtnActions(tbp);
                    Utilities.setUI(mainContainer, tbp);
                }
            }
        };
        menu.setMis(mis);
    }

    private void setEQueenBtnActions(EqBoardPanel eqb) {
        var mis = (MenuItemSelected) (ActionEvent evt) -> {
            String acmd = evt.getActionCommand();
            switch (acmd) {
                case "undo" -> {
                }
                case "redo" -> {
                }
                case "hint" -> {
                }
                case "close" -> {
                    // Utilities.setUI(mainContainer, gameMenu);
                }
            }
        };
        eqb.setMis(mis);
    }

    private void setTttBtnActions(TttBoardPanel tbp) {
        var mis = (MenuItemSelected) (ActionEvent evt) -> {
            String acmd = evt.getActionCommand();
            switch (acmd) {
                case "undo" -> {
                }
                case "redo" -> {
                }
                case "hint" -> {
                }
                case "close" -> {
                    // Utilities.setUI(mainContainer, gameMenu);
                }
            }
        };
        tbp.setMis(mis);
    }

    private void setupCursor() {
        File f = new File("src\\common\\icons\\cursor-arrow.png");
        if (f.exists()) {
            try {
                Cursor customCursor = Toolkit.getDefaultToolkit().createCustomCursor(
                        ImageIO.read(f),
                        new Point(0, 0),
                        "Custom Cursor default");
                setCursor(customCursor);
            } catch (IOException ex) {
                logger.logError(getClass().getName(), ex);
            }
        }
    }

    private void setupUserDataPanel() {
        udp = new UserDataPanel();
        Utilities.setUI(mainContainer, udp);
        var uap = (UserActionPerformed) (String username) -> {
            Validator v = new Validator();
            String err = v.validateUserName(username);
            PopUpMessage pum = new PopUpMessage(true);
            pum.eventOK((ActionEvent e) -> {
                GlassPanePopup.closePopupAll();
            });
            if (!err.isEmpty()) {
                String popupTitle = translations
                        .getTranslation(
                                TranslationHandler.SCHEMMA_ERROR_TRANSLATION, "ERRMSG_INPUTTITLE");
                pum.setTitle(popupTitle);
                pum.setMessage(err);
                GlassPanePopup.showPopup(pum);
            } else {
                DatabaseManager db = new DatabaseManager() {
                    @Override
                    public String handleSQLException(SQLException e) {
                        return handleSqlException(e);
                    }
                };
                JsonObject params = new JsonObject();
                params.addProperty("Username", username.toLowerCase());
                try {
                    int executeUpdate = db.executeUpdate("user", "CreateUser", params);
                    if (executeUpdate > 0) {
                        setMenuActions();
                    }
                } catch (SQLException ex) {
                    String sqlErr = db.handleSQLException(ex);
                    String popupTitle = translations
                            .getTranslation(
                                    TranslationHandler.SCHEMMA_ERROR_TRANSLATION, "ERRMSG_DBTITLE");
                    pum.setTitle(popupTitle);
                    pum.setMessage(sqlErr);
                    GlassPanePopup.showPopup(pum);
                    logger.logWarning(ex.getMessage());
                }
            }
        };
        udp.setUap(uap);
    }

    private String handleSqlException(SQLException e) {
        int errorCode = e.getErrorCode();
        String errMsg = "";
        switch (errorCode) {
            case 1062 ->
                errMsg = translations.getTranslation(TranslationHandler.SCHEMMA_ERROR_TRANSLATION, "ERRMSG_DUPLICATEUSER");
            case 1451 ->
                errMsg = translations.getTranslation(TranslationHandler.SCHEMMA_ERROR_TRANSLATION, "ERRMSG_DBPERMISSIONDENIED");
            case 1045 ->
                errMsg = translations.getTranslation(TranslationHandler.SCHEMMA_ERROR_TRANSLATION, "ERRMSG_DBFAILEDUPDATE");
            default ->
                errMsg = translations.getTranslation(TranslationHandler.SCHEMMA_ERROR_TRANSLATION, "ERRMSG_DBERRORDEFAULT");
        }
        return errMsg;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainContainer = new javax.swing.JPanel();
        userDataPanel = new common.view.UserDataPanel();
        sidePanel1 = new common.view.SidePanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1200, 730));
        setResizable(false);

        mainContainer.setLayout(new java.awt.BorderLayout());
        mainContainer.add(userDataPanel, java.awt.BorderLayout.CENTER);

        getContentPane().add(mainContainer, java.awt.BorderLayout.CENTER);
        getContentPane().add(sidePanel1, java.awt.BorderLayout.WEST);

        setSize(new java.awt.Dimension(1216, 738));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private final GameConfiguration configuration;
    private final TranslationHandler translations;
    private final GameSuiteLogger logger;
    private UserDataPanel udp;
    private GameMenu menu;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel mainContainer;
    private common.view.SidePanel sidePanel1;
    private common.view.UserDataPanel userDataPanel;
    // End of variables declaration//GEN-END:variables
}
