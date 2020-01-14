<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: int
  Date: 10.01.20
  Time: 22:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>Create Comment</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/login.css"/>
</head>
<body>
<div class="login-wrap">
    <div class="login-html">
    <input id="tab-2" type="radio" name="tab" class="sign-up"><label for="tab-2" class="tab">Create Comment</label>
    <div class="login-form">
        <div class="sign-up-htm">
            <form action="${pageContext.request.contextPath}/createComment" method="post">
                <div class="group">
                    <label for="places" class="label">Choose place</label>
                    <select id="places" name="placeId">
                        <c:forEach items="${placeDtoList}" var="place">
                            <option value="${place.id}">${place.country}, ${place.town}, ${place.name}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="group">
                    <label for="text" class="label">Text of comment</label>
                    <textarea id="text" name="comment" cols="60" rows="4">Enter your comment...</textarea>
                </div>


                <div class="group">
                    <a href="${pageContext.request.contextPath}/mainPage">
                    <input type="submit" class="button" value="Create">
                    </a>
                </div>
                <div class="group">
                    <a href="${pageContext.request.contextPath}/mainPage">
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
