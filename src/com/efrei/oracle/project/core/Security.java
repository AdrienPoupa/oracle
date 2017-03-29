package com.efrei.oracle.project.core;

import com.efrei.oracle.project.dao.Database;

import java.sql.*;

/**
 * Created by Adrien on 24/03/2017.
 */
class Security {
    static Boolean checkLogin(String login, String password){
        Connection db = Database.get();
        PreparedStatement statement = null;
        ResultSet data;

        try {
            //We check if it exists an account in the bank which manages this ATM

            String loginStatement = "SELECT C.ID FROM CARD C INNER JOIN USERS U ON U.ID = C.USER_ID WHERE C.CARD = ? AND SHA1(C.PASSWORD) = SHA1(LOWER(MD5(?))) AND U.BANK = 'intern'";
            statement = db.prepareStatement(loginStatement);
            statement.setString(1, login);
            statement.setString(2, password);
            data = statement.executeQuery();

            if (data.next()) {
                return true;
            }
            else{
                //We check if it exists an account in other banks
                loginStatement = "SELECT C.ID FROM CARD C INNER JOIN USERS U ON U.ID = C.USER_ID WHERE C.CARD = ? AND SHA1(C.PASSWORD) = SHA1(LOWER(MD5(?))) AND U.BANK = 'extern'";
                statement = db.prepareStatement(loginStatement);
                statement.setString(1, login);
                statement.setString(2, password);
                data = statement.executeQuery();

                if (data.next()) {
                    return true;
                }
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return false;
    }
}
