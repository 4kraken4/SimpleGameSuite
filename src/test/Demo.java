package test;

import javax.swing.*;
import java.awt.*;

class CustomLabel extends JLabel {
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setColor(new Color(255, 0, 0, 128));
        g2.fillRect(0, 0, getWidth(), getHeight());
        g2.dispose();
    }
}

public class Demo {
    public static void main(String[] args) {
        // Create a JFrame
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        
        // Create a CustomLabel (subclass of JLabel)
        CustomLabel label = new CustomLabel();
        label.setText("Hello, world!");
        label.setFont(new Font("Serif", Font.BOLD, 24));
        label.setForeground(Color.WHITE); // Set the foreground color to white
        
        // Set the black background color
        label.setOpaque(true);
        label.setBackground(Color.decode("#404258"));
        
        // Add the label to the frame
        frame.getContentPane().add(label);
        
        // Display the frame
        frame.setVisible(true);
    }
}
