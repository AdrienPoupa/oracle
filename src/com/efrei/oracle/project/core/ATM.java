package com.efrei.oracle.project.core;

import com.efrei.oracle.project.dao.Database;
import com.efrei.oracle.project.gui.Welcome;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Adrien on 24/03/2017.
 */
public class ATM {

    // Lancer fenêtre
    // Rentrer user/mdp

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Welcome gui = new Welcome();
            JFrame frame = new JFrame();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.getContentPane().add(gui.getWelcomeJPanel());
            frame.pack();
            frame.setVisible(true);

            // Click on login button
            // todo: check login/pwd
            gui.getLoginButton().addActionListener(e -> {
                String login = gui.getWelcomeTextField().getText();
                String password = gui.getPasswordField1().getText();

                if(Security.checkLogin(login, password)){
                    System.out.println("Login success");
                    new Central();
                }
                else{
                    System.out.println("Login failed");
                    JOptionPane.showMessageDialog(new JFrame(), "Login failed", "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            });
        });
    }
}
