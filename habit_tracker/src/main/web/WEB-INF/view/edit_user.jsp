<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: maric
  Date: 1/11/2020
  Time: 2:29 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="./css/style.css">
</head>
<body>
<div class="wrapper fadeInDown">
    <div id="formContent">
        <form action="edit_user" method="POST">
            <h1>Edit user info</h1>
            <p>Please enter new data in this form.</p>
            <h3>
                <font color="red">
                    <c:forEach var="configParams" items="${errors}">
                    <c:if test="${configParams.key=='name'}">
                    <c:out value="${configParams.value}" /></>
                </c:if>
                </c:forEach>
                </font>
            </h3>

            <br>
            <input type="text" id="name" class="fadeIn second" name="name" placeholder="name"  value="${name}">
            <h3>
                <font color="red">
                    <c:forEach var="configParams" items="${errors}">
                    <c:if test="${configParams.key=='blanklogin'}">
                    <c:out value="${configParams.value}" /></>
                </c:if>
                </c:forEach>
                </font>
            </h3>
            <h3>
                <font color="red">
                    <c:forEach var="configParams" items="${errors}">
                    <c:if test="${configParams.key=='login_exist'}">
                    <c:out value="${configParams.value}" /></>
                </c:if>
                </c:forEach>
                </font>
            </h3>
            <input type="text" id="login" class="fadeIn second" name="login" placeholder="login"
                   value="${loginedUser.login}">
            <input type="password" id="password" class="fadeIn third" name="password"  placeholder="password">
            <script>document.getElementById("password").defaultValue = ${loginedUser.password};</script>
            <input type="password" id="confirm_password" class="fadeIn third" name="confirm_password"  placeholder="confirm password">
            <script>document.getElementById("confirm_password").defaultValue = ${loginedUser.password};</script>
            <script>
                function checkPassword(form) {
                    password = form.password.value;
                    confirm_password = form.confirm_password.value;
                    if (password != confirm_password) {
                        document.getElementById("passwordError").innerHTML= ("\nPasswords did not match: Please try again...")
                        return false;
                    }}
            </script>
            <input type="submit" class="fadeIn fourth" value="Confirm">

        </form>


    </div>
</div>
</body>
</html>
