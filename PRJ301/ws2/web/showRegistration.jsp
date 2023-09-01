<%-- 
    Document   : showRegistration.jsp
    Created on : Apr 19, 2023, 3:31:37 PM
    Author     : lnhtr
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registration</title>
    </head>
    <body>
        <h1>Registration</h1>
        <c:set var="result" value="${sessionScope.INFO_REGISTRATION}"/>
        <c:if test="${not empty result}">
            <table border="1">
                <thead>
                    <tr>
                        <th>No.</th>
                        <th>ID</th>
                        <th>Name</th>
                        <th>Role</th>
                        <th>Class Name</th>
                        <th>Delete</th>

                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="dto" items="${result}" varStatus="counter">
                    <form action="deleteARegistration" method="POST">
                        <tr>
                            <td>
                                ${counter.count}
                            </td>
                            <td>
                                ${dto.id}
                                <input type="hidden" name="pk" value="${dto.id}" />
                            </td>
                            <td>
                                ${dto.name}
                            </td>
                            <td>
                                ${dto.role}
                            </td>
                            <td>
                                ${dto.className}
                            </td>
                            <td>
                                <input type="submit" value="Delete" />
                            </td>
                        </tr>
                    </form>

                </c:forEach>                   
            </tbody>
        </table>

    </c:if>
    <br/>
    <form action="showClassAction" method="POST">
        <input type="submit" value="Create New Registration" />
    </form>
    <form action="createClass" method="POST">
        <input type="submit" value="Create New Class" />
    </form>


</body>
</html>
