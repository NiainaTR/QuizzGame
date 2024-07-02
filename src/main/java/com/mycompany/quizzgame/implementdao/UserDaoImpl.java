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
  
    
    @Override
    public List<User> getAllUsers(){
        List<User> users = new ArrayList<>();
        return users;
    }
    
    @Override
    public void addUser(User user){        
        try(Connection conn = ConnectDB.getConnection()){
           final String INSERT_USER = "INSERT INTO users (username , email , password) values (? , ? , ?)";  
           PreparedStatement stmt = conn.prepareStatement(INSERT_USER);
           stmt.setString(1 , user.getUsername());
           stmt.setString(2 , user.getEmail());
           stmt.setString(3 , user.getPassword());
           stmt.executeUpdate();
        
           System.out.println("user insert into database successfully");
           
           
           stmt.close();
           conn.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public void updateUser(User user){
        
    }
    
    
    @Override 
    public void deleteUser(String email){
        
    }
    
    
    @Override
    public User isUserExist(String email , String password){
        User user = null;
        
        try(Connection con = ConnectDB.getConnection()){
            final String CHECK_USER_ACCOUNT = "SELECT * FROM users WHERE  email = ? AND password = ?";
            PreparedStatement stmt = con.prepareStatement(CHECK_USER_ACCOUNT);
            stmt.setString(1 , email);
            stmt.setString(2 , password);
            
            ResultSet resultSet = stmt.executeQuery();
            if(resultSet.next()){                
               user = new User(resultSet.getString("username") , resultSet.getString("email") , resultSet.getString("password"));
            }     
            
            resultSet.close();
            stmt.close();
            con.close();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        
        return user;
    }
    
}
