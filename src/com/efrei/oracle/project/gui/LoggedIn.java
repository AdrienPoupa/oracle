package com.efrei.oracle.project.gui;

import javax.swing.*;

/**
 * Created by Adrien on 29/03/2017.
 */
public class LoggedIn {
    private JPanel loggedInJPanel;

    public JPanel getLoggedInJPanel() {
        return loggedInJPanel;
    }

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

    private JLabel loggedInJLabel;
    private JButton checkAccountButton;
    private JButton withdrawButton;
    private JButton addButton;
}
