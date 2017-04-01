package com.efrei.oracle.project.gui;

import com.efrei.oracle.project.dao.Database;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.*;

/**
 * Created by Adrien on 29/03/2017.
 */
public class CheckAccount extends JFrame {
    private JPanel checkAccount;
    private JTable historyTable;
    private JLabel amountValueJLabel;
    private JLabel amountAvailableJLabel;
    private Boolean closed;
    private int card;

    public JPanel getCheckAccount() {
        return checkAccount;
    }
    public JTable getHistoryTable() {
        return historyTable;
    }
    public JLabel getAmountValueJLabel() {
        return amountValueJLabel;
    }
    public JLabel getAmountAvailableJLabel() {
        return amountAvailableJLabel;
    }
    public Boolean getClosed() { return closed; }

    public CheckAccount(int card){
        this.card = card;
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().add(checkAccount);
        setMinimumSize(new Dimension(500, 200));
        setResizable(false);
        setTitle("ATM - Check account");
        pack();
        setVisible(true);
        closed = false;
        updateAccount();
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                closed = true;
            }
        });

        historyTable.setRowHeight(25);
    }

    public void updateAccount(){
        Connection db = Database.get();
        PreparedStatement statement = null;
        ResultSet data = null;

        try {
            assert db != null;
            statement = db.prepareStatement("SELECT SUM(BALANCE) BALANCE_SUM FROM OPERATION WHERE CARD_ID = ?");
            statement.setInt(1, card);
            data = statement.executeQuery();

            while (data.next()){
                amountValueJLabel.setText(data.getString("BALANCE_SUM") + "€");
            }

            statement = db.prepareStatement("SELECT BALANCE, TO_CHAR(CREATED_AT, 'DD/MM/YYYY HH24:MI') CREATED_DATE FROM OPERATION WHERE CARD_ID = ? ORDER BY CREATED_AT ASC", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            statement.setInt(1, card);
            data = statement.executeQuery();

            int i = 0;

            while (data.next()){
                i++;
            }

            Object [][] histories = new Object[i][2];
            Object [] headers = {"Amount", "Date"};

            data.beforeFirst();
            i = 0;

            while (data.next()){
                histories[i][0] = data.getString("BALANCE") + "€";
                histories[i][1] = data.getString("CREATED_DATE");
                i++;
            }

            DefaultTableModel tableModel = new DefaultTableModel(histories, headers);
            historyTable.setModel(tableModel);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
