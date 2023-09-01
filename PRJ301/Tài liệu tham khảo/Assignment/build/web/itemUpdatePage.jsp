
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
        <h1>Update Item Page</h1>

        <form action="MainController">
            <table>
                <tr>
                    <th>ID</th>
                    <th>NAME</th>
                    <th>PRICE</th>
                    <th>Category</th>
                </tr>
                <tr>
                    <td> 
                        <input type="hidden" name="id" value="${Item.getItemId()}">
                        ${Item.getItemId()}
                    </td>
                    <td> <input type="text" name="name" value="${Item.getItemName()}"></td>
                    <td> <input type="number" step="0.01" name="price" value="${Item.getPrice()}"></td>
                    <td> <select name="cateid" width="50px" required>
                            <c:forEach items="${ListCate}" var="obj">
                                <c:choose>
                                    <c:when test="${Item.getCateId() == obj.getCateId()}">
                                        <option value="${obj.getCateId()}" selected>${obj.getCateName()}</option>
                                    </c:when>    
                                    <c:otherwise>
                                        < <option value="${obj.getCateId()}">${obj.getCateName()}</option>
                                    </c:otherwise>
                                </c:choose>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
            </table>
            <br>
            <input type="hidden" name="action" value="updateItem">
            <input type="submit" value="Update">
        </form>
    </body>
</html>
