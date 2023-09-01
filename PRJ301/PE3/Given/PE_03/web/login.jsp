

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>
        <form action="MainController" method="post">
            UserID <input name="userID" required=""> <br>
            Password <input name="pass" required=""> <br>
            <p >${mess}</p>
            <p >${mess1}</p>
            <button type="submit" name="action" value="Login">LogIN</button>
            
        </form>
    </body>
</html>
