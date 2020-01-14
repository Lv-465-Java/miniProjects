<%--suppress ALL --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="button dropdown">
    <select id="colorselector" class="form-select" name="planned_outcome_id">

        <%--        <c:if test="${empty record}">--%>
        <option disabled selected value>None</option>
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