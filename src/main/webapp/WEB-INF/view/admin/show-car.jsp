<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<link href="${pageContext.request.contextPath}/resources/css/add-car.css" rel="stylesheet">
<div class="container">
    <div class="row">
        <div class="col-md-12">
            <h2><a href="admin/cars">Cars</a></h2>
            <div class="table-responsive">
                <form action="/admin/cars" method="post">
                    <input width="750px" type="text" name="field" placeholder="Search date">
                </form>
                    <form action="/admin/cars" method="post">
                    <div class="dropdown">
                        <button class="dropbtn">Choose brand</button>
                        <div class="dropdown-content">
                            <input class="in1" type="submit" name="brand" value="Audi">
                            <input class="in1" type="submit" name="brand" value="Mercedes">
                            <input class="in1" type="submit" name="brand" value="BMW">
                        </div>
                    </div>
                    </form>
                <table id="mytable" class="table table-bordred table-striped">
                    <thead>
                    <th>Date</th>
                    <th>Brand</th>
                    <th>Model</th>
                    <th>Number</th>
                    <th>Year</th>
                    <th>Vin-Code</th>
                    <th>Name</th>
                    <th>Tel</th>
                    <th>Edit</th>
                    <th>Delete</th>
                    </thead>
                    <tbody>
                    <tr>
                        <c:forEach var="check" items="${requestScope.checks}">
                        <c:forEach var="car" items="${requestScope.cars}">
                        <c:forEach var="client" items="${requestScope.clients}">
                        <c:choose>
                        <c:when test="${car.id == check.idCar && client.id == check.idClient}">


                        <td><c:out value="${check.date}"/></td>
                        <td><c:out value="${car.brand}"/></td>
                        <td><c:out value="${car.model}"/></td>
                        <td><c:out value="${car.number}"/></td>
                        <td><c:out value="${car.year}"/></td>
                        <td><c:out value="${car.vinCode}"/></td>
                        <td><c:out value="${client.name}"/></td>
                        <td><c:out value="${client.tel}"/></td>
                        <td>
                            <a href="${pageContext.request.contextPath}/edit-car?id=<c:out value='${check.id}' />">Edit</a>
                        </td>
                        <td>
                            <a href="${pageContext.request.contextPath}/admin/delete?id=<c:out value='${check.id}' />">Delete</a>
                        </td>
                    </tr>
                    </c:when>
                    </c:choose>
                    </c:forEach>
                    </c:forEach>
                    </c:forEach>
                    </tbody>
                </table>
                <h3><a href="/add-car">Add Car</a></h3>


                <div class="clearfix"></div>
                <form action="/admin/cars" method="post">
                <ul class="pagination pull-right">
<c:forEach begin="1" end="${size}" var="i">
    <c:choose>
        <c:when test="${i+1 eq i}">
            <td>${i}</td>
        </c:when>
        <c:otherwise>
                    <li><input  type="submit" name="page" value="${i}"></li>
        </c:otherwise>
    </c:choose>
</c:forEach>
                </ul>
                </form>
            </div>
            <form action="/admin/LogoutServlet" method="post">
                <input type="submit" value="Logout" >
            </form>
        </div>

        </div>
    </div>
</div>
</div>

