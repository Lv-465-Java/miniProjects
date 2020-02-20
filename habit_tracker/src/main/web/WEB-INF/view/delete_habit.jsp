<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: maric
  Date: 1/6/2020
  Time: 2:39 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/style.css"/>" >
</head>
<body>
<div class="wrapper fadeInDown">
    <div id="formContent" class="withTwoSubmit">
        <h1>Are you sure you want to delete habit?</h1>
        <br>
        <c:if test="${error ne null}">
            <p class="text-center">
                <font color="red">${error}</font>
            </p>
        </c:if>
        <div class="button">
            <div class="sudmit" id="no">
        <form action="http://localhost:8080/habit_tracker/habit/${id}" method="get">
            <input type="submit" class="fadeIn fourth" value="No">
        </form></div>
            <div class="sudmit" id="yes">
        <form action="delete_habit" method="POST">
            <input type="submit" class="fadeIn fourth" value="Yes">
        </form></div>
        </div>

    </div>
</div>
</body>
</html>
