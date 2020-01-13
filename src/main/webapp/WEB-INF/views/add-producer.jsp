<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2020-01-12
  Time: 19:54
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add country</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta http-equiv="x-ua-compatible" content="ie=edge">

    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.11.2/css/all.css">
    <!-- Bootstrap core CSS -->
    <link rel="stylesheet" href="static/css/bootstrap.min.css">
    <!-- Material Design Bootstrap -->
    <link rel="stylesheet" href="static/css/mdb.min.css">
    <!-- Your custom styles (optional) -->
    <link rel="stylesheet" href="static/css/admin-page.css">
</head>
<body>
<jsp:include page="/fragments/admin-page-header.jsp"/>

<div class="add-producer">
    <div class="producer-container">
        <form class="border border-light p-5" action="${pageContext.request.contextPath}/add-producer" method="post"
              role="form" data-toggle="validator">
            <h2>Producer</h2>
            <div class="form-group col-xs-4">
                <input type="text" name="name" id="name" class="form-control mb-4" placeholder="Name"
                       required/>
                <button type="submit" name="submit" class="btn blue-gradient">Submit</button>
            </div>
            <c:if test="${not empty error}">
                <div class="alert alert-info">
                        ${error}
                </div>
            </c:if>
            <c:if test="${not empty success}">
                <div class="alert alert-success">
                        ${success}
                </div>
            </c:if>
        </form>
    </div>
</div>

<form class="border-light" action="${pageContext.request.contextPath}/add-producer" method="get">
    <table class="table table-dark">
        <thead class="thead-dark">
        <tr>
            <td>ID</td>
            <td>Name</td>
            <td>Actions <a class=""><i>+</i></a></td>
        </tr>
        </thead>
        <tbody class="producer-container">
        <c:forEach var="producer" items="${producers}">
            <tr>
                <td>${producer.id}</td>
                <td>${producer.name}</td>
                <form action="${pageContext.request.contextPath}/update-producer">
                    <td>
                        <a href="/update-producer?producerId=$${producer.id}&old-name=${producer.name}">
                            <button name="update" value="${producer.id}" class="btn blue-gradient btn-md">UPDATE</button>
                        </a>
                    </td>
                </form>
                <form action="${pageContext.request.contextPath}/delete-producer" method="post">
                    <td>
                        <button name="delete" value="${producer.id}" class="btn blue-gradient btn-md">DELETE</button>
                    </td>
                </form>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</form>
<%--    <jsp:include page="/fragments/drop-producers.jsp"/>--%>
    <jsp:include page="/fragments/footer.jsp"/>
</body>
<script src="static/js/bootstrap.min.js"></script>

</html>
