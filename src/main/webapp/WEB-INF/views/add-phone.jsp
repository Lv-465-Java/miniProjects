<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2020-01-13
  Time: 19:59
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Phone</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta http-equiv="x-ua-compatible" content="ie=edge">

    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.11.2/css/all.css">
    <!-- Bootstrap core CSS -->
    <link rel="stylesheet" href="static/css/bootstrap.min.css">
    <!-- Material Design Bootstrap -->
    <link rel="stylesheet" href="static/css/mdb.min.css">
    <!-- Your custom styles (optional) -->
    <link rel="stylesheet" href="static/css/style.css">
    <!-- Your custom styles (optional) -->
    <link rel="stylesheet" href="static/css/admin-page.css">
</head>
<body>
<jsp:include page="/fragments/admin-page-header.jsp"/>
<div class="add-phone">
    <div class="phone-container">
        <form class="border border-light p-5" action="${pageContext.request.contextPath}/add-phone" method="post" enctype="multipart/form-data"
              role="form" data-toggle="validator">
            <h2>Phones</h2>
            <div class="form-group col-xs-4">
                <select name="models">
                    <option selected disabled value="models">Models</option>
                    <c:forEach items="${models}" var="model">
                        <option value="${model.id}">${model.name}</option>
                    </c:forEach>
                </select>
            </div>

            <div class="form-group col-xs-4">
                <input type="number" name="year" id="year" class="form-control mb-4" placeholder="Year" required/>
            </div>

            <div class="form-group col-xs-4">
                <input type="number" name="price" id="price" class="form-control mb-4" placeholder="Price" required/>
            </div>
            <div class="form-group col-xs-4">
                <div class="file-upload-wrapper">
                    <input type="file" name="photo" id="input-file-now" class="file-upload"/>
                </div>
            </div>

            <div class="form-group col-xs-4">
                <input type="text" name="color" id="color" class="form-control mb-4" placeholder="Color" required/>
            </div>

            <div class="form-group col-xs-4">
                <input type="number" step="0.01" name="screen-diagonal" id="screen-diagonal" class="form-control mb-4"
                       placeholder="Screen Diagonal" required/>
            </div>

            <div class="form-group col-xs-4">
                <input type="number" name="internal-memory" id="internal-memory" class="form-control mb-4"
                       placeholder="Internal memory" required/>
            </div>

            <button type="submit" name="submit" class="btn blue-gradient">Submit</button>
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
<div>
<%--<input type="file" onchange="encodeImageFileAsURL(this)" />--%>
</div>

<%--<form class="border-light" action="${pageContext.request.contextPath}/add-phone" method="get">--%>
    <table class="table table-dark">
        <thead class="thead-dark">
        <tr>
            <td>ID</td>
            <td>Year</td>
            <td>Price</td>
            <td>Photo</td>
            <td>Color</td>
            <td>Screen Diagonal</td>
            <td>Internal Memory</td>
            <td>ModelId</td>
            <td>Actions <a class=""><i>+</i></a></td>
        </tr>
        </thead>
        <tbody class="producer-container">
        <c:forEach var="phone" items="${phones}">
            <tr>
                <td>${phone.id}</td>
                <td>${phone.year}</td>
                <td>${phone.price}</td>
                <td><img width="100" height="100" src="${pageContext.request.contextPath}/static/images/${phone.photo}"></td>
                    <%--                <td>${phone.photo}</td>--%>
                <td>${phone.color}</td>
                <td>${phone.screenDiagonal}</td>
                <td>${phone.internalMemory}</td>
                <td>${phone.modelId}</td>
                <form action="${pageContext.request.contextPath}/update-phone">
                    <td>
                        <a href="/update-phone?phoneId=$${phone.id}">
                            <button name="update" value="${phone.id}" class="btn blue-gradient btn-md">UPDATE</button>
                        </a>
                    </td>
                </form>
                <form action="${pageContext.request.contextPath}/delete-phone" method="post">
                    <td>
                        <button name="delete" value="${phone.id}" class="btn blue-gradient btn-md">DELETE</button>
                    </td>
                </form>
            </tr>
        </c:forEach>
        </tbody>
    </table>

<%--</form>--%>
<%--    <jsp:include page="/fragments/drop-producers.jsp"/>--%>
<jsp:include page="/fragments/footer.jsp"/>
</body>
</html>
