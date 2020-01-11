<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html lang="en">

<head>
    <title>Edit category</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href=<c:url value="resource/css/file.css"> </c:url>>
    <link rel="stylesheet" href=<c:url value="resource/css/forms.css"> </c:url>>
</head>

<body>
<jsp:include page="/header.jsp"/>

<div class="formsContainer">
    <div class="form-group">
        <form action="${pageContext.request.contextPath}/edit-category" method="post">
            <input type="hidden" name="category_id" value="${category.id}"/>
            <label for="categoryTitle" class="floatLabel">Title<span class="asterisk">*</span></label>
            <input id="categoryTitle" name="title" type="text" required
                   value=<c:out value="${category.title}"> </c:out>>
            <%--@elvariable id="category" type="com.softserve.entity.Category"--%>


            <label for="categoryColor" class="floatLabel">Color</label>
            <input id="categoryColor" name="color" type="color" value=<c:out value="${category.color}"> </c:out>>

            <label for="categoryDescription" class="floatLabel">Description</label>
            <input id="categoryDescription" name="description" type="text"
                   value=<c:out value="${category.description}"> </c:out>>

            <label for="financialType">Financial Type<span class="asterisk">*</span></label>
            <select class="form-select" id="financialType" name="financial_type" required
                    value=<c:out value="${category.financialTypeId}"> </c:out>>
                <%--@elvariable id="financialTypes" type="java.util.List"--%>
                <c:forEach var="financialType" items="${financialTypes}">
                    <option id="option" value="${financialType.id}">${financialType.typeName}</option>
                </c:forEach>
            </select>
            <div class="form-footer">
                <button type="submit" class="btn btn-primary" id="mainPageButton4">Save changes</button>
            </div>
        </form>
        <form action="${pageContext.request.contextPath}/profile" method="get">
            <button type="submit" class="btn btn-primary" id="mainPageButton">Cancel
            </button>
        </form>
    </div>
</div>
</body>


</html>