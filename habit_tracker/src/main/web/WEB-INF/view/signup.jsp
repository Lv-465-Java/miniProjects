<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: maric
  Date: 1/5/2020
  Time: 4:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sign up</title>
     <link rel="stylesheet" type="text/css" href="./css/style.css">
</head>
<body>
<div class="wrapper fadeInDown">
    <div id="formContent">
        <form action="signup" method="POST" onSubmit = "return checkPassword(this)">
            <h1>Sign up</h1>
            <p>Please fill in this form to create an account.</p>
            <c:if test="${error ne null}">
                <p class="text-center">
                    <font color="red">${error}</font>
                </p>
            </c:if>
            <br>
            <div>
                <font color="red">
                    <c:forEach var="configParams" items="${errors}">
                        <c:if test="${configParams.key=='name'}">
                            <c:out value="${configParams.value}" />
                        </c:if>
                    </c:forEach>
                </font>
            </div>
            <input type="text" id="name" class="fadeIn second" name="name" placeholder="name" required>
            <div>
                <font color="red">
                <c:forEach var="configParams" items="${errors}">
                    <c:if test="${configParams.key=='login'}">
                        <c:out value="${configParams.value}" />
                    </c:if>
                </c:forEach>
                </font>
            </div>
            <div>
                <font color="red">
                    <c:forEach var="configParams" items="${errors}">
                        <c:if test="${configParams.key=='blanklogin'}">
                            <c:out value="${configParams.value}" />
                        </c:if>
                    </c:forEach>
                </font>
            </div>
            <input type="text" id="login" class="fadeIn second" name="login" placeholder="login" required>
            <div>
                <font color="red">
                    <p id="passwordError"></p>
                    </font>
            </div>
            <input type="password" id="password" class="fadeIn third" name="password"  placeholder="password" required>
            <input type="password" id="confirm_password" class="fadeIn third" name="confirm_password"  placeholder="confirm password" required>
            <span id='message'></span>
            <script>
                function checkPassword(form) {
                    password = form.password.value;
                    confirm_password = form.confirm_password.value;
                    // If Not same return False.
                    if (password != confirm_password) {
                        document.getElementById("passwordError").innerHTML= ("\nPasswords did not match: Please try again...")
                        return false;
                    }}
            </script>
            <input type="submit" class="fadeIn fourth" value="Sign up">

        </form>
        <div id="formFooter">
            <p>Already have an account? <a href="<c:url value="/login"/>" class="underlineHover">Sign in</a> </p>
        </div>

    </div>
</div>

</body>
</html>
