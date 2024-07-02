<%-- 
    Document   : gamecard
    Created on : 2 juil. 2024, 17:18:50
    Author     : NiainaTR
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="" %>
<%
    
    if(session.getAttribute("username") == null){
        response.sendRedirect("login.jsp");
    }

    //initialize first card
    
    
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
    </body>
</html>
