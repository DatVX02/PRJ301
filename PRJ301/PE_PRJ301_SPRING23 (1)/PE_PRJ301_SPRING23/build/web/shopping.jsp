<%-- 
    Document   : index
    Created on : Feb 28, 2023, 9:01:26 PM
    Author     : Hoadnt
--%>

<%@page import="pe.spring23.shopping.Product"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shopping Page</title>
    </head>
    <body>
        <h1>Welcome to Thinh's shop</h1>
        <!--your code here-->
        <form action="MainController">
            <input type="submit" value="Search all" name="action" />
            <input type="submit" value="View cart" name="action" />
        </form>


        <c:if test="${not empty requestScope.LIST}">
            <table border="1">
                <thead>
                    <tr>
                        <th>No</th>
                        <th>Product ID</th>
                        <th>Product Name</th>
                        <th>Description</th>
                        <th>Price</th>
                        <th>Add</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="p" items="${requestScope.LIST}" varStatus="count">
                    <form action="MainController">
                        <tr>
                            <td>${count.count}</td>
                            <td>${p.productID}</td>
                            <td>${p.productName}</td>
                            <td>${p.description}</td>
                            <td>${p.price}</td>
                            <td>
                                <input type="hidden" name="productID" value="${p.productID}" />
                                <input type="hidden" name="productName" value="${p.productName}" />
                                <input type="hidden" name="description" value="${p.description}" />
                                <input type="hidden" name="price" value="${p.price}" />
                                <input type="hidden" name="status" value="${p.status}" />
                                <input type="submit" value="Add" name="action" /> 

                            </td>
                        </tr>
                    </form>
                </c:forEach>
            </tbody>
        </table>
    </c:if>
    ${requestScope.MESSAGE}

--%>
<%-- <% if (request.getAttribute("LIST") != null) { %>
        <table border="1">
            <thead>
                <tr>
                    <th>No</th>
                    <th>Product ID</th>
                    <th>Product Name</th>
                    <th>Description</th>
                    <th>Price</th>
                    <th>Add</th>
                </tr>
            </thead>
            <tbody>
                <% int count = 0;
                for (Object obj : (List<Object>) request.getAttribute("LIST")) {
                    Product p = (Product) obj;
                    count++; %>
                <form action="MainController">
                    <tr>
                        <td><%= count %></td>
                        <td><%= p.getProductID() %></td>
                        <td><%= p.getProductName() %></td>
                        <td><%= p.getDescription() %></td>
                        <td><%= p.getPrice() %></td>
                        <td>
                            <input type="hidden" name="productID" value="<%= p.getProductID() %>" />
                            <input type="hidden" name="productName" value="<%= p.getProductName() %>" />
                            <input type="hidden" name="description" value="<%= p.getDescription() %>" />
                            <input type="hidden" name="price" value="<%= p.getPrice() %>" />
                            <input type="hidden" name="status" value="<%= p.getStatus() %>" />
                            <input type="submit" value="Add" name="action" /> 

                        </td>
                    </tr>
                </form>
                <% } %>
            </tbody>
        </table>
    <% } %>
    <%= request.getAttribute("MESSAGE") %>


--%>

</body>

</body>
</html>
