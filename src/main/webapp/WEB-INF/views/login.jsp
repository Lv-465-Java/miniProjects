<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: int
  Date: 02.01.20
  Time: 21:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login page</title>
<link rel="stylesheet" type="text/css" href="css/login.css" />
</head>
<body>
<div class="login-wrap">
    <div class="login-html">
        <input id="tab-1" type="radio" name="tab" class="sign-in" checked><label for="tab-1" class="tab">Sign In</label>
        <input id="tab-2" type="radio" name="tab" class="sign-up"><label for="tab-2" class="tab">
        <a href="${pageContext.request.contextPath}/registration">Sign Up</a></label>
        <div class="login-form">
            <div class="sign-in-htm">
                <form action="${pageContext.request.contextPath}/login" method="post">
                    <div>
                    </div>
                <div class="group">
                    <label for="user" class="label">Username</label>
                    <input id="user" name="username" type="text" class="input">
                </div>
                <div class="group">
                    <label for="pass" class="label">Password</label>
                    <input id="pass" name="password" type="password" class="input" data-type="password">
                </div>
                <div class="group">
                    <input type="submit" class="button" value="Sign In">
                </div>
                <div class="hr"></div>
                <div class="foot-lnk">
                    <a href="${pageContext.request.contextPath}/forgotPassword">Forgot Password?</a>
                </div>
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
