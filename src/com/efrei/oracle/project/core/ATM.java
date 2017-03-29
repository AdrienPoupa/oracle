package com.efrei.oracle.project.core;

import com.efrei.oracle.project.gui.Welcome;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
                System.out.println(login);
                System.out.println(password);
            });
        });
    }

}
