<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: int
  Date: 10.01.20
  Time: 22:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create Place</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}././css/login.css"/>
</head>
<body>
<div class="login-wrap">
    <div class="login-html">
        <input id="tab-2" type="radio" name="tab" class="sign-up"><label for="tab-2" class="tab">Create place</label>
        <div class="login-form">
            <div class="sign-up-htm">
                <form action="<c:out value="/createPlace"/>" method="post">
                    <div class="group">
                        <label for="country" class="label">Country</label>
                        <input id="country" type="text" class="input" required>
                    </div>
                    <div class="group">
                        <label for="town" class="label">Town</label>
                        <input id="town" type="text" class="input" required>
                    </div>
                    <div class="group">
                        <label for="name" class="label">Name</label>
                        <input id="name" type="text" class="input" required>
                    </div>
                    <div class="group">
                        <label for="email" class="label">Description</label>
                        <textarea name="descr"  cols="60" rows="4" required></textarea>
<%--                        <input id="email" type="text" class="input" required>--%>
                    </div>
                    <div class="group">
                        <label for="descr" class="label">Photo</label>
                        <input id="descr" type="text" class="input" required>
                    </div>

                    <div class="group">
                        <input type="submit" class="button" value="Create">
                    </div>
                    <div class="group">
                        <%--                    <form action="<c:out value="/login"/>" method="get">--%>
                        <a href="<c:out value="/adminPage"/>">
                            <input type="submit" class="button" value="Cancel">
                            <%--                    </form>--%>
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
