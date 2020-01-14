<%--suppress ALL --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="button dropdown">
    <select required id="colorselector" class="form-select" name="financial_type_id">

        <c:if test="${empty category || empty record}">
            <option disabled selected value>None</option>
        </c:if>

        <c:forEach var="financialType" items="${financialTypes}">
            <c:choose>
                <c:when test="${financialType.id == category.financialTypeId}">
                    <option id="option" value="${financialType.id}" selected>${financialType.typeName} </option>
                </c:when>
                <c:when test="${financialType.id == record.financialTypeId}">
                    <option id="option" value="${financialType.id}" selected>${financialType.typeName} </option>
                </c:when>
                <c:otherwise>
                    <option id="option" value="${financialType.id}">${financialType.typeName}</option>
                </c:otherwise>
            </c:choose>
        </c:forEach>
    </select>
</div>