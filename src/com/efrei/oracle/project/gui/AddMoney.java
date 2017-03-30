package com.efrei.oracle.project.gui;

import javax.swing.*;

/**
 * Created by Adrien on 29/03/2017.
 */
public class AddMoney {

    private JPanel addMoneyJPanel;
    private JLabel addMoneyJLabel;
    private JLabel amountToAddJLabel;
    private JLabel otherAmountJLabel;
    private JComboBox amountToAddJComboBox;
    private JFormattedTextField otherAmountJText;
    private JButton submitJButton;

    public JPanel getAddMoneyJPanel() { return addMoneyJPanel; }

    public JLabel getAddMoneyJLabel() { return addMoneyJLabel; }
    public JLabel getAmountToAddJLabel() { return amountToAddJLabel; }
    public JLabel getOtherAmountJLabel() { return otherAmountJLabel; }

    public JComboBox getAmountToAddJComboBox() { return amountToAddJComboBox; }
    public JFormattedTextField getOtherAmountJText() { return otherAmountJText; }

    public JButton getSubmitJButton() { return submitJButton; }

}
