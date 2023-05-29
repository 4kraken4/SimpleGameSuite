package common.view;

import common.components.GlassPanePopup;
import common.controller.GameController;
import common.controller.UserController;
import common.events.DatabaseUpdated;
import common.events.MenuItemSelected;
import common.events.UserActionPerformed;
import common.model.Game;
import common.model.User;
import games.IMC.view.ImcGraphPanel;
import games.eq.view.EqBoardPanel;
import games.ttt.view.TttBoardPanel;
import java.awt.Cursor;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;
import javax.imageio.ImageIO;
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
        currentUser = null;
    }

    private void setMenuActions() {
        menu = new GameMenu();
        Utilities.setUI(mainContainer, menu);
        var mis = (MenuItemSelected) (ActionEvent evt) -> {
            String acmd = evt.getActionCommand();
            switch (acmd) {
                case "8 Queens" -> {
                    EqBoardPanel eqb = new EqBoardPanel();
                    eqb.setUser(currentUser);
                    eqb.setDatabaseUpdatedEvent(setUpCongratsMeg());
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
                    ImcGraphPanel igp = new ImcGraphPanel();
//                    setTttBtnActions(tbp);
                    Utilities.setUI(mainContainer, igp);
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
                    Utilities.setUI(mainContainer, menu);
                }
            }
        };
        eqb.setMenuItemSelectedEvent(mis);
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
                    Utilities.setUI(mainContainer, menu);
                }
            }
        };
        tbp.setMenuItemSelectedEvent(mis);
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

    private DatabaseUpdated setUpCongratsMeg() {
        GameController gc = new GameController(new Game(0));
        List<Game> games = gc.getGames();
        var dbu = (DatabaseUpdated) (int gameId, boolean isUpdated) -> {
            if (games != null && !games.isEmpty()) {
                Game game = games.stream()
                        .filter(g -> g.getGameId() == gameId)
                        .collect(Collectors.toList())
                        .get(0);
                PopUpMessage pum = new PopUpMessage(isUpdated);
                String title = "You've done it, BUT";
                String message = "It looks like this answer has been already found. But nevever mind just keep trying...you ca do it!";
                if (isUpdated) {
                    title = "You've done it!.";
                    message = "Congradulation on finding a correct answer for " + game.getGameTitle() + " game.";
                }
                pum.setTitle(title);
                pum.setMessage(message);
                pum.eventOK((e) -> {
                    GlassPanePopup.closePopupLast();
                });
                GlassPanePopup.showPopup(pum);
            }
        };
        return dbu;
    }

    private void setupUserDataPanel() {
        udp = new UserDataPanel();
        Utilities.setUI(mainContainer, udp);
        udp.setPlayAsDefaultButton(this);
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
                User user = new User(0, username.toLowerCase());
                UserController uc = new UserController(user);
                try {
                    int saveUser = uc.saveUser();
                    if (saveUser > 0) {
                        currentUser = uc.getUser();
                        setMenuActions();
                    }
                } catch (SQLException ex) {
                    String handleSqlExceptions = uc.handleSqlExceptions(ex);
                    String popupTitle = translations
                            .getTranslation(
                                    TranslationHandler.SCHEMMA_ERROR_TRANSLATION, "ERRMSG_DBTITLE");
                    pum.setTitle(popupTitle);
                    pum.setMessage(handleSqlExceptions);
                    GlassPanePopup.showPopup(pum);
                    logger.logWarning(ex.getMessage());
                }
            }
        };
        udp.setUap(uap);
    }

    @SuppressWarnings("unchecked")
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

    private User currentUser;
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
