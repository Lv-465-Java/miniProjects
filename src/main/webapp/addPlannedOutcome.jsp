<%--suppress XmlInvalidId --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <title>Add planned outcome</title>
    <meta charset="utf-8">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="resource/css/file.css">
    <link rel="stylesheet" href="resource/css/forms.css">
</head>

<body>
<jsp:include page="/header.jsp"/>

<div class="formsContainer">

    <div class="form-header">
        <h3 class="form-title">Add planned outcome</h3>
    </div>

    <div class="form-group">
        <form action="${pageContext.request.contextPath}/add-planned-outcome" method="post">
            <label for="PlannedOutcomeSum" class="floatLabel">Sum<span class="asterisk">*</span></label>
            <input id="PlannedOutcomeSum" name="sum" type="text" required>

            <label for="PlannedOutcomeDate" class="floatLabel">Date<span class="asterisk">*</span></label>
            <input id="PlannedOutcomeDate" name="date" type="date" required>

            <label for="PlannedOutcomeNote" class="floatLabel">Note<span class="asterisk">*</span></label>
            <input id="PlannedOutcomeNote" name="note" type="text" required>

            <label for="pickcolor" class="floatLabel">Category<span class="asterisk">*</span></label>
            <jsp:include page="categoryDropdown.jsp"/>


            <c:if test="${not empty error}">
                <p class="errorActionMessage" id="error">${error}</p>
            </c:if>

            <div class="form-footer">
                <button type="submit" class="btn btn-primary" id="formSaveButton">Save changes</button>
            </div>
        </form>
        <form action="${pageContext.request.contextPath}/planned-outcome-dashboard" method="get">
            <button type="submit" class="btn btn-secondary" id="formCancelButton">Cancel</button>
        </form>
    </div>

</div>
</body>
</html>