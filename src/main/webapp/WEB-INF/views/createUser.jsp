<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: michalbaryzewski
  Date: 01.06.2020
  Time: 17:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create User</title>
</head>
<body>
<table border="1">
    <tbody>
    <form:form method="post" modelAttribute="user">
        <tr>
            <td><b>First Name:</b></td><td><form:input path="firstName" value="${user.firstName}"/></td>
        </tr>
        <tr>
            <td><b>Last Name:</b></td><td><form:input path="lastName" value="${user.lastName}"/></td>
        </tr>
        <tr>
            <td><b>Username: </b></td><td><form:input path="username" value="${user.username}"/></td>
        </tr>
        <tr>
            <td><b>Password:</b></td><td><form:password path="password" value="${user.password}"/></td>
        </tr>
        <tr>
            <td><b>Role:</b></td><td><form:select path="roles" itemLabel="name" itemValue="id" items="${roles}"/></td>
        </tr>
    </form:form>
    <tr>
        <input type="submit">
    </tr>
    </tbody>
</table>
</body>
</html>
