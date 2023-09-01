<%-- 
    Document   : addComestic
    Created on : Aug 15, 2023, 9:03:36 AM
    Author     : Admin
--%>

<%@page import="pe.models.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            User currentUser = (User) session.getAttribute("currentUser");
            if (currentUser != null && !currentUser.getRoleID().equals("AD")) {
                response.sendRedirect("login.jsp");
            }
        %>
         <h1>Add Comestic</h1>
        <form action="MainController" method="POST">
            <input hidden value="AddComestic" name="action">
            id:<input type="text" name="id"><br/>
            name:<input type="text" name="name"><br/>
            description:<input type="text" name="description"><br/>
            price:<input type="number" name="price"><br/>
            size:<input type="number" name="size"><br/>
            <input type="submit">
        </form>
        <h2>${error}</h2>
        <h2>${success}</h2>
        <h2>${errorCreate}</h2>
    </body>
</html>
