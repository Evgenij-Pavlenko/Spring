package com.luv2code.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestJdbc {
    public static void main(String[] args) {
        String jdbcUrl = "jdbc:mysql://localhost:3306/hb-01-one-to-one-uni?useSSL=false&serverTimezone=UTC";
        String user = "hbstudent";
        String pass = "hbstudent";

        System.out.println("Connecting to database: " + jdbcUrl);
        try {
            Connection myConn = DriverManager.getConnection(jdbcUrl, user, pass);
            System.out.println("Connection sucessful");

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
