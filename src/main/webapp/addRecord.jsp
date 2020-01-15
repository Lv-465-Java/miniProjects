<%--suppress ALL --%>
<%--suppress JSUnresolvedLibraryURL --%>
<%--suppress XmlInvalidId --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <title>Add record</title>
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
        <h3 class="form-title">Add Record</h3>
    </div>

    <div class="form-group">
        <form action="${pageContext.request.contextPath}/add-record" method="post">
            <label for="RecordSum" class="floatLabel">Sum<span class="asterisk">*</span></label>
            <input id="RecordSum" name="sum" type="text" required>

            <label for="datePickerDate" class="floatLabel">Date<span class="asterisk">*</span></label>
            <jsp:include page="datePicker.jsp"/>

            <label for="RecordNote" class="floatLabel">Note</label>
            <input id="RecordNote" name="note" type="text">

            <label for="financialTypeSelector" class="floatLabel">Financial Type<span class="asterisk">*</span></label>
            <jsp:include page="financialTypeDropdown.jsp"/>


            <label for="categorySelector" class="floatLabel">Category<span class="asterisk">*</span></label>
            <jsp:include page="categoryDropdown.jsp"/>


            <label for="plannedOutcomeDown" class="floatLabel">Planned Outcomes</label>
            <jsp:include page="plannedOutcomesDropdown.jsp"/>

            <c:if test="${not empty error}">
                <p class="errorActionMessage" id="error">${error}</p>
            </c:if>

            <div class="form-footer">
                <button type="submit" class="btn btn-primary" id="formSaveButton">Save changes</button>
            </div>
        </form>
        <form action="${pageContext.request.contextPath}/record-dashboard" method="get">
            <button type="submit" class="btn btn-secondary" id="formCancelButton">Cancel
            </button>
        </form>
    </div>

</div>
</body>
</html>