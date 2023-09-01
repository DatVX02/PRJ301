<%-- 
    Document   : viewCart
    Created on : Oct 13, 2022, 8:46:19 AM
    Author     : Acer
--%>

<%@page import="sample.tea.TeaDTO"%>
<%@page import="sample.tea.CartDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Cart Page</title>
    </head>
    <body>
        <h1>Enjoy your time bitch</h1>
        <%
            CartDTO cart = (CartDTO) session.getAttribute("CART");
            if (cart != null) {
        %>
        <table border="1">
            <thead>
                <tr>
                    <th>No</th>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Price</th>
                    <th>Quantity</th>
                    <th>Total</th>
                </tr>
            </thead>
            <tbody>
                <%
                    int count = 1;
                    double total = 0;
                    for (TeaDTO tea : cart.getCart().values()) {
                        total += tea.getQuantity() * tea.getPrice();
                %>
            <form action="MainController" method="POST">
                <tr>
                    <td><%= count++%></td>
                    <td>
                        <input type="text" name="id" value="<%= tea.getId()%>" readonly=""/>
                    </td>
                    <td><%= tea.getName()%></td>
                    <td><%= tea.getPrice()%></td>
                    <td>
                        <input type="number" name="quantity" value="<%= tea.getQuantity()%>" min="1" required=""/>
                    </td>
                    <td><%= tea.getQuantity() * tea.getPrice()%>$</td>
                    <td>
                        <input type="submit" name="action" value="Change"/>
                    </td>
                    <td>
                        <input type="submit" name="action" value="Remove"/>
                    </td>
                </tr>
            </form>
            <%
                }
            %>
        </tbody>
    </table>
    <h1>Total: <%= total %>$</h1>
    <%
        }
    %>
    <a href="shopping.jsp">Add more</a>
</body>
</html>
