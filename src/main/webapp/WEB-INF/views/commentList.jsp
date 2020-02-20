<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: int
  Date: 11.01.20
  Time: 16:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Comment List</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/mainPage.css"/>
</head>
<body>
<div class="wrapper container">
    <jsp:include page="/fragments/header.jsp"/>


    <div class="nav navbar-nav">
        <div class="row">
            <div class="col-1"></div>
            <div class= col-3>
                <a class="nav-link" href="#">${userDto.username}</a>
            </div>
            <div class="col-3">
                <a class="nav-link" href="${pageContext.request.contextPath}/logout">Log out</a>
            </div>
        </div>
    </div>


    <div class="heading"></div>

    <div class="row">
        <aside class="col-md-3">
            <div class="panel panel-primary">
                <div class="panel-heading">MENU</div>
                <div class="panel-body">
                    <ul class="list-group submenu">
                        <li class="list-group-item active">
                            <a href="${pageContext.request.contextPath}/editUser">Edit profile</a></li>
                        <li class="list-group-item">Comments
                            <ul>
                                <li><a href="${pageContext.request.contextPath}/getUserComment">My comments</a></li>
                                <li><a href="${pageContext.request.contextPath}/createComment">Create comment</a></li>

                            </ul>
                        </li>
                        <li class="list-group-item">Trips
                            <ul>
                                <li><a href="${pageContext.request.contextPath}/getUserTrip">My trips</a></li>
                                <li><a href="${pageContext.request.contextPath}/createTrip">Create trip</a></li>

                            </ul>
                        </li>
                        <li class="list-group-item"><a href="${pageContext.request.contextPath}/evaluatePlace">Evaluate the place</a></li>
                    </ul>
                </div>
            </div>
        </aside>



        <section class="col-md-9">
            <div class="jumbotron">
                <blockquote>
                <p>
                    The world is a book and those who do not travel read only a page
                </p>
                <small>Saint Augustine</small>
                </blockquote>
            </div>
            <div class="container features">
                <table class="table">

                <c:forEach items="${commentList}" var="comm">
                    <tr>
                         <td>${comm.userId}</td>
                         <td>${comm.dateOfComment}</td>
                         <td>${comm.placeId}</td>
                          <td>${comm.textOfComment}</td>
                        <td>
                            <form action="${pageContext.request.contextPath}/deleteComment" method="post">
                                <input type="hidden" name="commentId" value="${comm.id}">
                                <input type="submit" name="id" class="button" value="Delete">
                            </form>
                        </td>
                        <td>
                            <form action="${pageContext.request.contextPath}/editComment" method="get">
                                <input type="hidden" name="comId" value="${comm.id}">
                                <input type="submit" name="comment" class="button" value="Update">
                            </form>
                        </td>
                    </tr>
                </c:forEach>
                    <c:if test="${not empty error}">
                        <c:out value="${error}"/>
                    </c:if>
                </table>
            </div>
        </section>
    </div>
</div>



<jsp:include page="/fragments/footer.jsp"/>
</body>
</html>
