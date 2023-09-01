<%-- 
    Document   : registration
    Created on : Aug 15, 2023, 4:39:30 AM
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
        <h1>Registration</h1>
        <form method="POST" action="MainController">
            <input hidden name="action" value="create">
            fullname: <input type="text" name="fullName" required><br/>
            userid: <input type="text" name="userID" required><br/>
            email: <input type="text" name="email" ><br/>
            password: <input type="password" name="password"><br/>
            <input type="submit">
        </form>
        <h2>${errorCreate}</h2>
    </body>
</html>
