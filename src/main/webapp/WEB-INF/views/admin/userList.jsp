<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: michalbaryzewski
  Date: 08.06.2020
  Time: 21:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User List</title>
</head>
<body>
<table border="1">
<tbody>
<tr>
    <td><b>First Name</b></td>
    <td><b>Last Name</b></td>
    <td><b>Username</b></td>
    <td><b>Enabled</b></td>
</tr>
<c:forEach items="${users}" var="user">
    <tr>
        <td>
            <c:out value="${user.firstName}"/>
        </td>
        <td>
            <c:out value="${user.lastName}"/>
        </td>
        <td>
            <c:out value="${user.username}"/>
        </td>
        <td>
            <c:out value="${user.enabled}"/>
        </td>
        <td><a href="/admin/delete-user/${user.id}">Delete</a></td>
        <td><a href="/admin/update-user/${user.id}">Edit</a> </td>
    </tr>
</c:forEach>
</tbody>
</table>
</body>
</html>
