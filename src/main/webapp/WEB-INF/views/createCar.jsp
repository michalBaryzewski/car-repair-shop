<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: michalbaryzewski
  Date: 01.06.2020
  Time: 20:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create Car</title>
</head>
<body>
<table border="1">
    <tbody>
    <form:form method="post" modelAttribute="car">
        <tr>
            <td><b>Type:</b></td><td><form:input path="type" value="${car.type}"/></td>
        </tr>
        <tr>
            <td><b>Brand:</b></td><td><form:input path="brand" value="${car.brand}"/></td>
        </tr>
        <tr>
            <td><b>Model:</b></td><td><form:input path="model" value="${car.model}"/></td>
        </tr>
        <tr>
            <td><b>License Plate:</b></td><td><form:input path="licensePlate" value="${car.licensePlate}"/></td>
        </tr>
        <tr>
            <td><b>Year of production:</b></td><td><form:input path="yearOfProduction" value="${car.yearOfProduction}"/></td>
        </tr>
        <tr>
            <td><b>Country:</b></td><td><form:input path="countryOfOrigin" value="${car.countryOfOrigin}"/></td>
        </tr>
        <tr>
            <td><b>Engine:</b></td><td><form:input path="engine" value="${car.engine}"/></td>
        </tr>
        <tr>
            <td><b>Power:</b></td><td><form:input path="power" value="${car.power}"/></td>
        </tr>
        <tr>
            <td><b>Type of fuel:</b></td><td><form:input path="fuelType" value="${car.fuelType}"/></td>
        </tr>
        <tr>
            <td><b>Type of gearbox:</b></td><td><form:input path="gearboxType" value="${car.gearboxType}"/></td>
        </tr>
        <tr>
            <td><b>Mileage:</b></td><td><form:input path="mileage" value="${car.mileage}"/></td>
        </tr>
        <tr>
            <td><b>Owner:</b></td><td><form:select path="owner" itemLabel="username" itemValue="id" items="${users}"/></td>
        </tr>
    </form:form>
    <tr>
        <input type="submit">
    </tr>
    </tbody>
</table>
</body>
</html>
