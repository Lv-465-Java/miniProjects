<%--
  Created by IntelliJ IDEA.
  User: Marian
  Date: 12.01.2020
  Time: 13:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html>
<head>
    <title>Create Post</title>
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
        <div class="col-md-2"></div>
        <div class="col-md-8 col-md-offset-4">
            <section id="inner-wrapper">
                <h3 class="text-center">Update post</h3>
                <article>
                    <form action="${pageContext.request.contextPath}/post/update/${post.id}" method="post" enctype="multipart/form-data">
                        <input type="hidden" name="post_id" value="${post.id}">
                        <div class="form-group">
                            <label for="title">Title:</label>
                            <input type="text" name="title" class="form-control" id="title" value="${post.title}">
                        </div>

                        <div class="form-group">
                            <label for="content">Content:</label>
                            <textarea class="form-control" name="content" rows="5" id="content">${post.content}</textarea>
                        </div>
                        <div class="form-group">
                            <label for="category">Category list:</label>
                            <select class="form-control" name="category_id" id="category">
                                <option value="1">Travel</option>
                                <option value="2">Food</option>
                                <option value="3">Sports</option>
                                <option value="4">Music</option>
                            </select>
                        </div>
                        <div class="form-group">
                        <input type="file" name="file" />
                        </div>
                        <button type="submit" class="btn btn-success btn-block">Update</button>
                    </form>
                </article>
            </section>
        </div>
        <div class="col-md-2"></div>
    </div>
</div>
<jsp:include page="../common/footer.jsp"/>
</body>
</html>
