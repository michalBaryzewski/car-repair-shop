<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: michalbaryzewski
  Date: 08.06.2020
  Time: 21:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Task List</title>
</head>
<body>
<table border="1">
    <tbody>
    <tr>
        <td><b>Description</b></td>
        <td><b>Car</b></td>
        <td><b>Created</b></td>
        <td><b>Updated</b></td>
    </tr>
    <c:forEach items="${tasks}" var="task">
        <tr>
            <td>
                <c:out value="${task.description}"/>
            </td>
            <td>
                <c:out value="${task.car.licensePlate}"/>
            </td>
            <td>
                <c:out value="${task.created}"/>
            </td>
            <td>
                <c:out value="${task.updated}"/>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
