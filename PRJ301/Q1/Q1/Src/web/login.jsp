<%-- 
    Document   : login
    Created on : Sep 29, 2022, 7:50:14 AM
    Author     : Acer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <!--        <title>Login Page</title>
                <meta charset="UTF-8">
                <meta name="viewport" content="width=device-width, initial-scale=1.0">-->
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>
        <form action="MainController" method="POST">
            User ID<input type="text" name="userID"/></br>
            Password<input type="password" name="password"/></br>
            <input type="submit" name="action" value="Login"/>
            <input type="reset" value="Reset"/>
        </form>
        <h1><%= request.getAttribute("ERROR")%></h1>
    </body>
</html>
