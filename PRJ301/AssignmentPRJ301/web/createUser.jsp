<%-- 
    Document   : createUser
    Created on : Mar 15, 2023, 10:06:02 PM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>createUser</title>
        <link rel="stylesheet" href="css/createUser.css" />
    </head>
    <body>
        <h1>CREATE NEW ACCOUNT</h1>
<!--        <div class="userID">
            <label for="userID">UserID</label>
            <input type="text" name="userID" placeholder="new userID" required>
        </div>-->

        <div class="fullname">
            <label for="fullname">Fullname</label>
            <input type="text" name="Fullname" placeholder="Fullname" required>
        </div>

        <div class="password">
            <label for="password">Password</label>
            <input type="password" name="Password" placeholder="123456" required> 
        </div>

        <div class="roleID">
            <label for="roleID">RoleID</label>
            <input type="number" placeholder="1">
        </div>
        <div class="address">
            <label for="add">Address</label>
            <input class="address1" type="text" name="Address" placeholder="Lo E2a-7,Duong D1,D. D1,Long Thanh My,Thanh Pho Thu Duc,Thanh pho Ho Chi Minh" required>
        </div>

        <div class="birthday">
            <label for="birth">Birthday</label>
            <input type="date" name="birthday" placeholder="12/02/2002">
        </div>

        <div class="phone">
            <label for="phone">Phone</label>
            <input type="text" name="Number" placeholder="0123445566" required>
        </div>

        <div class="email">
            <label for="email">Email</label>
            <input type="email" name="Email" placeholder="abc@124@gmail.com" required >
        </div>

<!--        <div class="status">
            <label for="Status">Status</label>
            <input type="radio" name="Status" id="1">1
            <input type="radio" name="Status" id="1">2
            <input type="radio" name="Status" id="1">3
            <input type="radio" name="Status" id="1">4
            <input type="radio" name="Status" id="1">5
        </div> -->

        <div class="remember">
            <label for="Remem"></label>
            <input type="checkbox"  name="Remember">Remember me
        </div>

        <div class="button">
            <input type="submit" id="submit">
            
        </div>
    </body>
</html>
