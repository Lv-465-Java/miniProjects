<%--
  Created by IntelliJ IDEA.
  User: Marian
  Date: 06.01.2020
  Time: 19:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Login</title>
    <style>
        <jsp:directive.include file="/resources/css/style.css" />
        <jsp:directive.include file="/resources/css/form.css"/>
    </style>

    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>
<body>
<jsp:include page="../common/header.jsp"/>
<div class="container">
    <div class="row">
        <div class="col-md-4 col-md-offset-4" id="login">
            <section id="inner-wrapper" class="login">
                <h3 class="text-center">Log In:</h3>
                <article>
                    <form action="${pageContext.request.contextPath}/login" method="post">

                        <div class="form-group">
                            <c:if test="${not empty error}">
                                <div class="alert alert-danger">
                                    <strong>${error}</strong>
                                </div>
                            </c:if>
                            <label for="usr">Username:</label>
                            <input type="text" name="username" class="form-control" id="usr">
                        </div>

                        <div class="form-group">
                            <label for="pass">Password:</label>
                            <input type="password" name="password" class="form-control" id="pass">
                        </div>
                        <button type="submit" class="btn btn-success btn-block">Log in</button>
                    </form>
                </article>
            </section>
        </div>
    </div>
</div>
<jsp:include page="../common/footer.jsp"/>
</body>
</html>
