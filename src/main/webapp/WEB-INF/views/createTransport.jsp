<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: int
  Date: 12.01.20
  Time: 15:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create Transport</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/login.css"/>
</head>
<body>
<div class="login-wrap">
    <div class="login-html">
        <input id="tab-2" type="radio" name="tab" class="sign-up"><label for="tab-2" class="tab">Create transport</label>
        <div class="login-form">
            <div class="sign-up-htm">
                <form action="${pageContext.request.contextPath}/createTransport" method="post">
                    <div class="group">
                        <label for="name" class="label">Name</label>
                        <input id="name" name="name" type="text" class="input" required>
                    </div>
                    <div class="group">
                        <input type="submit" class="button" value="Create">
                    </div>
                    <div class="group">
                        <a href="<c:out value="/adminPage"/>">
                            <input type="submit" class="button" value="Cancel">
                        </a>
                    </div>
                    <div class="hr"></div>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>
