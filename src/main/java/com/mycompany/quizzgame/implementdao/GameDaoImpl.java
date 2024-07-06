/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.quizzgame.implementdao;
import com.mycompany.quizzgame.interfacedao.GameDao;
import java.sql.*;
import com.mycompany.quizzgame.utils.ConnectDB;
import  com.mycompany.quizzgame.utils.Question;
/**
 *
 * @author NiainaTR
 */
public class GameDaoImpl implements GameDao {
    
    @Override
    public Question getFirstGameQuestion(int id , String theme){
        Question question = null;
        try(Connection con = ConnectDB.getConnection()){
            final String SQL1 = "SELECT * FROM activegame where userid = ? AND theme = ?";
            
            PreparedStatement stmt1 = con.prepareStatement(SQL1);
            stmt1.setInt(1, id);
            stmt1.setString(2 , theme);
            
            ResultSet resultSet1 = stmt1.executeQuery();
            
            if(!resultSet1.next()){
                //Initialize row into activegame for user
                String nextorder = "";
                String currentorder = "";

                
                final String SQL2 = "SELECT COUNT(*) FROM " + theme;
                
                PreparedStatement stmt2 = con.prepareStatement(SQL2);
                
                ResultSet resultSet2 = stmt2.executeQuery();
                

                if (resultSet2.next()) {
                    int numberQuestions = resultSet2.getInt(1);

                    for(int i = 1 ; i <=numberQuestions ; i++){
                       currentorder += i + "/";
                    }
                    
                    final String SQL3 = "INSERT INTO activegame (userid , currentorder , nextorder , theme , errornumber , currentscore) VALUES (? , ? , ? , ? , ? , ?)";
                    PreparedStatement stmt3 = con.prepareStatement(SQL3);
                    stmt3.setInt(1 , id);
                    stmt3.setString(2 , currentorder);
                    stmt3.setString(3 , nextorder);
                    stmt3.setString(4 , theme);
                    stmt3.setInt(5 , 0);
                    stmt3.setInt(6 , 0);
                    stmt3.executeQuery();
                    
                    stmt3.close();
                }
                stmt2.close();
                resultSet2.close();
            }
            
            String currentorder = resultSet1.getString(2);
            int firstQuestion = Integer.parseInt(currentorder.split("/")[0]);
            System.out.println("first question : " + firstQuestion);
            
            stmt1.close();
            resultSet1.close(); 

            final String SQL5 = "SELECT question,type FROM "+ theme +" where id = ?";                
            PreparedStatement stmt5 = con.prepareStatement(SQL5);
            stmt5.setInt(1, firstQuestion);
            stmt5.executeQuery();

            ResultSet resultSet5 = stmt5.executeQuery();

            if(resultSet5.next()){
                String questionText = resultSet5.getString(1);
                String type = resultSet5.getString(2);

                System.out.println("question : " + questionText );
                System.out.println("type : " + type);


                if(type.equals("qcm")){
                    final String SQL6 = "SELECT * FROM propositions where theme = ? AND questionid = ?";                
                    PreparedStatement stmt6 = con.prepareStatement(SQL6);
                    stmt6.setString(1, theme);
                    stmt6.setInt(2, firstQuestion);

                    ResultSet resultSet6 = stmt6.executeQuery();
                    if(resultSet6.next()){
                        String prop1 = resultSet6.getString(2);
                        String prop2 = resultSet6.getString(3);
                        String prop3 = resultSet6.getString(4);
                        
                        String[] answerPropositions = {prop1 , prop2 , prop3};
                        
                        question = new Question(questionText , theme , firstQuestion  , type , answerPropositions);
                        
                    }

                   stmt6.close();
                   resultSet6.close();
                   

                }
                else{
                    question = new Question(questionText  , theme , firstQuestion , type , null);
                }

            }

            resultSet5.close();
            stmt5.close(); 

            
              
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        
        return question;
    }
}
