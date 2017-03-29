package com.efrei.oracle.project.gui;

import javax.swing.*;

/**
 * Created by Adrien on 29/03/2017.
 */
public class CheckAccount {
    private JPanel checkAccount;
    private JLabel amountAvailableJLabel;

    public JPanel getCheckAccount() {
        return checkAccount;
    }

    public JLabel getAmountAvailableJLabel() {
        return amountAvailableJLabel;
    }

    public JTable getHistoryTable() {
        return historyTable;
    }

    public JLabel getAmountValueJLabel() {
        return amountValueJLabel;
    }

    private JTable historyTable;
    private JLabel amountValueJLabel;
}
