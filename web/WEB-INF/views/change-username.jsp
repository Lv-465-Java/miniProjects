<%--
  Created by IntelliJ IDEA.
  User: arch
  Date: 10.01.20
  Time: 23:19
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
    <title>Edit User</title>
</head>
<body>
<jsp:include page="fragments/header.jsp"/>
<br><br>
<c:if test="${error ne null}">
    <p class="text-center">
        <font color="red">${error}</font>
    </p>
</c:if>
<div class="row justify-content-center">
    <div class="col-12 col-md-10 col-lg-8">
        <form action="${pageContext.request.contextPath}/change-username" method="post">
            <div class="form-group row">
                <label for="staticName" class="col-sm-2 col-form-label">Old username</label>
                <div class="col-sm-10">
                    <input type="text" readonly class="form-control-plaintext" id="staticName"
                           value="${pageContext.session.getAttribute("userDto").name}">
                </div>
            </div>
            <div class="form-group row">
                <label for="inputUsername" class="col-sm-2 col-form-label">New username</label>
                <div class="col-sm-10">
                    <input class="form-control" type="text" id="inputUsername"
                           name="newUsername" placeholder="Username">
                </div>
            </div>
            <div class="row justify-content-center">
                <button type="submit" name="confirm" class="btn btn-success btn-lg">Confirm</button>
                <button type="button" class="btn btn-light btn-lg" disabled></button>
                <a href="home" class="btn btn-secondary btn-lg active" role="button" aria-pressed="true">Cancel</a>
            </div>
        </form>
    </div>
</div>
</body>
</html>
