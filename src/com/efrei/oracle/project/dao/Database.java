package com.efrei.oracle.project.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

    private static Connection db;

    /**
     * Return database connection
     * @return Connection
     */
    public static Connection get() {
        final String DB_URL = "jdbc:oracle:thin:@localhost:1521:XE";
        final String USER = "atm";
        final String PASS = "atm";

        if(Database.db == null) {
            try {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                Database.db = DriverManager.getConnection(DB_URL, USER, PASS);

                return Database.db;
            } catch (SQLException | ClassNotFoundException e) {
                System.out.println(e.getMessage());
            }
        }
        else{
            return Database.db;
        }

        return null;
    }

    /**
     * Logout from database
     */
    public static void logout(){
        try {
            if(Database.db != null){
                Database.db.close();
                Database.db = null;
            }
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
