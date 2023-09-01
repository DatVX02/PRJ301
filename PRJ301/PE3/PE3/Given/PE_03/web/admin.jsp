<%-- 
    Document   : admin
    Created on : Mar 1, 2022, 8:29:12 PM
    Author     : hd
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="pe.food.FoodDTO"%>
<%@page import="pe.food.FoodDAO"%>
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
            ID : <input type="text" name="txtID" value="F-" maxlength="5"/>
            </br>
            Name: <input type="text" name="txtName" value="" />
            </br>
            Description: <input type="text" name="txtDescription" value="" />
            </br>
            Price: <input type="number" name="txtprice" value="" />
            </br>
            Cookingtime: <input type="number" name="txtcooking" value="" />
            </br>
            <input type="submit" value="Save" name="action" />
        </form>
        </br>
        <form action="SearchFoodServlet">
            Search <input type="text" name="keyword" value="" />
            <input type="submit" value="Search" name="action" />
        </form>
        
        <h3>Food List</h3>
        <%
            ArrayList<FoodDTO> food = (ArrayList<FoodDTO>) request.getAttribute("foodList");
            if(food == null){
            FoodDAO dao = new FoodDAO();
            food = (ArrayList<FoodDTO>) dao.getALLFood();
            if (food != null) {
        %>
        <table border="1">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Description</th>
                    <th>Price</th>
                    <th>Cookingtime</th>
                    <th>Delete</th>
                    <th>Edit</th>
                </tr>
            </thead>
            <tbody>
                <% for (FoodDTO f : food) {
                %>                      
                <tr>
                    <td><%= f.getId()%></td>
                    <td><%= f.getName()%></td>
                    <td><%= f.getDescription()%></td>
                    <td><%= f.getPrice()%></td>
                    <td><%= f.getCookingtime()%></td>
                    <td>
                        <a href="DeleteFoodServlet?id=<%= f.getId()%>">Delete</a>
                    </td>
                    <td>
                        <a href="doEditFood?id=<%= f.getId()%>">Edit</a>
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
                    <th>Cookingtime</th>
                    <th>Delete</th>
                    <th>Edit</th>
                </tr>
            </thead>
            <tbody>
                <% for (FoodDTO f : food) {
                %>                      
                <tr>
                    <td><%= f.getId()%></td>
                    <td><%= f.getName()%></td>
                    <td><%= f.getDescription()%></td>
                    <td><%= f.getPrice()%></td>
                    <td><%= f.getCookingtime()%></td>
                    <td>
                        <a href="DeleteFoodServlet?id=<%= f.getId()%>">Delete</a>
                    </td>
                    <td>
                        <a href="doEditFood?id=<%= f.getId()%>">Edit</a>
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