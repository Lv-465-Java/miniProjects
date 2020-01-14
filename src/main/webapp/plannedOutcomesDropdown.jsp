<%--suppress ALL --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="button dropdown">

    <select id="plannedOutcomeDown" class="form-select" name="planned_outcome_id">
        <option disabled selected value>None</option>
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

    </select>
    <button id="unselect" type="button" class="close" aria-label="Close">
        <span aria-hidden="true">&times;</span>
    </button>
</div>

<script>
    $("#unselect").click(function(){
        $("#plannedOutcomeDown").val(0);
    });
</script>