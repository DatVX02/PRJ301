
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
        <h1>FAQ page</h1>
        <table>
            <tr>
                <th>Item Name</th>
                <th>View FAQ</th>
            </tr>
            <c:forEach items="${ListItem}" var="obj">
                <tr>
                    <td>${obj.getItemName()}</td>
                    <td><a href="MainController?action=faqview&id=${obj.getItemId()}">View</a></td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
