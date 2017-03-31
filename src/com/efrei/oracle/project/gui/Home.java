package com.efrei.oracle.project.gui;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Adrien on 29/03/2017.
 */
public class Home extends JFrame {

    private JPanel loggedInJPanel;

    private JLabel loggedInJLabel;

    private JButton checkAccountButton;
    private JButton withdrawButton;
    private JButton addButton;
    private JButton logOutButton;

    public JPanel getLoggedInJPanel() { return loggedInJPanel; }

    public JLabel getLoggedInJLabel() {
        return loggedInJLabel;
    }

    public JButton getCheckAccountButton() {
        return checkAccountButton;
    }
    public JButton getWithdrawButton() {
        return withdrawButton;
    }
    public JButton getAddButton() {
        return addButton;
    }
    public JButton getLogOutButton() { return logOutButton; }

    public Home(){
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        getContentPane().add(loggedInJPanel);
        setMinimumSize(new Dimension(500, 200));
        setResizable(false);
        setTitle("ATM - Home");
        pack();
        setVisible(true);
    }
}
