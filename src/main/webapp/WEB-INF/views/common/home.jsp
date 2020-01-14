<%--
  Created by IntelliJ IDEA.
  User: Marian
  Date: 03.01.2020
  Time: 22:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>

    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src = "https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/style.css">
</head>
<body>
<jsp:include page="header.jsp"/>
<div class="block-center content">
    <main>
        <c:forEach var="post" items="${postList}">
        <article>
            <header>
                <img src="${pageContext.request.contextPath}/resources/images/posts/${post.imgPath}">
            </header>
            <h2>${post.title}</h2>
            <p><a href="${pageContext.request.contextPath}/post/view/${post.id}" class="more">Continue reading</a></p>

        </article>
        </c:forEach>
    </main>
    <aside>
        <div class="widget">
            <h2>Search</h2>
            <form action="${pageContext.request.contextPath}/search" method="post">
                <input type="search" name="text" class="search" placeholder="What are you looking for?">
            </form>
        </div>
        <div class="widget">
            <h2>Categories</h2>
            <nav>
                <ul>
                    <c:forEach var="category" items="${categories}">
                    <li><a href="${pageContext.request.contextPath}/search/${category.id}">${category.name}</a></li>
                    </c:forEach>
                </ul>
            </nav>
        </div>
    </aside>
    <div class="clear"></div>
    <div class="pager clearfix">
        <p class="previous-link"><a href="#">&larr; Previous</a></p>
        <p class="next-link"><a href="#">Next &rarr;</a></p>
    </div>
</div>
<jsp:include page="footer.jsp"/>
</body>
</html>
