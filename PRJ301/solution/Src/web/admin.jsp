<%-- 
    Document   : admin
    Created on : Mar 1, 2022, 8:29:12 PM
    Author     : hd
--%>

<%@page import="java.util.List"%>
<%@page import="java.util.List"%>
<%@page import="pe.users.UserDTO"%>
<%@page import="pe.users.UserDTO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Page</title>
    </head>
    <body>
        <h1>Welcome <%= ((pe.models.User) session.getAttribute("currentUser")).getFullName()%></h1>

        <form action="MainController" method="GET">
            Search by Full Name: <input type="text" name="fullName" value="" />
            <input type="submit" value="Search" name="action" />
        </form>   
        <h3>User List</h3>
        <table border="1">
            <thead>
                <tr>
                    <th>No</th>
                    <th>User ID</th>
                    <th>Full Name</th>
                    <th>Role ID</th>
                    <th>Status</th>
                    <th>Update</th>
                </tr>
            </thead>
            <tbody>
                <%
                    int count = 1;
                    List<UserDTO> userList = (List<UserDTO>) request.getAttribute("userList");
                    if (userList != null) {
                        for (UserDTO user : userList) {
                %>
                <tr>
                    <td><%= count++%></td>
                    <td><%= user.getUserID()%></td>
                    <td><%= user.getFullName()%></td>
                    <td><%= user.getRoleID()%></td>
                    <td><%= user.getStatus()%></td>
                    <td>
                        <a href="UpdateUserServlet?userID=<%= user.getUserID()%>">Update</a>
                    </td>
                </tr>
                <%
                        }
                    }
                %>
            </tbody>
        </table>

        <a href="MainController?action=logout">Logout</a>
    </body>
</html>
