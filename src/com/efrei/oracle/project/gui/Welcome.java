package com.efrei.oracle.project.gui;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Adrien on 24/03/2017.
 */
public class Welcome extends JFrame {
    private JPanel welcomeJPanel;
    private JLabel welcomeJLabel;
    private JTextField welcomeTextField;
    private JPasswordField passwordField1;
    private JButton loginButton;

    public JPanel getWelcomeJPanel() {
        return welcomeJPanel;
    }

    public JButton getLoginButton() {
        return loginButton;
    }

    public JTextField getWelcomeTextField() {
        return welcomeTextField;
    }

    public JPasswordField getPasswordField1() {
        return passwordField1;
    }

    public Welcome() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().add(welcomeJPanel);
        setMinimumSize(new Dimension(500, 200));
        setResizable(false);
        setTitle("ATM - Log in");
        pack();
        setVisible(true);
    }
}
