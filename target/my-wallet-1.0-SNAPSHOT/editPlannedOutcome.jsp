<%--suppress XmlInvalidId --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>

<html lang="en">

<head>
    <title>Edit planned outcome</title>
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
        <h3 class="form-title">Edit Planned outcome</h3>
    </div>
    <div class="form-group">
        <form action="${pageContext.request.contextPath}/edit-planned-outcome" method="post">
            <input type="hidden" name="planned_outcome_id" value="${plannedOutcome.id}"/>
            <label for="plannedOutcomeSum" class="floatLabel">Sum<span class="asterisk">*</span></label>
            <input id="plannedOutcomeSum" name="sum" type="text" required value="${plannedOutcome.sum}"/>

            <label for="datepicker" class="floatLabel">Date</label>
            <input id="PlannedOutcomeDate" name="date" type="date" required>

        <%--            <jsp:include page="datePicker.jsp"/>--%>

            <label for="plannedOutcomeNote" class="floatLabel">Note</label>
            <input id="plannedOutcomeNote" name="note" type="text" value="${plannedOutcome.note}"/>

            <label for="category" class="floatLabel">Category</label>
            <jsp:include page="categoryDropdown.jsp"/>

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