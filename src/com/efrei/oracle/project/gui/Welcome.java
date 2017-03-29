package com.efrei.oracle.project.gui;

import javax.swing.*;

/**
 * Created by Adrien on 24/03/2017.
 */
public class Welcome {
    private JLabel welcomeJLabel;
    private JTextField welcomeTextField;
    private JPanel welcomeJPanel;
    private JPasswordField passwordField1;
    private JButton loginButton;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Welcome");
        frame.setContentPane(new Welcome().welcomeJPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
