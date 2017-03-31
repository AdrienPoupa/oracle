package com.efrei.oracle.project.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Created by Adrien on 29/03/2017.
 */
public class Withdraw extends JFrame {

    private JPanel withdrawJPanel;
    private JLabel otherAmountJLabel;
    private JLabel withdrawJLabel;
    private JLabel withdrawAmountJLabel;
    private JComboBox amountToWithdrawJComboBox;
    private JFormattedTextField otherAmountJText;
    private JButton withdrawButton;
    private Boolean closed;

    public JPanel getWithdrawJPanel() { return withdrawJPanel; }
    public JLabel getOtherAmountJLabel() { return otherAmountJLabel; }
    public JLabel getWithdrawJLabel() { return withdrawJLabel; }
    public JLabel getWithdrawAmountJLabel() { return withdrawAmountJLabel; }
    public JComboBox getAmountToWithdrawJComboBox() { return amountToWithdrawJComboBox; }
    public JFormattedTextField getOtherAmountJText() { return otherAmountJText; }
    public JButton getWithdrawButton() { return withdrawButton; }
    public Boolean getClosed() { return closed; }

    public Withdraw() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        getContentPane().add(withdrawJPanel);
        setMinimumSize(new Dimension(500, 200));
        setResizable(false);
        setTitle("ATM - Withdraw");
        pack();
        setVisible(true);
        closed = false;

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                closed = true;
            }
        });
    }
}
