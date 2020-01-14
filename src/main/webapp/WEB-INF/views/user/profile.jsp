<%--
  Created by IntelliJ IDEA.
  User: Marian
  Date: 05.01.2020
  Time: 17:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html>
<head>
    <title>Title</title>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/style.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/form.css">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>
<body>
<jsp:include page="../common/header.jsp"/>
<div class="container">
    <div class="row">
        <div class="col-md-12">
            <h2 class="text-center">My Profile</h2>
        </div>
    </div>
    <div class="row">
        <div class="col-md-2"></div>
        <div class="col-md-6">
            <table class="table table-bordered">
                <thead>
                <tr>
                    <th>Username</th>
                    <th>Password</th>
                    <th>First Name</th>
                    <th>Last Name</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td>${user.username}</td>
                    <td>${user.password}</td>
                    <td>${user.firstName}</td>
                    <td>${user.lastName}</td>
                </tr>
                </tbody>
            </table>
        </div>
        <div class="col-md-4">
            <nav>
                <ul>
                    <li><a href="${pageContext.request.contextPath}/profile/update" class="btn btn-light">Update Profile</a></li>
                    <li><a href="${pageContext.request.contextPath}/user/posts" class="btn btn-light">My Posts</a></li>
                    <c:if test="${isAdmin}">
                    <li><a href="${pageContext.request.contextPath}/admin" class="btn btn-light">Admin Page</a></li>
                    </c:if>
                </ul>
            </nav>
        </div>
    </div>
</div>
<jsp:include page="../common/footer.jsp"/>
</body>
</html>
