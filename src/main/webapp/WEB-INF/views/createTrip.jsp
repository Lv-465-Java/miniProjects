<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: int
  Date: 07.01.20
  Time: 18:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create Trip</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/login.css"/>
</head>
<body>
<div class="login-wrap">
    <div class="login-html">
        <div class="login-form">
            <div class="sign-up-htm">
                <div class="group">
                    <form action="${pageContext.request.contextPath}/createTrip" method="post">
                    <label for="dep_day" class="label">Departure day</label>
                    <input id="dep_day" name="dep_day" type="date" class="input" required>

                <div class="group">
                    <label for="arr_day" class="label">Day of arrival</label>
                    <input id="arr_day" name="arr_day" type="date" class="input" required>
                </div>
                <div class="group">
                    <label for="count" class="label">Count of people</label>
                    <input id="count" name="count" type="text" class="input" required>
                </div>
                <div class="group">
                        <label for="access" class="label">Access
                            <select id="access" name="access">
                                <option value="true">True</option>
                                <option value="false">False</option>
                            </select>
                        </label>
                </div>
                <div class="group">
                        <label for="transport" class="label">Transport
                            <select id="transport" name="transport">
                                <c:forEach items="${transportList}" var="transport">
                                <option value="${transport.id}">${transport.transportName}</option>
                                </c:forEach>
                            </select>
                        </label>
                </div>

                <div class="group">
                        <input type="submit" class="button" value="Create">
                </div>
                <div class="group">
                    <form action="${pageContext.request.contextPath}/mainPage">
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
</div>

</body>
</html>



