<%--
  Created by IntelliJ IDEA.
  User: arch
  Date: 13.01.20
  Time: 12:14
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <title>To Do List</title>
</head>
<body>
<section class="main-section">
    <div class="container">
        <div class="row">
            <div class="col-xl-12 mt-30">
                <h2 class="error-code text-danger text-center">500</h2>
                <h2 class="text-dark text-center mt-2">
                    It is not you, it is me =(
                </h2>
                <div class="text-center mt-3">
                    <a href="<c:url value="${pageContext.request.getHeader(\"Referer\")}"/>">Return to previous page</a>
                </div>
            </div>
        </div>
    </div>
</section>
</body>
</html>
