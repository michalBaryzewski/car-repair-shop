<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: michalbaryzewski
  Date: 07.06.2020
  Time: 11:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Car</title>
</head>
<body>
<form:form method="post" modelAttribute="car">
    <tr>
        <td><b>Type:</b></td><td><form:input path="type" value="${car.type}"/></td>
    </tr>
    <tr>
        <td><b>Brand:</b></td><td><form:select path="brand" items="${carTypes}"/></td>
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
        <td><b>Country:</b></td><td><form:select path="countryOfOrigin" items="${countries}"/></td>
    </tr>
    <tr>
        <td><b>Engine:</b></td><td><form:input path="engine" value="${car.engine}"/></td>
    </tr>
    <tr>
        <td><b>Power (HP):</b></td><td><form:input path="power" value="${car.power}"/></td>
    </tr>
    <tr>
        <td><b>Type of fuel:</b></td><td><form:input path="fuelType" value="${car.fuelType}"/></td>
    </tr>
    <tr>
        <td><b>Type of gearbox:</b></td><td><form:select path="gearboxType" items="${gearboxTypes}"/></td>
    </tr>
    <tr>
        <td><b>Mileage:</b></td><td><form:input path="mileage" value="${car.mileage}"/></td>
    </tr>
    <tr>
        <td><b>Owner:</b></td><td><form:select path="owner" itemLabel="username" itemValue="id" items="${users}"/></td>
    </tr>
    <tr>
        <input type="submit">
    </tr>
</form:form>

</body>
</html>
