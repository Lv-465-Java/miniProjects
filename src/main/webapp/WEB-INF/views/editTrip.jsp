<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: int
  Date: 13.01.20
  Time: 01:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Trip</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/login.css"/>
</head>
<body>
<div class="login-wrap">
    <div class="login-html">
        <div class="login-form">
            <div class="sign-up-htm">

                    <form action="${pageContext.request.contextPath}/editTrip" method="post">
                        <input type="hidden" name="tripId" value="${tripDto.id}">
                        <div class="group">
                        <label for="dep_day" class="label">Departure day</label>
                        <input id="dep_day" name="dep_day" value="${tripDto.departureDay}" type="date" class="input">
                        </div>
                        <div class="group">
                            <label for="arr_day" class="label">Day of arrival</label>
                            <input id="arr_day" name="arr_day" value="${tripDto.dayOfArrival}" type="date" class="input">
                        </div>
                        <div class="group">
                            <label for="count" class="label">Count of people</label>
                            <input id="count" name="count" value="${tripDto.countOfPeople}" type="text" class="input" required>
                        </div>
                        <div class="group">
                            <label for="access" class="label">Access
                                <select id="access" name="access">
                                    <option value="true" selected>True</option>
                                    <option value="false">False</option>
                                </select>
                            </label>
                        </div>
                        <div class="group">
                            <label for="transport" class="label">Transport
                                <select id="transport" name="transport">
                                    <c:forEach items="${transList}" var="transport">
                                        <option value="${transport.id}">${transport.transportName}</option>
                                    </c:forEach>
                                </select>
                            </label>
                        </div>
                        <div class="group">
                            <input type="submit" class="button" value="Edit">
                        </div>
                        <div class="group">
                            <form action="${pageContext.request.contextPath}/personalCabinet    ">
                                <input type="submit" class="button" value="Cancel">
                            </form>
                        </div>
                        <div class="hr"></div>
                        <c:if test="${not empty error}">
                            <%--                        <c:out value="${error}"/>--%>
                            <div class="alert alert-info"> ${error}</div>
                        </c:if>
                    </form>
                </div>
            </div>
        </div>
    </div>

</body>
</html>
