<%--suppress ALL --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="button dropdown">
    <select required id="colorselector" class="form-select" name="category_id">
        <c:if test="${empty record || empty plannedOutcome}">
            <option disabled selected value>None</option>
        </c:if>
        <c:forEach var="category" items="${categories}">
            <c:choose>
                <c:when test="${category.id == record.categoryId}">
                    <option id="option${category.id}" value="${category.id}" selected>${category.title} </option>
                </c:when>
                <c:otherwise>
                    <option id="option${category.id}" value="${category.id}">${category.title}</option>
                </c:otherwise>
            </c:choose>
        </c:forEach>
    </select>
</div>