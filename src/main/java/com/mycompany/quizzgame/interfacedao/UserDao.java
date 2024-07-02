/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package com.mycompany.quizzgame.interfacedao;
import com.mycompany.quizzgame.dto.User;
import java.util.List;
/**
 *
 * @author NiainaTR
 */
public interface UserDao {
    List<User> getAllUsers();
    void addUser(User user);
    void deleteUser(String email);
    void updateUser(User user);
    User isUserExist(String email , String password);
}
