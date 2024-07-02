/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.quizzgame.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mycompany.quizzgame.implementdao.UserDaoImpl;
import com.mycompany.quizzgame.dto.User;

/**
 *
 * @author NiainaTR
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        String email = request.getParameter("email");
        String pwd = request.getParameter("pwd");
        
        UserDaoImpl userDaoImpl = new UserDaoImpl();
        
        User user = userDaoImpl.isUserExist(email , pwd);
        if(user != null){
            HttpSession session = request.getSession();
            session.setAttribute("username", user.getUsername());
            session.setAttribute("email" , user.getEmail());
            response.sendRedirect("Game.jsp");
        }
        else{
            response.sendRedirect("login.jsp");
        }
    }
}
