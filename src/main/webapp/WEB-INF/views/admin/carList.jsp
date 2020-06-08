<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: michalbaryzewski
  Date: 07.06.2020
  Time: 09:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Car List</title>
</head>
<body>
<table border="1">
    <tbody>
    <tr>
        <td><b>Type</b></td>
        <td><b>Brand</b></td>
        <td><b>Model</b></td>
        <td><b>License Plate</b></td>
        <td><b>Year of production</b></td>
        <td><b>Country of origin</b></td>
        <td><b>Engine</b></td>
        <td><b>Power</b></td>
        <td><b>Fuel type</b></td>
        <td><b>Gearbox type</b></td>
        <td><b>Mileage</b></td>
        <td><b>Owner's username</b></td>
    </tr>
    <c:forEach items="${cars}" var="car">
        <tr>
            <td>
                <c:out value="${car.type}"/>
            </td>
            <td>
                <c:out value="${car.brand}"/>
            </td>
            <td>
                <c:out value="${car.model}"/>
            </td>
            <td>
                <c:out value="${car.licensePlate}"/>
            </td>
            <td>
                <c:out value="${car.yearOfProduction}"/>
            </td>
            <td>
                <c:out value="${car.countryOfOrigin}"/>
            </td>
            <td>
                <c:out value="${car.engine}"/>
            </td>
            <td>
                <c:out value="${car.power}"/>
            </td>
            <td>
                <c:out value="${car.fuelType}"/>
            </td>
            <td>
                <c:out value="${car.gearboxType}"/>
            </td>
            <td>
                <c:out value="${car.mileage}"/>
            </td>
            <td>
                <c:out value="${car.owner.username}"/>
            </td>
            <td><a href="/admin/delete-car/${car.id}">Delete</a></td>
            <td><a href="/admin/update-car/${car.id}">Edit</a> </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
