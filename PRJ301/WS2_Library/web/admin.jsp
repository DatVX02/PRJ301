<%-- 
    Document   : admin
    Created on : Mar 1, 2022, 8:29:12 PM
    Author     : hd
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="pe.food.BookDTO"%>
<%@page import="pe.food.BookDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Admin Page</title>
    </head>
    <body>
        <h1>Welcome <%= ((pe.models.User) session.getAttribute("currentUser")).getFullName()%></h1>
        <form action="MainController" method="POST">
            ID : <input type="text" name="txtID" value="B-" maxlength="5"/>
            </br>
            Name: <input type="text" name="txtName" value="" />
            </br>
            Description: <input type="text" name="txtDescription" value="" />
            </br>
            Price: <input type="number" name="txtprice" value="" />
            </br>
            <input type="submit" value="Save" name="action" />
        </form>
        </br>
        <form action="SearchBookServlet">
            Search <input type="text" name="keyword" value="" />
            <input type="submit" value="Search" name="action" />
        </form>
        
        <h3>Book List</h3>
        <%
            ArrayList<BookDTO> book = (ArrayList<BookDTO>) request.getAttribute("bookList");
            if(book == null){
            BookDAO dao = new BookDAO();
            book = (ArrayList<BookDTO>) dao.getALLBook();
            if (book != null) {
        %>
        <table border="1">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Description</th>
                    <th>Price</th>
                    <th>Delete</th>
                    <th>Edit</th>
                </tr>
            </thead>
            <tbody>
                <% for (BookDTO b : book) {
                %>                      
                <tr>
                    <td><%= b.getId()%></td>
                    <td><%= b.getName()%></td>
                    <td><%= b.getDescription()%></td>
                    <td><%= b.getPrice()%></td>
                    <td>
                        <a href="DeleteBookServlet?id=<%= b.getId()%>">Delete</a>
                    </td>
                    <td>
                        <a href="doEditBook?id=<%= b.getId()%>">Edit</a>
                    </td>

                </tr>
                <%
                    }
                %>
            </tbody>
        </table>

        <%
            }
        }else{
%>
                <table border="1">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Description</th>
                    <th>Price</th>
                    <th>Delete</th>
                    <th>Edit</th>
                </tr>
            </thead>
            <tbody>
                <% for (BookDTO b : book) {
                %>                      
                <tr>
                    <td><%= b.getId()%></td>
                    <td><%= b.getName()%></td>
                    <td><%= b.getDescription()%></td>
                    <td><%= b.getPrice()%></td>
                    <td>
                        <a href="DeleteBookServlet?id=<%= b.getId()%>">Delete</a>
                    </td>
                    <td>
                        <a href="doEditBook?id=<%= b.getId()%>">Edit</a>
                    </td>

                </tr>
                <%
                    }
                %>
            </tbody>
        </table>
            <%
        }
        %>
        </br>
        <a href="MainController?action=logout">Logout</a>
    </body>
</html>