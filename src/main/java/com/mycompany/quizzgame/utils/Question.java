/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package com.mycompany.quizzgame.utils;

/**
 *
 * @author NiainaTR
 */
public class Question {
    public String questionText;
    public String theme;
    public int id;
    public String questionType;
    public String[] answerPropositions;
    
    public Question(String questionText,String theme , int id ,  String questionType, String[] answerPropositions) {
        this.questionText = questionText;
        this.theme = theme;
        this.id = id;
        this.questionType = questionType;
        this.answerPropositions = answerPropositions;
    }

   
    
    
}
