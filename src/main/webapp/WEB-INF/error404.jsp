<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: int
  Date: 15.01.20
  Time: 10:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Error 404</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
    <link rel="stylesheet" type="text/css" href="css/mainPage.css"/>
</head>
<body>
<section class="main-section">
    <div class="container">
        <div class="row">
            <div class="col-xl-12 mt-30">
                <h2 class="error-code text-danger text-center">404</h2>
                <h2 class="text-dark text-center mt-2">
                    Oops!! looks like there's nothing avalable at this location
                </h2>
                <div class="text-center mt-3">
                    <a href="<c:url value="/mainPage"/>">Back to main page</a>
                </div>
            </div>
        </div>
    </div>
</section>
</body>
</html>
