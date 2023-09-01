<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            table, tr, th, td{
                border: solid 1px;
            }
        </style>
    </head>
    <body>
        <h1>Item management</h1>
        <table>
            <tr>
                <th>ItemId</th>
                <th>ItemName</th>
                <th>Price</th>
                <th>CateId</th>
                <th>Action</th>

            </tr>
            <c:forEach items="${listItems}" var="obj">
                <tr>
                    <td>${obj.getItemId()}</td>
                    <td>${obj.getItemName()}</td>
                    <td>${obj.getPrice()}</td>
                    <td>${obj.getCateId()}</td>
                    <td><a href="MainController?action=editItem&itemid=${obj.getItemId()}">edit</a></td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
