<%-- 
    Document   : airplane
    Created on : Apr 25, 2023, 1:30:19 PM
    Author     : lnhtr
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

        <title>Air Plane</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <h2>Find your's plane</h2>

        <form action="searchAirplaneAction" method="POST">
            Fight Number <input type="text" name="txtFightNumber" 
                                value="${param.txtFightNumber}" />
            <input type="submit" value="Find" />
        </form>
        <c:set var="searchValue" value="${param.txtFightNumber}"/>
        <c:if test="${not empty searchValue}">
            <c:set var="result" value="${requestScope.SEARCH_FLIGHT}"/>
            <c:if test="${not empty result}">
                <table border="1">
                    <thead>
                        <tr>
                            <th>No.</th>
                            <th>ID</th>
                            <th>Fight Number</th>
                            <th>Destination</th>                           
                            <th>Departure Attributes Time</th>
                            <th>Status</th>

                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="dto" items="${result}" varStatus="counter">
                            <tr>
                                <td>
                                    ${counter.count}
                                </td>
                                <td>
                                    ${dto.id}
                                </td>
                                <td>
                                    ${dto.fightNumber}
                                </td>
                                <td>
                                    ${dto.destination}
                                </td>
                                <td>
                                    ${dto.departureAttributesTime}
                                </td>
                                <td>
                                    ${dto.status}
                                </td>
                            </tr>
                        </c:forEach>

                    </tbody>
                </table>


            </c:if>

        </c:if>


    </body>
</html>
