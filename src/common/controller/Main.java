package common.controller;

import com.formdev.flatlaf.FlatLightLaf;
import common.view.MainWindow;
import util.GameSuiteLogger;

public class Main {

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> {
            FlatLightLaf.setup();
            GameSuiteLogger.getInstance().logInfo("Application Stating.");
            new MainWindow().setVisible(true);
        });
    }
}
