package org.example;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) {

        Connection conn = DatabaseConfig.getConnection();

        if (conn != null) {
            System.out.println("Connection successful");
        }
        else{
            System.out.println("Connection failed");
        }

    }
}