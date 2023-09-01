<%-- 
    Document   : createClass
    Created on : Apr 20, 2023, 9:11:29 AM
    Author     : lnhtr
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create Class</title>
    </head>
    <body>
        <form action="createClassAction" method="post">
            Class Name: <input type="text" name="txtClassName" value="" />
            <input type="submit" value="Create Class" />
        </form>
    </body>
</html>
