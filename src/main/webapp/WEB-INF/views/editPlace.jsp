<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: int
  Date: 12.01.20
  Time: 01:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>Edit place</title>
    <link rel="stylesheet" type="text/css" href="css/login.css"/>
</head>
<body>
<form method="POST" action="${pageContext.request.contextPath}/editPlace">
    <input type="hidden" name="id" value="${place.id}" />
    <div class="login-wrap">
        <div class="login-html">
            <input id="tab-2" type="radio" name="tab" class="sign-up"><label for="tab-2" class="tab">Edit Place</label>
            <div class="login-form">
                <div class="sign-up-htm">
                    <form action="${pageContext.request.contextPath}/editPlace" method="post">
                        <input type="hidden" name="placeId" value="${placeDto.id}">
                        <div class="group">
                            <label for="country" class="label">Country</label>
                            <input id="country" name="country" type="text" class="input" value="${placeDto.country}">
                        </div>
                        <div class="group">
                            <label for="town" class="label">Town</label>
                            <input id="town" name="town" type="text" class="input" value="${placeDto.town}">
                        </div>
                        <div class="group">
                            <label for="name" class="label">name</label>
                            <input id="name" name="name" type="text" class="input" value="${placeDto.name}">
                        </div>
                        <div class="group">
                            <label for="description" class="label">Description</label>
                            <textarea id="description" name="description" cols="60" rows="4" required>${placaDto.description}</textarea>
                        </div>
                        <div class="group">
                            <label for="photo" class="label">Photo</label>
                            <input id="photo" name="photo" type="text" class="input" required>
                        </div>


                        <div class="group">
                            <input type="submit" class="button" value="Edit">
                        </div>
                        <div class="group">
                            <a href="${pageContext.request.contextPath}/placeList">
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
