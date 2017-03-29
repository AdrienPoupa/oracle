package com.efrei.oracle.project.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    //  Database url
    static final String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";
    static final private String DB_URL = "jdbc:oracle:thin:@localhost:1521:XE";

    //  Database credentials
    static final private String USER = "atm";
    static final private String PASS = "atm";

    /**
     * Return database connection
     * @return Connection
     */
    public static Connection get() {
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");

            return DriverManager.getConnection(DB_URL, USER, PASS);
        }
        catch(SQLException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

        return null;
    }
}
