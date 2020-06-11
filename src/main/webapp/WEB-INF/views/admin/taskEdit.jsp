<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: michalbaryzewski
  Date: 08.06.2020
  Time: 21:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Task Edit</title>
</head>
<body>
<form:form method="post" modelAttribute="task">
    <tr>
        <td><b>Description:</b></td><td><form:input path="description" value="${task.description}"/></td>
    </tr>
    <tr>
        <td><b>Client:</b></td><td><form:select path="clients" items="${clients}" itemLabel="username"/></td>
    </tr>
    <tr>
        <td><b>Employee:</b></td><td><form:select path="employees" items="${employees}" itemLabel="username"/></td>
    </tr>
    <tr>
        <td><b>Car:</b></td><td><form:select path="car" items="${cars}" itemLabel="licensePlate"/></td>
    </tr>
    <tr>
        <td><b>Status:</b></td><td><form:select path="statuses" items="${statuses}" itemLabel="status"/></td>
    </tr>
    <tr>
        <input type="submit">
    </tr>
</form:form>
</body>
</html>
