<%--suppress ELValidationInJSP --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <title>Delete category</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="resource/css/file.css">
    <link rel="stylesheet" href="resource/css/forms.css">
</head>

<body>
<jsp:include page="/header.jsp"/>

<div class="formsContainer">
    <div class="form-header">
        <h3 class="form-title">Delete Category</h3>
    </div>

    <div class="form-head">
        <h5>Are you sure you want to delete this Category?</h5>
    </div>

    <c:if test="${not empty error}">
        <p class="errorActionMessage" id="error">${error}</p>
    </c:if>

    <div class="form-group">
        <div class="form-footer">
            <form action="${pageContext.request.contextPath}/delete-category" method="post">
                <input type="hidden" name="id" value="${category.id}">
                <button type="submit" class="btn btn-danger" id="formSaveButton">Delete</button>
            </form>
            <form action="${pageContext.request.contextPath}/profile" method="get">
                <button type="submit" class="btn btn-secondary" id="formCancelButton">Cancel
                </button>
            </form>

        </div>
    </div>
</div>

</form>
</body>
</html>