package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConfig {

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found!");
            e.printStackTrace();
        }
    }

    private static String URL =
            "jdbc:mysql://bolc8vgrk4qfb6txkf3r-mysql.services.clever-cloud.com:3306/bolc8vgrk4qfb6txkf3r?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
    private static final String USER = "upnxa8w6m8smsgtr";
    private static final String PASSWORD = "9HFsJCDJiY4nPjOaCCbz";

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            System.out.println("Connection failed");
            e.printStackTrace();
            return null;
        }
    }
}
