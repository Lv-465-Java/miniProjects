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

    <form action="${pageContext.request.contextPath}/record-dashboard" method="post">

        <label for="datePickerDateFrom" class="floatLabel">From</label>
<%--        <c:if>--%>
<%--            <input type="date" id="datePickerDateFrom" name="fromDate" value=dfrom>--%>

<%--        </c:if>--%>
        <input type="date" id="datePickerDateFrom" name="fromDate" value=${"2020-01-28"}>

<%--            <jsp:include page="datePickerFrom.jsp"/>--%>

        <label for="datePickerDateTo" class="floatLabel">To</label>
        <input type="date" id="datePickerDateTo" name="toDate">
<%--        <jsp:include page="datePickerTo.jsp"/>--%>

        <select required id="recordFilterDropdown" class="form-select" name="financial_type_id">
            <option selected disabled>None</option>
            <c:forEach var="financialType" items="${financialTypes}">
                <option id="option" value="${financialType.id}">${financialType.typeName}</option>
            </c:forEach>

<%--            <c:forEach var="financialType" items="${financialTypes}">--%>
<%--                <c:choose>--%>
<%--                    <c:when test="${financialType.id == record.categoryId}">--%>
<%--                        <option id="option" value="${financialType.id}" selected>${financialType.title} </option>--%>
<%--                    </c:when>--%>
<%--                    <c:otherwise>--%>
<%--                        <option id="option" value="${financialType.id}">${financialType.title}</option>--%>
<%--                    </c:otherwise>--%>
<%--                </c:choose>--%>
<%--            </c:forEach>--%>
        </select>

        <button type="submit" class="btn btn-secondary" id="formCancelButton">Filter</button>
    </form>
</div>

<form action="/record-dashboard" method="get">
    <button type="submit" class="btn btn-danger" id="formSaveButton">Reset filter</button>
</form>

</body>
</html>