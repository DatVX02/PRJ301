<%-- 
    Document   : createNewStudent
    Created on : Apr 20, 2023, 8:11:20 AM
    Author     : lnhtr
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="createARegistration" method="POST">
            ID <input type="text" name="txtID" value="" /><br>
            Name <input type="text" name="txtName" value="" /><br>
            role <select name="txtRole">
                <option>Teacher</option>
                <option>Student</option>
            </select><br>
            Class <select name="txtClassName">
                <c:set var="result" value="${sessionScope.CLASS_NAME}"/>
                <c:if test="${not empty result}">
                    <c:forEach var="dto" items="${result}">
                        <option>
                            ${dto.className}
                        </option>
                    </c:forEach>
                </c:if>
                
            </select><br>
            <input type="submit" value="Create" />
        </form>
    </body>
</html>
