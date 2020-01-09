
<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2020-01-08
  Time: 12:09
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Login</title>
<%--    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"--%>
<%--          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">--%>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="../../static/css/authentication.css">

</head>
<body>
<div class="register-photo">
    <div class="form-container">
        <div class="image-holder"></div>
        <form action="${pageContext.request.contextPath}/login" method="post">
            <h2 class="text-center"><strong>Login</strong> an account</h2>
            <c:if test="${not empty error}">
                <div>

                    <p>
                        <span style="color: red">${error}</span>
                    </p>
                </div>
            </c:if>
            <div class="form-group">
                <input class="form-control" type="text" name="nickname" placeholder="Nickname">
            </div>

            <div class="form-group">
                <input class="form-control" type="password" name="password" placeholder="Password">
            </div>

            <div class="form-group">
                <button class="btn btn-primary btn-block" name="submit" type="submit">Sign in</button>
            </div>
            <a class="already" href="<c:url value="/register"/>">You haven`t an account? Register here.</a>
        </form>
    </div>
</div>
</body>
</html>
