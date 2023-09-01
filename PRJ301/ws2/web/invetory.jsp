<%-- 
    Document   : invetory
    Created on : Apr 24, 2023, 4:13:17 PM
    Author     : lnhtr
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inventory</title>
    </head>
    <body>
        <h1>Inventory</h1>
        <c:set var="result" value="${sessionScope.INVENTORY}"/>
        <c:if test="${not empty result}">
            <table border="1">
                <thead>
                    <tr>
                        <th>No.</th>
                        <th>ID</th>
                        <th>Name</th>
                        <th>Quantity</th>
                        <th>Action</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="dto" items="${result}" varStatus="counter">
                    <form action="removeInventoryAction" method="POST">
                        <tr> 
                            <td>
                                ${counter.count}
                            </td>
                            <td>
                                ${dto.ID}
                                <input type="hidden" name="txtID" 
                                       value="${dto.ID}" />
                            </td>
                            <td>
                                ${dto.name}
                            </td>
                            <td>
                                ${dto.quantity}
                            </td>
                            
                            <td>
                                <input type="submit" value="Delete" />
                            </td>
                        </tr>

                    </c:forEach>
                    <tr>
                        <td colspan="5">
                            <a href="createNewInventory.jsp">Add Product Inventories</a>
                        </td>
                       
                    </tr>
                    </tbody>

            </table>
        </form>

                <form action="showInventoryLowAction" method="POST">
                    <input type="submit" value="check to low Inventory" />
                </form>       
    </c:if>

</body>
</html>
