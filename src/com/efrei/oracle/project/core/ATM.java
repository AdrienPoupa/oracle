package com.efrei.oracle.project.core;

import com.efrei.oracle.project.gui.Welcome;
import javax.swing.*;

/**
 * Created by Adrien on 24/03/2017.
 */
public class ATM {

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch (UnsupportedLookAndFeelException | ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }

        SwingUtilities.invokeLater(() -> {
            Welcome gui = (Welcome) Routing.route("login", 1);

            gui.getLoginButton().addActionListener(e -> {
                String login = gui.getWelcomeTextField().getText();
                String password = gui.getPasswordField1().getText();

                if(Security.checkLogin(login, password)){
                    System.out.println("Login success");
                    gui.dispose();
                    new Central(Security.getCardId(login));
                }
                else{
                    System.out.println("Login failed");
                    JOptionPane.showMessageDialog(new JFrame(), "Login failed", "Error", JOptionPane.ERROR_MESSAGE);
                }
            });
        });
    }
}
