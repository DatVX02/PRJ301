<%-- 
    Document   : FAQs
    Created on : Apr 11, 2023, 5:10:08 PM
    Author     : ACER
--%>

<%@page import="DTO.FAQsDTO"%>
<%@page import="DTO.CategoriesDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="dispatch">
    Choose the item to get FAQs :  
       <% ArrayList<CategoriesDTO> cate = (ArrayList<CategoriesDTO>) session.getAttribute("Cate");
            if (cate!=null) {%>
               <select name="textCategolory">                  
               
                    <%
                    for (CategoriesDTO i : cate) {
                        if (i.getStatus()==0) {
                            continue;
                        }
            %>
            <option value="<%= i.getCateID() %>"><%= i.getCateName() %></option>  
            
           
             <%
                }
                %>
             </select>
                <%
                            }
            %>
            <input type="submit" value="Find" name="btAction" />
    </form>
            <% ArrayList<FAQsDTO> FAQ = (ArrayList<FAQsDTO>) session.getAttribute("FAQ");
            if(FAQ != null){
                for (FAQsDTO i : FAQ) {
                        %>
     Name:   <%= i.getCustName() %> | items's name : <%= i.getItemsName() %> | Comment : <%= i.getCustContent()  %>  
        <br>
        <%
                    }
            }
            %>
    </body>
</html>
