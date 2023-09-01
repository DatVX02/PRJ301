<%-- 
    Document   : itemM
    Created on : Apr 11, 2023, 5:05:21 PM
    Author     : ACER
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="DTO.ItemDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
       <%
           ArrayList<ItemDTO> item = (ArrayList<ItemDTO>) session.getAttribute("Item");
           if(item != null){
               %>
               <table border="1">
                   <thead>
                       <tr>
                           <th>ID</th>
                           <th>Name</th>                           
                           <th>Action</th>
                       </tr>
                   </thead>
                   <tbody>
                       <%
                        for(ItemDTO i : item){
                            if(i.getStatus()==1 ){
                            %>
                       <tr>
                           <td><%= i.getItemID() %></td>
                           <td><%= i.getItemName() %></td>
                           <td> <a href="dispatch?btAction=Edit&txtID=<%=i.getItemID()%>">Edit</a>  
                           </td>                
                       </tr>
                       <%
                           }
                       }   
}
                        %>
                   </tbody>
               </table>

             
    </body>
</html>
