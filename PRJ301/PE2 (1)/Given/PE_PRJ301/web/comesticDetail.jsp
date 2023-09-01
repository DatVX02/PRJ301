<%-- 
    Document   : comesticDetail
    Created on : Aug 15, 2023, 11:34:37 AM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Edit Comestic</h1>
        <form action="MainController" method="POST">
            <input type="hidden" name="action" value="UpdateComestic">
            <input type="hidden" name="id" value="<%= request.getParameter("id")%>">
            Name: <input type="text" name="name" value="<%= request.getParameter("name")%>"><br>
            Description: <input type="text" name="description" value="<%= request.getParameter("description")%>"><br>
            Price: <input type="text" name="price" value="<%= request.getParameter("price")%>"><br>
            Size: <input type="text" name="size" value="<%= request.getParameter("size")%>"><br>
            <input type="submit" value="Update">
        </form>
    </body>
</html>
