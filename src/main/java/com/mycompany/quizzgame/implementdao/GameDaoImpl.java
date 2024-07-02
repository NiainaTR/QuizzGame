/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.quizzgame.implementdao;
import com.mycompany.quizzgame.interfacedao.GameDao;
import java.sql.*;
import com.mycompany.quizzgame.utils.ConnectDB;
/**
 *
 * @author tsant
 */
public class GameDaoImpl implements GameDao {
    
    @Override
    public void initializeFistGameCard(int id , String theme){
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
                    
                    final String SQL3 = "INSERT INTO activegame (id , currentorder , nextorder , theme , errornumber , currentscore) VALUES (? , ? , ? , ? , ? , ?)";
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
            else{
                /*
                String currentorder = resultSet1.getString(2);
                String firstQuestion = currentorder.split("/")[0];
                
                final String SQL4 = "";
                
                PreparedStatement stmt4 = con.prepareStatement(SQL4);
                 */
                
                
            }
            
            stmt1.close();
            resultSet1.close();    
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
}
