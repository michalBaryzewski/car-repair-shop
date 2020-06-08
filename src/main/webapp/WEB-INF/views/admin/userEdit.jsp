<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: michalbaryzewski
  Date: 07.06.2020
  Time: 11:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit User</title>
</head>
<body>
<form:form method="post" modelAttribute="user">
    <tr>
        <td><b>First Name:</b></td><td><form:input path="firstName" value="${user.firstName}"/></td>
    </tr>
    <tr>
        <td><b>Last Name:</b></td><td><form:input path="lastName" value="${user.lastName}"/></td>
    </tr>
    <tr>
        <td><b>Username:</b></td><td><form:input path="username" value="${user.username}"/></td>
    </tr>
    <tr>
        <td><b>Password:</b></td><td><form:password path="password"/></td>
    </tr>
    <tr>
        <td><b>Enabled:</b></td><td><form:input path="enabled" value="${user.enabled}"/></td>
    </tr>
    <tr>
        <input type="submit">
    </tr>
</form:form>

</body>
</html>
