package com.efrei.oracle.project.core;

import com.efrei.oracle.project.gui.AddMoney;
import com.efrei.oracle.project.gui.CheckAccount;
import com.efrei.oracle.project.gui.LoggedIn;
import com.efrei.oracle.project.gui.Withdraw;

import javax.swing.*;

/**
 * Created by Adrien on 24/03/2017.
 */
public class Central {

    // Choix de l'action à réaliser
    // Dépot, retrait, RIB
    // Check argent sur le compte

    public Central() {
        SwingUtilities.invokeLater(() -> {
            LoggedIn gui = new LoggedIn();
            JFrame frame = new JFrame();
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.getContentPane().add(gui.getLoggedInJPanel());
            frame.pack();
            frame.setVisible(true);

            // Check account
            gui.getCheckAccountButton().addActionListener(e -> {
                // Open new window
                CheckAccount guiAccount = new CheckAccount();
                JFrame frameAccount = new JFrame();
                frameAccount.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frameAccount.getContentPane().add(guiAccount.getCheckAccount());
                frameAccount.pack();
                frameAccount.setVisible(true);
            });

            // Add money
            gui.getAddButton().addActionListener(e -> {
                // Open new window
                AddMoney guiMoney = new AddMoney();
                JFrame frameMoney = new JFrame();
                frameMoney.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frameMoney.getContentPane().add(guiMoney.getAddMoneyJPanel());
                frameMoney.pack();
                frameMoney.setVisible(true);

                guiMoney.getSubmitJButton().addActionListener(f -> {
                    // do something on Submit button
                });
            });

            // Withdraw
            gui.getWithdrawButton().addActionListener(e -> {
                // Open new window
                Withdraw guiWithdraw = new Withdraw();
                JFrame frameWithdraw = new JFrame();
                frameWithdraw.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frameWithdraw.getContentPane().add(guiWithdraw.getWithdrawJPanel());
                frameWithdraw.pack();
                frameWithdraw.setVisible(true);

                guiWithdraw.getWithdrawButton().addActionListener(f -> {
                    // do something on Submit button
                });
            });
        });
    }

}
