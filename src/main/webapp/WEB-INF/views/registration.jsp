<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: int
  Date: 05.01.20
  Time: 23:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration page</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/login.css"/>
    <script src="<c:url value="/javascript/checkPassword.js"/>"></script>
</head>
<body>
<c:if test="${error ne null}">
    <p class="text-center">
        <font color="red">${error}</font>
    </p>
</c:if>
<div class="login-wrap">
    <div class="login-html">
        <input id="tab-2" type="radio" name="tab" class="sign-up"><label for="tab-2" class="tab">Sign Up</label>
        <div class="login-form">
            <div class="sign-up-htm">
                <form action="${pageContext.request.contextPath}/registration" method="post">
                <div class="group">
                    <label for="first_name" class="label">First Name</label>
                    <input id="first_name" name="first_name" type="text" class="input" required>
                </div>
                <div class="group">
                    <label for="last_name" class="label">Last Name</label>
                    <input id="last_name" name="last_name" type="text" class="input" required>
                </div>
                <div class="group">
                    <label for="username" class="label">Username</label>
                    <input id="username" name="username" type="text" class="input" required>
                </div>
                <div class="group">
                    <label for="email" class="label">Email</label>
                    <input id="email" name="email" type="text" class="input" required>
                </div>
                <div class="group">
                    <label for="password" class="label">Password</label>
                    <input id="password" name="password" type="password" class="input" data-type="password" onclick="check()" required/
                </div>
                <div class="group">
                    <label for="passw" class="label">Repeat Password</label>
                    <input id="passw" name="repPass" type="password" class="input" data-type="password" onclick="check()" required/>
                    <span id="message"></span>
                </div>
                <div class="group">
                    <input type="submit" class="button" value="Sign Up">
                </div>
                <div class="group">
                    <a href="${pageContext.request.contextPath}/login">
                    <input type="submit" class="button" value="Cancel">
                    </a>
                </div>
                <div class="hr"></div>
                </form>
                <c:if test="${not empty error}">
                    <c:out value="${error}"/>
                </c:if>
            </div>
        </div>
    </div>
</div>
</body>
</html>
