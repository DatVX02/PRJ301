<%-- 
    Document   : login
    Created on : Mar 11, 2022, 9:02:11 PM
    Author     : hd
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>
        <!--your code here-->
        <form action="MainController" method="POST">
            <input type="hidden" name="action" value="login">
            UserID: <input type="text" name="userID"><br>
            Password: <input type="password" name="password"><br>
            <input type="submit" value="Login" name="action">
            <p><font color="red">${message}</font></p>
        </form>
        ${error}
    </body>

</html>

