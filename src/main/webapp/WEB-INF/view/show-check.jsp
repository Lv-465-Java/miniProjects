<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>Check List:</h3>


<c:forEach var="check" items="${requestScope.checks}">
    <c:forEach var="car" items="${requestScope.cars}">
        <c:forEach var="client" items="${requestScope.clients}">
        <c:choose>
            <c:when test="${car.id == check.idCar && client.id == check.idClient}">

    <ul>
                    <li>Date : <c:out value="${check.date}"/></li>
                    <li>Brand : <c:out value="${car.brand}"/></li>
                    <li>Model : <c:out value="${car.model}"/></li>
                    <li>Number : <c:out value="${car.number}"/></li>
                    <li>Year : <c:out value="${car.year}"/></li>
                    <li>Brand : <c:out value="${car.vinCode}"/></li>
                    <li>Name : <c:out value="${client.name}"/></li>
                    <hr/>
            </ul>
            </c:when>
        </c:choose>
        </c:forEach>
    </c:forEach>
        </c:forEach>
<h4><a href="/add-check">add</a> </h4>

</form>
</body>
</html>
