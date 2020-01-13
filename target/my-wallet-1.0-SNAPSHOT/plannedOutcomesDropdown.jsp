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

<div class="button dropdown">
    <select required id="colorselector" class="form-select" name="planned_outcome_id">

        <%--        <c:if test="${empty record}">--%>
        <option selected disabled>None</option>
        <%--        </c:if>--%>
        <c:forEach var="plannedOutcome" items="${plannedOutcomes}">
            <c:choose>
                <c:when test="${plannedOutcome.id == record.planedOutcomeId}">
                    <option id="option" value="${plannedOutcome.id}" selected>${plannedOutcome.note} </option>
                </c:when>
                <c:otherwise>
                    <option id="option" value="${plannedOutcome.id}">${plannedOutcome.note}</option>
                </c:otherwise>
            </c:choose>
        </c:forEach>

        <%--        <option selected disabled></option>--%>
        <%--        <c:forEach var="plannedOutcome" items="${plannedOutcomes}">--%>
        <%--            <option id="option" value="${plannedOutcome.id}">${plannedOutcome.note}</option>--%>
        <%--        </c:forEach>--%>
    </select>
</div>


<script>
    $(function () {
        $('#colorselector').change(function () {
            $('.colors').hide();
            $('#' + $(this).val()).show();
        });
    });
</script>

</body>
</html>