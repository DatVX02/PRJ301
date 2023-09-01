<%-- 
    Document   : updateUser
    Created on : Aug 22, 2023, 12:15:51 PM
    Author     : ACER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h2>Update User Information</h2>
        <form action="UpdateUserServlet" method="POST">
            <input type="hidden" name="userID" value="${userToUpdate.userID}" />
            Full Name: <input type="text" name="fullName" value="${userToUpdate.fullName}" /><br />
            Role ID: <input type="text" name="roleID" value="${userToUpdate.roleID}" /><br />
            <input type="submit" value="Update" />
        </form>
    </body>
</html>
