<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2020-01-08
  Time: 17:43
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<html>
<head>
    <title>Sign Up</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="static/css/authentication.css">
<%--    <link rel="stylesheet" type="text/css" href=<c:url value="/css/authentication.css">--%>
<%--    </c:url>>--%>
</head>
<body>
<div class="register-photo">
    <div class="form-container">
        <div class="image-holder"></div>
        <form action="${pageContext.request.contextPath}/register" method="post">
            <h2 class="text-center"><strong>Create</strong> an account</h2>
            <c:if test="${not empty error}">
                <div class="alert alert-danger">
                        ${error}
                </div>
            </c:if>
            <div class="form-group">
                <input class="form-control" type="text" name="nickname" placeholder="Nickname" required>
            </div>

            <div class="form-group">
                <input class="form-control" type="password" name="password" placeholder="Password" required>
            </div>

            <div class="form-group">
                <input class="form-control" type="email" name="email" placeholder="Email">
            </div>

            <div class="form-group">
                <input class="form-control" type="tel" name="phone" placeholder="Phone number">
            </div>

            <div class="form-group">
                <div class="form-check">
                    <label class="form-check-label">
                        <input class="form-check-input" type="checkbox">I agree to the license terms.
                    </label>
                </div>
            </div>

            <div class="form-group">
                <button class="btn btn-primary btn-block" name="submit" type="submit">Sign Up</button>
            </div>

            <a class="already" href="<c:url value="/login"/>">You already have an account? Login here.</a>
        </form>
    </div>
</div>
</body>
</html>
