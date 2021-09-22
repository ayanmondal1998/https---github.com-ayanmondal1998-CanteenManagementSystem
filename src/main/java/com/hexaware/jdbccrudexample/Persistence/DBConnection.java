package com.hexaware.jdbccrudexample.Persistence;

import java.sql.*;

public class DBConnection {

    public static Connection conn = null;

    /**
     * Connecting to MYSQL DB.
     * 
     * @return database Connection.
     */
    public static final Connection getConnect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/canteenM", 
                "root", 
                "ayanmondal@9749@#445");
            System.out.println(conn);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }// close of getConnect method
}// close of DBConnection
