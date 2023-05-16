package common.controller;

import com.formdev.flatlaf.FlatDarkLaf;
import common.view.MainWindow;

public class Main {

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> {
            FlatDarkLaf.setup();
            new MainWindow().setVisible(true);
        });
    }
}
