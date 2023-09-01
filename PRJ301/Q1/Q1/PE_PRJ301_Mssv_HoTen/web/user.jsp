<%-- 
    Document   : user
    Created on : Sep 29, 2022, 7:55:55 AM
    Author     : Acer
--%>

<%@page import="sample.user.UserDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User Page</title>
    </head>
    <body>
        <h1>Hello User</h1>
        <%
            UserDTO user = (UserDTO) session.getAttribute("LOGIN_USER");
            if (user == null || !"US".equals(user.getRoleID())) {
                response.sendRedirect("login.html");
                return;
            }
//            if (user == null) {
//                user = new UserDTO();
//            }
        %>
        User ID: <%= user.getUserID()%></br>
        Full Name: <%= user.getFullName()%></br>
        Role ID: <%= user.getRoleID()%></br>
        Password<%= user.getPassword()%></br>
    </body>
</html>
