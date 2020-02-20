<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: maric
  Date: 1/14/2020
  Time: 12:56 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
</head>
<body>
<nav class="navbar navbar-expand-md navbar-dark bg-dark">
    <button type="button" class="navbar-toggler" data-toggle="collapse" data-target="#navbarCollapse">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse justify-content-between" id="navbarCollapse">
        <div class="navbar-nav habit-navbar">
            <a href="<c:url value="/home"/>" class="nav-item nav-link active">Habit tracker</a>
            <div class="header-actions">
                <a href="<c:url value="/create_habit"/>" class="nav-item nav-link">Add habit</a>
                <a href="<c:url value="/edit_user"/>" class="nav-item nav-link">Edit user</a>
                <a href="<c:url value="/delete_user"/>" class="nav-item nav-link">Delete user</a>
            </div>
            <a href="<c:url value="/login"/>" class="nav-item nav-link">Sign out</a>
        </div>
    </div>
</nav>
</body>
</html>
