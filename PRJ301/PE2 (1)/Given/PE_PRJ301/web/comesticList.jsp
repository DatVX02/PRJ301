<%-- 
    Document   : comesticList
    Created on : Aug 15, 2023, 4:57:08 AM
    Author     : Admin
--%>

<%@page import="java.util.List"%>
<%@page import="pe.models.Comestic"%>
<%@page import="pe.utils.DAO"%>
<%@page import="pe.models.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            User currentUser = (User) session.getAttribute("currentUser");
            if (currentUser != null && !currentUser.getRoleID().equals("AD")) {
                response.sendRedirect("login.jsp");
            }
        %>
        <h1>comesticList, welcome ${currentUser.getFullName()}!</h1>

        <form action="MainController" method="GET">
            <input type="hidden" name="action" value="Search">
            Search by Name: <input type="text" name="searchName">
            <input type="submit" name = "action" value="Search">
        </form>

        <form action="MainController" method="POST">
            <input hidden value="AddDirectory" name="action">
            <button type="submit">Add Comestic</button>
        </form>


        <form action="MainController" method="POST">
            <input hidden value="Logout" name="action">
            <button type="submit">Logout</button>
        </form>
        <% 
            List<Comestic> comestics = (List<Comestic>)session.getAttribute("comist");
            if (comestics != null) {%>
        <table border="2">
            <thead>
                <tr>
                    <th>Comestic id</th>
                    <th>Name</th>
                    <th>Description</th>
                    <th>price</th>
                    <th>size</th>
                    <th>status</th>
                    <th>Action</th>
                </tr>
            </thead>
            <tbody>
                <%for (Comestic comestic : comestics) {%>
                <tr>
                    <td><%= comestic.getId()%></td>
                    <td><%= comestic.getName()%></td>
                    <td><%= comestic.getDescription()%></td>
                    <td><%= comestic.getPrice()%></td>
                    <td><%= comestic.getSize()%></td>
                    <td><%= comestic.isStatus()%></td>
                    <td>
                        <form action="MainController">
                            <input hidden value="Delete" name="action">
                            <input hidden value="<%= comestic.getId()%>" name="id">
                            <input type="submit" value="Delete">
                        </form>
                        <form action="MainController">
                            <input hidden value="Edit" name="action">
                            <input hidden value="<%= comestic.getId()%>" name="id">
                            <input hidden value="<%= comestic.getName()%>" name="name">
                            <input hidden value="<%= comestic.getDescription()%>" name="description">
                            <input hidden value="<%= comestic.getPrice()%>" name="price">
                            <input hidden value="<%= comestic.getSize()%>" name="size">
                            <input hidden value="<%= comestic.isStatus()%>" name="status">
                            <input type="submit" value="Edit">
                        </form>
                    </td>
                </tr>
                <%}%>
            </tbody>
        </table>
        <%} else { 
        DAO dao = new DAO();
        comestics = dao.getAllComestic();
        %>
                <table border="2">
            <thead>
                <tr>
                    <th>Comestic id</th>
                    <th>Name</th>
                    <th>Description</th>
                    <th>price</th>
                    <th>size</th>
                    <th>status</th>
                    <th>Action</th>
                </tr>
            </thead>
            <tbody>
                <%for (Comestic comestic : comestics) {%>
                <tr>
                    <td><%= comestic.getId()%></td>
                    <td><%= comestic.getName()%></td>
                    <td><%= comestic.getDescription()%></td>
                    <td><%= comestic.getPrice()%></td>
                    <td><%= comestic.getSize()%></td>
                    <td><%= comestic.isStatus()%></td>
                    <td>
                        <form action="MainController">
                            <input hidden value="Delete" name="action">
                            <input hidden value="<%= comestic.getId()%>" name="id">
                            <input type="submit" value="Delete">
                        </form>
                        <form action="MainController">
                            <input hidden value="Edit" name="action">
                            <input hidden value="<%= comestic.getId()%>" name="id">
                            <input hidden value="<%= comestic.getName()%>" name="name">
                            <input hidden value="<%= comestic.getDescription()%>" name="description">
                            <input hidden value="<%= comestic.getPrice()%>" name="price">
                            <input hidden value="<%= comestic.getSize()%>" name="size">
                            <input hidden value="<%= comestic.isStatus()%>" name="status">
                            <input type="submit" value="Edit">
                        </form>
                    </td>
                </tr>
                <%}%>
            </tbody>
        </table>
        <% } %>

    </body>
</html>
