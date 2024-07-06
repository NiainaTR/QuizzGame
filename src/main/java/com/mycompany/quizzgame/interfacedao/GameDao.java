/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.quizzgame.interfacedao;
import com.mycompany.quizzgame.utils.Question;

/**
 *
 * @author NiainaTR
 */



public interface GameDao {
    Question getFirstGameQuestion(int id , String theme);
}
