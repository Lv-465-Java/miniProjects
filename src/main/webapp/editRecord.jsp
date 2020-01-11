<%--suppress ALL --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>

<html lang="en">

<head>
    <title>Edit record</title>
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
        <h3 class="form-title">Edit Record</h3>
    </div>
    <div class="form-group">
        <form action="${pageContext.request.contextPath}/edit-record" method="post">
            <input type="hidden" name="record_id" value="${record.id}"/>
            <label for="recordSum" class="floatLabel">Sum<span class="asterisk">*</span></label>
            <input id="recordSum" name="sum" type="text" required value="${record.sum}"/>

            <label for="pickdate" class="floatLabel">Date</label>
            <%--            <jsp:include page="datePicker.jsp"/>--%>

            <label for="recordNote" class="floatLabel">Note</label>
            <input id="recordNote" name="note" type="text" value="${record.note}"/>

            <%--            CHECK--%>
            <label for="financialType" class="floatLabel">Financial Type</label>
            <%--            <jsp:include page="categoryDropdown.jsp"></jsp:include>--%>

            <%--CHECK--%>
            <label for="category" class="floatLabel">Category</label>
            <%--            <jsp:include page="categoryDropdown.jsp"></jsp:include>--%>

            <%--CHECK--%>
            <label for="plannedOutcome" class="floatLabel">Planned Outcome</label>
            <%--            <jsp:include page="categoryDropdown.jsp"></jsp:include>--%>

            <div class="form-footer">
                <button type="submit" class="btn btn-primary" id="formSaveButton">Save changes</button>
            </div>

        </form>
        <form action="${pageContext.request.contextPath}/record-dashboard" method="get">
            <button type="submit" class="btn btn-secondary" id="formCancelButton">Cancel</button>
        </form>
    </div>
</div>
</body>

</html>