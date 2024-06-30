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
            return DriverManager.getConnection(URL , USERNAME  , PASSWORD);
       }
}
