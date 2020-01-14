<%--
  Created by IntelliJ IDEA.
  User: int
  Date: 13.01.20
  Time: 21:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%--<head>--%>
<%--    <title>Title</title>--%>
<%--</head>--%>

<nav class="navbar navbar-default">

    <ul class="nav navbar-nav">
        <div class="row">
            <div class="col-md-4">
                <li class="nav-item">
                    <a class="nav-link" href="#">${userDto.username}</a>
                </li>
            </div>
            <div class="col-md-4">
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/personalCabinet">Personal cabinet</a>
                </li>
            </div>
            <div class="col-md-4">
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/login">Log out</a>
                </li>
            </div>
        </div>
    </ul>
</nav>

