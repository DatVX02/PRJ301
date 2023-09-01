<%-- 
    Document   : Edit
    Created on : Apr 11, 2023, 7:50:10 PM
    Author     : ACER
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="DTO.CategoriesDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="dispatch">
        
        ID: <input type="text" name="textID" value="<%= request.getParameter("txtID") %>" readonly =""/>
        <br>
        Name: <input type="text" name="textName" value="" />
        <br>
        Price: <input type="text" name="textPrice" value="" /> 
        <br>
        Category: 
            <% ArrayList<CategoriesDTO> cate = (ArrayList<CategoriesDTO>) session.getAttribute("Cate");
            if (cate!=null) {%>
                <select name="textCate">
                    <%
                    for (CategoriesDTO i : cate) {
            %>
            <option value="<%= i.getCateID() %>"><%= i.getCateName() %></option>  
            
            <%                
                        }
            %>
             </select>
             <%
                }
            %>
       
        <input type="submit" value="Save" name="btAction" />
        </form>
    </body>
</html>
