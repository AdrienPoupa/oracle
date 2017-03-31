package com.efrei.oracle.project.core;

import com.efrei.oracle.project.dao.Database;
import com.efrei.oracle.project.gui.*;
import javax.swing.*;
import java.sql.*;

/**
 * Created by Adrien on 24/03/2017.
 */
class Central {
    private int card;
    private Home home;
    private AddMoney addMoney;
    private Withdraw withdraw;
    private CheckAccount checkAccount;

    Central(int card) {
        this.card = card;
        Connection db = Database.get();

        SwingUtilities.invokeLater(() -> {
            home = (Home) Routing.route("home", card);

            // Check account
            home.getCheckAccountButton().addActionListener(e -> {
                if(checkAccount != null && !checkAccount.getClosed()) {
                    checkAccount.updateAccount();
                    checkAccount.toFront();
                }
                else {
                    checkAccount = (CheckAccount) Routing.route("checkAccount", card);
                }
            });

            // Add money
            home.getAddButton().addActionListener(e -> {
                if(addMoney != null && !addMoney.getClosed()) {
                    addMoney.toFront();
                }
                else {
                    addMoney = (AddMoney) Routing.route("addMoney", card);
                }

                addMoney.getAmountToAddJComboBox().addActionListener(f -> {
                    String amount = (String) addMoney.getAmountToAddJComboBox().getSelectedItem();

                    if(amount.equals("Other amount")) {
                        addMoney.getOtherAmountJText().setEnabled(true);
                    }
                    else {
                        addMoney.getOtherAmountJText().setEnabled(false);
                    }
                });

                addMoney.getSubmitJButton().addActionListener(f -> {
                    String amount = (String) addMoney.getAmountToAddJComboBox().getSelectedItem();
                    String other = addMoney.getOtherAmountJText().getText();
                    int amountInteger = 0;

                    if(amount.equals("Other amount")) {
                        addMoney.getOtherAmountJText().setEnabled(true);

                        try {
                            amountInteger = Integer.parseInt(other);
                        }
                        catch (NumberFormatException ex) {
                            JOptionPane.showMessageDialog(new JFrame(), "This amount is not valid", "Error", JOptionPane.ERROR_MESSAGE);
                            ex.printStackTrace();
                        }
                    }
                    else {
                        addMoney.getOtherAmountJText().setEnabled(false);
                        amountInteger = Integer.parseInt(amount);
                    }

                    if(amountInteger % 5 != 0 && amountInteger <= 0) {
                        JOptionPane.showMessageDialog(new JFrame(), "This amount is not valid", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    else {
                        try {
                            assert db != null;
                            db.setAutoCommit(false);
                            Statement statement = db.createStatement();
                            statement.execute("LOCK TABLE OPERATION IN EXCLUSIVE MODE");
                            statement.execute("INSERT INTO OPERATION (BALANCE, CARD_ID, CREATED_AT) VALUES (" + amountInteger + ", " + this.card + ", CURRENT_DATE)");
                            db.commit();

                            if(checkAccount != null && !checkAccount.getClosed()) {
                                checkAccount.updateAccount();
                            }

                            JOptionPane.showMessageDialog(new JFrame(), "Your balance account has been successfully updated", "Error", JOptionPane.INFORMATION_MESSAGE);
                        }
                        catch (SQLException ex) {
                            ex.printStackTrace();

                            try {
                                db.rollback();
                            }
                            catch (SQLException ex1) {
                                ex1.printStackTrace();
                            }
                        }
                    }
                });
            });

            // Withdraw
            home.getWithdrawButton().addActionListener(e -> {
                if(withdraw != null && !withdraw.getClosed()) {
                    withdraw.toFront();
                }
                else {
                    withdraw = (Withdraw) Routing.route("withdraw", card);
                }

                withdraw.getAmountToWithdrawJComboBox().addActionListener(f -> {
                    String amount = (String) withdraw.getAmountToWithdrawJComboBox().getSelectedItem();

                    if(amount.equals("Other amount")) {
                        withdraw.getOtherAmountJText().setEnabled(true);
                    }
                    else {
                        withdraw.getOtherAmountJText().setEnabled(false);
                    }
                });

                withdraw.getWithdrawButton().addActionListener(f -> {
                    String amount = (String) withdraw.getAmountToWithdrawJComboBox().getSelectedItem();
                    String other = withdraw.getOtherAmountJText().getText();
                    int amountInteger = 0;

                    if(amount.equals("Other amount")) {
                        withdraw.getOtherAmountJText().setEnabled(true);

                        try {
                            amountInteger = Integer.parseInt(other);
                        }
                        catch (NumberFormatException ex) {
                            JOptionPane.showMessageDialog(new JFrame(), "This amount is not valid", "Error", JOptionPane.ERROR_MESSAGE);
                            ex.printStackTrace();
                        }
                    }
                    else {
                        withdraw.getOtherAmountJText().setEnabled(false);
                        amountInteger = Integer.parseInt(amount);
                    }

                    if(amountInteger % 5 != 0 && amountInteger <= 0) {
                        JOptionPane.showMessageDialog(new JFrame(), "This amount is not valid", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    else {
                        try {
                            ResultSet data;
                            int account = 0;

                            assert db != null;
                            db.setAutoCommit(false);
                            Statement statement = db.createStatement();
                            statement.execute("LOCK TABLE OPERATION IN EXCLUSIVE MODE");

                            PreparedStatement preparedStatement = db.prepareStatement("SELECT SUM(BALANCE) BALANCE_SUM FROM OPERATION WHERE CARD_ID = ?");
                            preparedStatement.setInt(1, card);
                            data = preparedStatement.executeQuery();

                            while (data.next()){
                                account = data.getInt("BALANCE_SUM");
                            }

                            if(amountInteger <= account){
                                statement.execute("INSERT INTO OPERATION (BALANCE, CARD_ID, CREATED_AT) VALUES ( -" + amountInteger + ", " + this.card + ", CURRENT_DATE)");

                                if(checkAccount != null && !checkAccount.getClosed()) {
                                    checkAccount.updateAccount();
                                }

                                JOptionPane.showMessageDialog(new JFrame(), "Success. Please wait for your money", "Error", JOptionPane.INFORMATION_MESSAGE);
                            }
                            else{
                                JOptionPane.showMessageDialog(new JFrame(), "You don't have money enough on your account", "Error", JOptionPane.ERROR_MESSAGE);
                            }

                            db.commit();
                        }
                        catch (SQLException ex) {
                            ex.printStackTrace();

                            try {
                                db.rollback();
                            }
                            catch (SQLException ex1) {
                                ex1.printStackTrace();
                            }
                        }
                    }
                });
            });

            home.getLogOutButton().addActionListener(e -> {
                home.dispose();
            });
        });
    }
}
