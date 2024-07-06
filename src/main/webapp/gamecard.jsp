<%-- 
    Document   : gamecard
    Created on : 2 juil. 2024, 17:18:50
    Author     : NiainaTR
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.mycompany.quizzgame.implementdao.GameDaoImpl" %>
<%@page import="com.mycompany.quizzgame.utils.Question" %>

<%
    
    if(session.getAttribute("username") == null){
        response.sendRedirect("/QuizzGame/");
    }
    
    Question firstQuestion = (Question) request.getAttribute("firstQuestion");
    
%>
<!DOCTYPE html>
<html>
<head>
    <title></title>
    <meta charset="utf-8">
    <link rel="stylesheet" href="styles.css">
</head>
<body style="background: #e0ecfb;">
    <div class="container">
        <div class="card">
            <div class="face face1">
                <div class="content">
                    <h3 style="text-align:center;margin-top:20px;"><%= firstQuestion.questionText%></h3>
                    <div class="img" style="text-align:center;margin-bottom:60px;">
                        <img src="./images-quiz/<%= firstQuestion.theme%>/<%=firstQuestion.id%>.png" width="100px" style="border-radius:20px;">
                    </div>

                    <form action="" method="post" style="margin-bottom:10px">
                        <div style="text-align:center;margin-top:15px;">
                            
                             <% if (!firstQuestion.questionType.equals("qcm")) { %>
                                <input type="text" placeholder="Entrez votre réponse" name="reponse" style="margin-bottom:8px;" autocomplete="off"><br>
                            <% } else { 
                                String[] propositions = firstQuestion.answerPropositions;
                                if (propositions != null) {
                                    for (String prop : propositions) { %>
                                        <input type="radio" value="<%= prop %>" name="prop"><label for="<%= prop %>"><%= prop %></label><br>
                                    <% }
                                }
                            } %>                              
                        <button type="submit">Valider</button>
                        </div>
                    </form>
                   <div class="lien" style="text-align:center">
                    <a href="" style="color:black; text-decoration:none;font-size:13px">BACK HOME</a><br>
                    <a href="" style="color:orchid; text-decoration:none;font-size:13px">Signaler!</a>
                       
                    </div>
                    

                </div>

            </div>
            <div class="face face2" style="background: #e0ecfb;">
                <h2><%= firstQuestion.id %></h2>
            </div>

        </div>

    </div>
    
   


</body>



</html>

