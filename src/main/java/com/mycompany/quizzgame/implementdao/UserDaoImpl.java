/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.quizzgame.implementdao;
import com.mycompany.quizzgame.interfacedao.UserDao;
import com.mycompany.quizzgame.dto.User;
import com.mycompany.quizzgame.utils.ConnectDB;
import java.util.List;
import java.util.ArrayList;
import java.sql.*;

/**
 *
 * @author Niaina
 */
public class UserDaoImpl implements UserDao{
    
    
    private static final String INSERT_USER = "INSERT INTO users (username , email , password) values (? , ? , ?)"; 
   
    
    @Override
    public List<User> getAllUsers(){
        List<User> users = new ArrayList<>();
        return users;
    }
    
    @Override
    public void addUser(User user){
        try(Connection conn = ConnectDB.getConnection()){
           PreparedStatement stmt = conn.prepareStatement(INSERT_USER);
           stmt.setString(1 , user.getUsername());
           stmt.setString(2 , user.getEmail());
           stmt.setString(3 , user.getPassword());
           stmt.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public void updateUser(User user){
        
    }
    
    
    @Override 
    public void deleteUser(int id){
        
    }
}
