<%-- 
    Document   : signup
    Created on : 30 juin 2024, 19:34:24
    Author     : tsant
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
            <form class="form">
                <span class="title">Créer un compte</span>
                <span class="subtitle">Ajouter vos information afin de créer votre compte.</span>
                <div class="form-container">
                    <input type="text" class="input" placeholder="Username">
                    <input type="email" class="input" placeholder="Email">
                    <input type="password" class="input" placeholder="Mot de passe">
                </div>
                <button>Valider</button>
            </form>
            <div class="form-section">
              <p>Vous avez déjà un compte? <a href="login.jsp">Se connecter</a></p>
            </div>
        </div>
    </body>
</html>
