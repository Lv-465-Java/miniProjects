<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: maric
  Date: 1/11/2020
  Time: 10:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/style.css"/>">
</head>
<body>
<div class="wrapper fadeInDown">
    <div id="formContent">
        <form action="edit_habit_description/${habit_id}" method="POST">
            <h1><c:out value="${habit.name}"/></h1>
            <c:if test="${error ne null}">
                <p class="text-center">
                    <font color="red">${error}</font>
                </p>
            </c:if>
            <h3>
                <font color="red">
                    <c:forEach var="configParams" items="${errors}">
                    <c:if test="${configParams.key=='login'}">
                    <c:out value="${configParams.value}" /></>
                </c:if>
                </c:forEach>
                </font>
            </h3>

            <br>
            <input type="text" id="description" class="fadeIn second" name="description" placeholder="description"
                   value="${habit.description}">
            <input type="submit" class="fadeIn fourth" value="Confirm">

        </form>


    </div>
</div>
</body>
</html>
