<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2020-01-13
  Time: 23:26
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update phone</title>
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

<div class="update-phone">
    <div class="phone-container">
        <form class="border border-light p-5" action="${pageContext.request.contextPath}/update-phone" method="post" enctype="multipart/form-data"
              role="form" data-toggle="validator">
            <%--            <input type="hidden" name="producerId" value="${}">--%>
            <h2>Phone</h2>
            <div class="form-group col-xs-4">
                <select name="models" required>
                    <option  selected disabled value="models">Models</option>
                    <c:forEach items="${models}" var="model">
                        <option value="${model.id}">${model.name}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="form-group col-xs-4">
                <label for="year">Year</label>
                <input type="number" name="new-year" id="year" class="form-control mb-4"
                       placeholder="${pageContext.request.getAttribute("old-year")}" required/>
            </div>

            <div class="form-group col-xs-4">
                <label for="price">Price</label>
                <input type="number" name="new-price" id="price" class="form-control mb-4"
                       placeholder="${pageContext.request.getAttribute("old-price")}" required/>
            </div>
            <div class="form-group col-xs-4">
                <div class="file-upload-wrapper">
                    <input type="file" name="photo" id="input-file-now" class="file-upload"/>
                </div>
            </div>
<%--                <div class="form-group col-xs-4">--%>
<%--                    <div class="file-upload-wrapper">--%>
<%--                        <input type="file" name="photo" id="input-file-now" class="file-upload"/>--%>
<%--                    </div>--%>
<%--                </div>--%>

            <div class="form-group col-xs-4">
                <label for="color">Color</label>
                <input type="text" name="new-color" id="color" class="form-control mb-4"
                       placeholder="${pageContext.request.getAttribute("old-color")}" required/>
            </div>

            <div class="form-group col-xs-4">
                <label for="screen-diagonal">Screen Diagonal</label>
                <input type="number" step="0.01" name="new-screen-diagonal" id="screen-diagonal"
                       class="form-control mb-4"
                       placeholder="${pageContext.request.getAttribute("old-screen-diagonal")}" required/>
            </div>

            <div class="form-group col-xs-4">
                <label for="internal-memory">Internal Memory</label>
                <input type="number" name="new-internal-memory" id="internal-memory" class="form-control mb-4"
                       placeholder="${pageContext.request.getAttribute("old-internal-memory")}" required/>
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
