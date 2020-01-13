<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2020-01-13
  Time: 18:18
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add model</title>
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
<div class="update-model">
    <div class="model-container">
        <form class="border border-light p-5" action="${pageContext.request.contextPath}/update-model" method="post"
              role="form" data-toggle="validator">
            <input type="hidden" name="producerId" value="${modelId}">
            <h2>Model</h2>
            <div class="form-group col-xs-4">
                <select name="producers">
                    <option selected disabled value="producer">Producer</option>
                    <c:forEach items="${producers}" var="producer">
                        <option value="${producer.id}">${producer.name}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="form-group col-xs-4">
                <label for="old-name">Old Name</label>
                <input type="text" name="old-name" id="old-name"
                       class="form-control mb-4" readonly
                       placeholder="${pageContext.request.getAttribute("old-name")}"/>
            </div>
            <div class="form-group col-xs-4">
                <input type="text" name="new-name" id="new-name" class="form-control mb-4"
                       placeholder="New Name"
                       required/>
                <button type="submit" name="submit" class="btn blue-gradient">Submit</button>
            </div>
            <c:if test="${not empty error}">
                <div class="alert alert-info">
                        ${error}
                </div>
            </c:if>
        </form>
    </div>
</div>
<jsp:include page="/fragments/footer.jsp"/>
</body>
</html>
