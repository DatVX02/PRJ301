<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login Page</title>
</head>
<body>
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
