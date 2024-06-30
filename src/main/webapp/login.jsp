<%-- 
    Document   : login
    Created on : 30 juin 2024, 19:34:07
    Author     : NiainaTR
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="index.css"/>
    </head>
    <body>
        <div class="form-box">
            <form action="LoginServlet" method="post" class="form">
                <span class="title">Se connecter</span>
                <span class="subtitle">Ajouter votre information de compte.</span>
                <div class="form-container">
                    <input type="text" class="input" placeholder="Nom d'utilisateur" name="username">
                    <input type="password" class="input" placeholder="Mot de passe" name="pwd">
                </div>
                <button type="submit">Se connecter</button>
            </form>
            <div class="form-section">
              <p>Vous n'avez pas encore de compte? <a href="signup.jsp">Créer un compte</a> </p>
            </div>
        </div>
    </body>
</html>

