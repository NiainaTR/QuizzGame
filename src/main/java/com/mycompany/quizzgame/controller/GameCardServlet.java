/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.quizzgame.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.mycompany.quizzgame.implementdao.GameDaoImpl;
import com.mycompany.quizzgame.utils.Question;
/**
 *
 * @author tsant
 */
@WebServlet(name = "GameCardServlet", urlPatterns = {"/GameCardServlet"})
public class GameCardServlet extends HttpServlet {
    
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
        
        HttpSession session = request.getSession(false);
        String theme = request.getParameter("theme");
        
        if(session != null){
           int id = (int)session.getAttribute("id");
           GameDaoImpl game = new GameDaoImpl();
           System.out.println("id : " + id + " theme : " + theme);
           Question firstQuestion = game.getFirstGameQuestion(id, theme);
           if(firstQuestion != null){
               System.out.println("first question : " + firstQuestion.questionText);
            
               request.setAttribute("firstQuestion" , firstQuestion);
               request.getRequestDispatcher("gamecard.jsp").forward(request, response);
            }
        }
        else{
            response.sendRedirect("/QuizzGame/");
        }
    }

}
