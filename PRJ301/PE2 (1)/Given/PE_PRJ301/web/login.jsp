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
        <h1>Login</h1>
        <form action="MainController" method="POST">
            <input hidden name="action" value="Login">
            username:<input name="userid" type="text"><br/>
            password:<input name="password" type="password"><br/>
            <%String error = (String) request.getAttribute("error");%>
            <% if (error != null) {%>
            <h2><%= error%></h2>
            <%}%>
            <input type="submit">
        </form>
            <form action="MainController" method="POST">
                <input hidden name="action" value="Registration">
                <input type="submit" value="Register">
            </form>
    </body>

</html>

