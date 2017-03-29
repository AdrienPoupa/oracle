package com.efrei.oracle.project.core;

import com.efrei.oracle.project.gui.Welcome;

import javax.swing.*;

/**
 * Created by Adrien on 24/03/2017.
 */
public class ATM {

    // Lancer fenêtre
    // Rentrer user/mdp

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Welcome gui = new Welcome();
                JFrame frame = new JFrame();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.getContentPane().add(gui.getWelcomeJPanel());
                frame.pack();
                frame.setVisible(true);
            }
        });
    }

}
