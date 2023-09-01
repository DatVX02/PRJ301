
<%@page import="java.util.ArrayList"%>
<%@page import="web.models.tblUser.UserDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manager Account</title>
    </head>
    <body>
        <% ArrayList<UserDTO> user = (ArrayList<UserDTO>) session.getAttribute("Account");
        if ( user != null ) {
        %>  
        <table border="1">
            <thead>
                <tr>
                    <th>Full Name</th>
                    <th>Password</th>
                    <th>RoleID</th>
                    <th>Address</th>
                    <th>birthday</th>
                    <th>Phone</th>
                    <th>Email</th>
                </tr>
            </thead>
        <% 
            for (UserDTO elem : user) {   
            %>
                <tbody>
                <tr>
                    <td><%= elem.getFullName()%></td>
                    <td><%= elem.getPassword()%></td>
                    <td><%= elem.getRoleID()%></td>
                    <td><%= elem.getAddress()%></td>
                    <td><%= elem.getBirthday()%></td>
                    <td><%= elem.getPhone()%></td>
                    <td><%= elem.getEmail()%></td>
                </tr>

        <%
            }
        }
        %>
        
            </tbody>
        </table>
        
    </body>
</html>
