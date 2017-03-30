package com.efrei.oracle.project.gui;

import javax.swing.*;

/**
 * Created by Adrien on 29/03/2017.
 */
public class Withdraw {

    private JPanel withdrawJPanel;

    private JLabel otherAmountJLabel;
    private JLabel withdrawJLabel;
    private JLabel withdrawAmountJLabel;

    private JComboBox amountToWithdrawJComboBox;
    private JFormattedTextField otherAmountJText;

    private JButton withdrawButton;

    public JPanel getWithdrawJPanel() { return withdrawJPanel; }

    public JLabel getOtherAmountJLabel() { return otherAmountJLabel; }
    public JLabel getWithdrawJLabel() { return withdrawJLabel; }
    public JLabel getWithdrawAmountJLabel() { return withdrawAmountJLabel; }

    public JComboBox getAmountToWithdrawJComboBox() { return amountToWithdrawJComboBox; }
    public JFormattedTextField getOtherAmountJText() { return otherAmountJText; }

    public JButton getWithdrawButton() { return withdrawButton; }
}
