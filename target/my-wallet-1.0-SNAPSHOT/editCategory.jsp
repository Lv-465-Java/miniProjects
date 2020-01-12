<%--suppress ALL --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>

<html lang="en">

<head>
    <title>Edit category</title>
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
        <h3 class="form-title">Edit Category</h3>
    </div>
    <div class="form-group">
        <form action="${pageContext.request.contextPath}/edit-category" method="post">
            <input type="hidden" name="category_id" value="${category.id}"/>
            <label for="categoryTitle" class="floatLabel">Title<span class="asterisk">*</span></label>
            <input id="categoryTitle" name="title" type="text" required value="${category.title}"/>

            <label for="pickcolor" class="floatLabel">Color</label>
            <jsp:include page="colorPicker.jsp"/>

            <label for="categoryDescription" class="floatLabel">Description</label>
            <input id="categoryDescription" name="description" type="text" value="${category.description}"/>

            <label for="financial-type" class="floatLabel">Financial Type<span class="asterisk">*</span></label>
            <jsp:include page="financialTypeDropdown.jsp"></jsp:include>

            <div class="form-footer">
                <button type="submit" class="btn btn-primary" id="formSaveButton">Save changes</button>
            </div>

        </form>
        <form action="${pageContext.request.contextPath}/profile" method="get">
            <button type="submit" class="btn btn-secondary" id="formCancelButton">Cancel
            </button>
        </form>
    </div>
</div>
</body>


</html>