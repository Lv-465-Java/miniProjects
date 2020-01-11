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
</head>

<body>
<jsp:include page="/header.jsp"/>

<div class="formsContainer">

    <div class="form-header">
        <h5 class="form-title">Add new record</h5>
    </div>

    <div class="form-group">
        <form action="${pageContext.request.contextPath}/add-record" method="post">

            <label for="RecordSum" class="floatLabel">Sum<span class="asterisk">*</span></label>
            <input id="RecordSum" name="sum" type="text" required>

            <label for="RecordDate" class="floatLabel">Date<span class="asterisk">*</span></label>
            <input id="RecordDate" name="date" type="date" required>

            <label for="RecordNote" class="floatLabel">Note</label>
            <input id="RecordNote" name="note" type="text">

            <label for="FinancialTypeList">Financial Type<span class="asterisk">*</span></label>
            <select class="form-select" id="FinancialTypeList" name="financial_type_id" required
                    value="${record.financialTypeId}">
                <option selected disabled>Select type</option>
                <c:forEach var="financialType" items="${financialTypes}">
                    <option id="option" value="${financialType.id}">${financialType.typeName}</option>
                </c:forEach>
            </select>

            <label for="CategoryList">Category<span class="asterisk">*</span></label>
            <select class="form-select" id="CategoryList" name="category_id" required
                    value="${record.categoryId}">
                <option selected disabled>Select type</option>
                <c:forEach var="category" items="${categories}">
                    <option id="option" value="${category.id}">${category.title}</option>
                </c:forEach>
            </select>

            <label for="PlannedOutcomesList">Planned Outcomes</label>
            <select class="form-select" id="PlannedOutcomesList" name="planned_outcome_id"
                    value="${record.plannedOutcomeId}">
                <option selected disabled>Select type</option>
                <c:forEach var="plannedOutcome" items="${plannedOutcomes}">
                    <option id="option" value="${plannedOutcome.id}">${plannedOutcome.note}</option>
                </c:forEach>
            </select>

            <div class="form-footer">
                <button type="submit" class="btn btn-primary" id="mainPageButton4">Save changes</button>
            </div>
        </form>
        <form action="${pageContext.request.contextPath}/record-dashboard" method="get">
            <button type="submit" class="btn btn-primary" id="mainPageButton">Cancel</button>
        </form>
    </div>

</div>
</body>
</html>