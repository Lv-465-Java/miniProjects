<%--
  Created by IntelliJ IDEA.
  User: Marian
  Date: 10.01.2020
  Time: 14:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/style.css">

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>
<body>
<jsp:include page="../common/header.jsp"/>
<div class="container">
    <div class="row">
        <div class="col-md-2"></div>
        <div class="col-md-8">
            <h1>${post.title}</h1>
            <p class="lead"><i class="fa fa-user"></i> by <strong>${post.author}</strong</p>
            <hr>
            <div class="d-flex justify-content-between">
                <p id="datetime"><i class="fas fa-calendar"></i> Posted on ${post.createdDate}</p>
                <p><i class="fas fa-calendar"></i> Updated on ${post.updatedDate}</p>
            </div>
            <hr>
            <img src="${pageContext.request.contextPath}/resources/images/posts/${post.imgPath}" class="img-responsive">
            <hr>
            <p class="lead">${post.content}</p>
        </div>
        <div class="col-md-2"></div>
    </div>
</div>
<jsp:include page="../common/footer.jsp"/>
</body>
</html>
