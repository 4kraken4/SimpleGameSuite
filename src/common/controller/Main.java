package common.controller;

import com.formdev.flatlaf.FlatLightLaf;
import common.view.MainWindow;

public class Main {

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> {
            FlatLightLaf.setup();
            new MainWindow().setVisible(true);
        });
    }
}
