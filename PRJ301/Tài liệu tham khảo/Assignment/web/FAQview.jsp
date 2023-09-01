
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="obj" scope="page" class="ass.dao.FAQmng" />
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
        <h1>FAQ view</h1>
        <table>
            <tr>
                <th>Id</th>
                <th>Customer Name</th>
                <th>Content</th>

            </tr>
            <c:forEach items="${obj.getList(param.id)}" var="sos">
                <tr>
                    <td>${sos.getId()}</td>
                    <td>${sos.getCustName()}</td>
                    <td>${sos.getCustContent()}</td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
