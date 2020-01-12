<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2020-01-12
  Time: 19:54
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add country</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta http-equiv="x-ua-compatible" content="ie=edge">

    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.11.2/css/all.css">
    <!-- Bootstrap core CSS -->
    <link rel="stylesheet" href="static/css/bootstrap.min.css">
    <!-- Material Design Bootstrap -->
    <link rel="stylesheet" href="static/css/mdb.min.css">
    <!-- Your custom styles (optional) -->
    <link rel="stylesheet" href="static/css/admin-page.css">
</head>
<body>
<jsp:include page="/fragments/admin-page-header.jsp"/>

<div class="add-country">
    <div class="country-container">
        <form class="border border-light p-5" action="/employee" method="post" role="form" data-toggle="validator">
            <c:if test="${empty action}">
                <c:set var="action" value="add"/>
            </c:if>
            <input type="hidden" id="action" name="action" value="${action}">
            <input type="hidden" id="idEmployee" name="idEmployee" value="${employee.id}">
            <h2>Employee</h2>
            <div class="form-group col-xs-4">
                <input type="text" name="name" id="name" class="form-control mb-4" placeholder="Name" value="${employee.name}" required="true"/>
                <button type="submit" class="btn btn-primary  btn-md">Accept</button>
            </div>
        </form>
    </div>
</div>

    <jsp:include page="/fragments/footer.jsp"/>

</body>
<script src="static/js/bootstrap.min.js"></script>
</html>
