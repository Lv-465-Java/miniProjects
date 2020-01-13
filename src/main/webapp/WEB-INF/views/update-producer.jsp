<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2020-01-13
  Time: 12:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Edit country</title>
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

<div class="update-producer">
    <div class="country-container">
        <%--        <form class="border border-light p-5" action="<c:url value="/update-producer/${producer.id}"/>" method="post"--%>
        <form class="border border-light p-5" action="${pageContext.request.contextPath}/update-producer" method="post"
              role="form" data-toggle="validator">
            <input type="hidden" name="producerId" value="${producerId}">
            <h2>Producer</h2>
            <div class="form-group col-xs-4">
                <label for="old-name">Old Name</label>
                <input type="text" name="old-name" id="old-name"
                       class="form-control mb-4" readonly
                       placeholder="${pageContext.request.getAttribute("old-name")}"/>
            </div>

            <div class="form-group col-xs-4">
                <input type="text" name="new-name" id="new-name" class="form-control mb-4" placeholder="New name"
                       required/>
                <button type="submit" name="update-submit" class="btn blue-gradient">Submit Update</button>
            </div>
            <c:if test="${not empty error}">
                <div class="alert alert-danger">
                        ${error}
                </div>
            </c:if>
        </form>
    </div>
</div>
<jsp:include page="/fragments/footer.jsp"/>
</body>
</html>
