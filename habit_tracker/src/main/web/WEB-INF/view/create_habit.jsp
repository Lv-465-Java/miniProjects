<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: maric
  Date: 1/5/2020
  Time: 6:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create new habit</title>
    <link rel="stylesheet" type="text/css" href="./css/style.css">
</head>
<body>
<div class="wrapper fadeInDown">
    <div id="formContent">
        <form action="create_habit" method="POST">
            <h1>Create new habit</h1>
            <br>
            <c:if test="${error ne null}">
                <p class="text-center">
                    <font color="red">${error}</font>
                </p>
            </c:if>
            <div>
                <font color="red">
                    <c:forEach var="configParams" items="${errors}">
                        <c:if test="${configParams.key=='name'}">
                            <c:out value="${configParams.value}" />
                        </c:if>
                        <c:if test="${configParams.key=='exist'}">
                            <c:out value="${configParams.value}" />
                        </c:if>
                    </c:forEach>
                </font>
            </div>
            <input type="text" id="name" class="fadeIn second" name="name" placeholder="name" required>
            <input type="text" id="description" class="fadeIn third" name="description"  placeholder="description">
            <input type="submit" class="fadeIn fourth" value="Create">
        </form>

    </div>
</div>
</body>
</html>
