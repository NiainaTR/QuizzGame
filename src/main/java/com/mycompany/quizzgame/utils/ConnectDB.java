/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.quizzgame.utils;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author NiainaTR
 */
public class ConnectDB {
       private static final String URL = "jdbc:postgresql://localhost:5432/quizdb";
       private static final String USERNAME = "postgres";
       private static final String PASSWORD = "123456";
       
       public static Connection getConnection() throws SQLException {           
        try {
            // Register the PostgreSQL JDBC driver
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new SQLException("PostgreSQL JDBC Driver not found.", e);
        }
        // Ensure the JDBC URL, username, and password are correct
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    
       }
}
