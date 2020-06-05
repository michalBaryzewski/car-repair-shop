<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: michalbaryzewski
  Date: 01.06.2020
  Time: 21:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create Task</title>
</head>
<body>
<table border="1">
    <tbody>
    <form:form method="post" modelAttribute="task">
        <tr>
            <td><b>Description:</b></td><td><form:input path="description" value="${task.description}"/></td>
        </tr>
        <tr>
            <td><b>Client:</b></td><td><form:select path="clients" itemLabel="username" itemValue="id" items="${clients}"/></td>
        </tr>
        <tr>
            <td><b>Employee:</b></td><td><form:select path="employees" itemLabel="username" itemValue="id" items="${employees}"/></td>
        </tr>
        <tr>
            <td><b>Car:</b></td><td><form:select path="car" itemLabel="licensePlate" itemValue="id" items="${cars}"/></td>
        </tr>
        <tr>
            <td><b>Status:</b></td><td><form:select path="statuses" itemLabel="status" itemValue="id" items="${statuses}"/></td>
        </tr>
        <tr>
            <input type="submit">
        </tr>
    </form:form>
    <tr>
    </tr>
    </tbody>
</table>
</body>
</html>
