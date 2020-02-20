<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: maric
  Date: 1/3/2020
  Time: 10:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>404</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>
<section class="main-section">
    <div class="container">
        <div class="row">
            <div class="col-xl-12 mt-30">
                <h2 class="error-code text-danger text-center">404</h2>
                <h2 class="text-dark text-center mt-2">
                    Woops! We don't know where are you going =)
                </h2>
                <div class="text-center mt-3">
                    <a href="<c:url value="/login"/>">Return to login page</a>
                </div>
            </div>
        </div>
    </div>
</section>
</body>
</html>
