<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: int
  Date: 13.01.20
  Time: 13:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add place to trip</title>
    <link rel="stylesheet" type="text/css" href="css/login.css"/>
</head>
<body>
<div class="login-wrap">
    <div class="login-html">
        <div class="login-form">
            <div class="sign-up-htm">

                <div class="group">
                    <form action="${pageContext.request.contextPath}/addPlaceToTrip" method="post">
                        <label for="placeDto" class="label">Place
                            <select id="placeDto" name="placesId" multiple="multiple">
                                <c:forEach items="${placeDtoList}" var="placeDto">
                                <option value="${placeDto.id}">
                                            ${placeDto.country}, ${placeDto.town},${placeDto.name}
                                </option>
                                </c:forEach>
                            </select>

                        </label>
                    </form>
                </div>

                <div class="group">
                    <form action="${pageContext.request.contextPath}/createTrip">
                    <input type="submit" class="button" value="Add">
                    </form>
                </div>
                <div class="group">
                    <input type="submit" class="button" value="Calculate the cost of the trip">
                </div>
                <div class="group">
                    <form action="${pageContext.request.contextPath}/mainPage">
                        <input type="submit" class="button" value="Cancel">
                    </form>
                </div>
                <div class="hr"></div>
            </div>
        </div>
    </div>
</div>

</body>
</html>
