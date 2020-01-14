<%--suppress ALL --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="resource/css/file.css">
    <link rel="stylesheet" href="resource/css/forms.css">
    <title></title>
</head>
<body>
<div class="record filter">

    <form action="${pageContext.request.contextPath}/record-dashboard" method="post" id="filterForm">

        <label for="datePickerDateFrom" class="floatLabel" id="fromToDate">From</label>
        <input type="date" id="datePickerDateFrom" name="fromDate">

        <label for="datePickerDateTo" class="floatLabel" id="fromToDate">To</label>
        <input type="date" id="datePickerDateTo" name="toDate">

        <div class="button dropdown" id="recordFilterDropdownId">
            <select required id="recordFilterDropdown" class="form-select" name="financial_type_id">
                <option selected disabled>None</option>
                <c:forEach var="financialType" items="${financialTypes}">
                    <option id="option" value="${financialType.id}">${financialType.typeName}</option>
                </c:forEach>

            </select>
        </div>
        <button type="submit" class="btn btn-primary" id="filterButton">Filter</button>
    </form>
</div>

<form action="/record-dashboard" method="get">
    <button type="submit" class="btn btn-secondary" id="resetFilterButton">Reset filter</button>
</form>

</body>
</html>