<%-- 
    Document   : admin
    Created on : Mar 1, 2022, 8:29:12 PM
    Author     : hd
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Page</title>
        <jsp:useBean id="currentDate" class="java.util.Date"/>
    </head>
    <body>
        <h1>Welcome ${sessionScope.cloud.fullName}</h1>
        <form action="MainController" method="post">
            <button type="submit" name="action" value="LogOut">LogOut</button>
            
        </form>
        <form action="MainController" method="post">
            FoodID<input type="text" name="foodID" required placeholder="">
            <br>
            Food Name<input type="text" name="name" required >
            <br>

            Description<input type="text" name="descrip" required>
            <br>
            Price<input type="number" name="price" min="0" required>
            <br>
            Time<input type="number" value="${currentDate.date}" name="time" min="0" readonly="">
            <p >${mess}</p>
            <p >${mess1}</p>
            <button name="action" value="AddNew">ADD</button>
        </form>
    </body>

</html>
