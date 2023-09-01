<%-- 
    Document   : index
    Created on : Apr 11, 2023, 11:18:14 AM
    Author     : user
--%>

<%@page import="model.dto.Item"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.dto.Category"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            ArrayList<Category> kq=(ArrayList)session.getAttribute("result");
            if(kq!=null){
            for(Category c:kq){
        %>
                <a href="LoadItems?cateid=<%= c.getId() %>"> <%= c.getName()  %> </a>
        
        <%
              }
            }
            
        %>
        <!--hien thi items-->
        <br>
        <%
            String msg=(String)request.getAttribute("ERROR");
            if (msg!=null){
                out.println(msg);
            }
            
        %>
        <%
            ArrayList<Item> list=(ArrayList<Item>)session.getAttribute("listItem");
            System.out.println(session.getAttribute("listItem"));
            if(list!=null){
             for(Item it:list){
        %>
        <form action="SendFAQ">
             <div>
                 <p>item id: <%=  it.getId()  %></p>
                 <p>item name: <%=  it.getName() %></p>
                 <p>item price: <%=  it.getPrice()  %></p>
                 <p>item's cate name: <%=  it.getCate().getName() %></p>
                 <p><input type="text" name="name"></p>
                 <p><textarea name="content">
                     enter your question
                     </textarea> </p>
                     <p><input type="submit" value="send"></p>
             </div>  
        </form>
        <%
            }
            }
        %>
    </body>
</html>
