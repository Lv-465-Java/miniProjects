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
<h1>Create trip</h1>
<div class="login-wrap">
    <div class="login-html">
        <div class="login-form">
            <div class="sign-up-htm">
                <div class="group">
                    <label for="dep_day" class="label">Departure day</label>
                    <input id="dep_day" type="date" class="input" required>
                </div>
                <div class="group">
                    <label for="arr_day" class="label">Day of arrival</label>
                    <input id="arr_day" type="date" class="input" required>
                </div>
                <div class="group">
                    <label for="count" class="label">Count of people</label>
                    <input id="count" type="text" class="input" required>
<%--                    <form action="createTrip.jsp">--%>
<%--                        <select name="count">--%>
<%--                            <option value="one">1</option>--%>
<%--                            <option value="two">2</option>--%>
<%--                            <option value="three">3</option>--%>
<%--                            <option value="four">4</option>--%>
<%--                            <option value="five">5</option>--%>
<%--                            <option value="six">6</option>--%>
<%--                        </select>--%>
<%--                    </form>--%>
                </div>
                <div class="group">
                    <label for="access" class="label">Access</label>
                    <form action="${pageContext.request.contextPath}/createTrip">
                        <select name="access">
                            <option value="true">True</option>
                            <option value="false">False</option>
                        </select>
                    </form>
                </div>
                <div class="group">
                    <label for="transport" class="label">Transport</label>
                    <form action="${pageContext.request.contextPath}/createTrip">
                            <select name="transport">
                                <option value="bus">BUS</option>
                                <option value="train">TRAIN</option>
                                <option value="plain">PLAIN</option>
                                <option value="ship">SHIP</option>
                            </select>
                    </form>
                </div>

                <div class="group">
                    <input type="submit" class="button" value="Create">
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



