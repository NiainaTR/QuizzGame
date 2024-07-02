<%-- 
    Document   : Game
    Created on : 2 juil. 2024, 12:02:31
    Author     : NiainaTR
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    
    if(session.getAttribute("username") == null){
        response.sendRedirect("login.jsp");
    }

%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello ${sessionScope.username}</h1>
        <a href="LogoutServlet">Se déconnecter</a>
    </body>
</html>
