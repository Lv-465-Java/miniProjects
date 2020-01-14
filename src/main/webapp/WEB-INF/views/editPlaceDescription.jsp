<%--
  Created by IntelliJ IDEA.
  User: int
  Date: 12.01.20
  Time: 17:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>Edit place</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/login.css"/>
</head>
<body>
<c:if test="${not empty place}">
<form method="POST" action="${pageContext.request.contextPath}/editPlace">
    <input type="hidden" name="id" value="${place.id}" />
    <div class="login-wrap">
        <div class="login-html">
            <input id="tab-2" type="radio" name="tab" class="sign-up"><label for="tab-2" class="tab">Edit Place</label>
            <div class="login-form">
                <div class="sign-up-htm">
                    <form action="${pageContext.request.contextPath}/editPlace" method="post">
                        <div class="group">
                            <label for="country" class="label">Country</label>
                            <select id="country" name="country">       <!----place_id -->
                                <option value="" selected>Italy</option>
                                <option value="">Germany</option>
                                <option value="">Tokyo</option>
                            </select>
                            <!--  <input id="first" type="text" class="input" required> -->
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
                            <input id="description" name="description" type="text" class="input" >
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
    </c:if>
</body>
</html>
