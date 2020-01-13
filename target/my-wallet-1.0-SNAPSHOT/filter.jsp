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

<form action="/profile.jsp" method="post">
    <div class="record filter">

        <label for="FromDate" class="floatLabel">From</label>
        <input id="FromDate" name="fromDate" type="date">
        <label for="ToDate" class="floatLabel">To</label>
        <input id="ToDate" name="toDate" type="date">
        <%--    Should be selector--%>
        <label for="FinancialTypeId" class="floatLabel">FinancialType</label>
        <input id="FinancialTypeId" name="financialTypeId" type="text">
    </div>
    <button type="submit" class="btn btn-secondary" id="formCancelButton">Filter</button>
</form>
<button type="submit" class="btn btn-danger" id="formSaveButton">Reset filter</button>
<form>

</form>

</body>
</html>