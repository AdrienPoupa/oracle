package com.efrei.oracle.project.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Created by Adrien on 29/03/2017.
 */
public class AddMoney extends JFrame {

    private JPanel addMoneyJPanel;
    private JLabel addMoneyJLabel;
    private JLabel amountToAddJLabel;
    private JLabel otherAmountJLabel;
    private JComboBox amountToAddJComboBox;
    private JFormattedTextField otherAmountJText;
    private JButton submitJButton;
    private Boolean closed;

    public JPanel getAddMoneyJPanel() { return addMoneyJPanel; }
    public JLabel getAddMoneyJLabel() { return addMoneyJLabel; }
    public JLabel getAmountToAddJLabel() { return amountToAddJLabel; }
    public JLabel getOtherAmountJLabel() { return otherAmountJLabel; }
    public JComboBox getAmountToAddJComboBox() { return amountToAddJComboBox; }
    public JFormattedTextField getOtherAmountJText() { return otherAmountJText; }
    public JButton getSubmitJButton() { return submitJButton; }
    public Boolean getClosed() { return closed; }

    public AddMoney(){
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        getContentPane().add(this.addMoneyJPanel);
        setMinimumSize(new Dimension(500, 200));
        setResizable(false);
        setTitle("ATM - Add money");
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
