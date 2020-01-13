<%--
  Created by IntelliJ IDEA.
  User: arch
  Date: 13.01.20
  Time: 00:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
    <title></title>
</head>
<body>
<jsp:include page="fragments/header.jsp"/>
<br><br><br>
<div class="row justify-content-center">
    <div class="col-12 col-md-10 col-lg-8">
        <form action="${pageContext.request.contextPath}/change-status" method="post">
            <h1 align="center">Are you sure?</h1>
            <p align="center">Do you really want to delete these records? This process cannot be undone.</p>
            <div class="row justify-content-center">
                <button type="submit" name="DELETE" value="${pageContext.request.getParameter("DELETE")}"
                        class="btn btn-danger btn-lg">Delete
                </button>
                <button type="button" class="btn btn-light btn-lg" disabled></button>
                <a href="home" class="btn btn-secondary btn-lg active" role="button" aria-pressed="true">Cancel</a>
            </div>
        </form>
    </div>
</div>
</body>
</html>
