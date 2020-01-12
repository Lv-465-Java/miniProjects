<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <title>My records</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="resource/css/file.css">
</head>

<body>
<jsp:include page="/header.jsp"/>

<div class="profileContainer">
    <div class="profileInfo">
        <div class="addRecordButton">
            <p class="reference" id="profileAddCategory"><a href="${pageContext.request.contextPath}/add-record">Add new
                record</a></p>
        </div>

        <div class="categoriesTable">


            <table class="table table-hover" id="profileTable">
                <thead>
                <tr>
                    <th scope="col">Sum</th>
                    <th scope="col">Date</th>
                    <th scope="col">Note</th>
                    <th scope="col">Financial Type</th>
                    <th scope="col">Category</th>
                    <th scope="col">Planned Outcome</th>
                </tr>
                </thead>
                <tbody>
                <%--@elvariable id="records" type="java.util.List"--%>
                <c:forEach var="record" items="${records}">
                    <tr>
                        <td>${record.sum}</td>
                        <td>${record.date}</td>
                        <td>${record.note}</td>
                        <c:forEach var="financialType" items="${financialTypes}">
                            <c:if test="${financialType.id == record.financialTypeId}">
                                <td>${financialType.typeName}</td>
                            </c:if>
                        </c:forEach>

                        <c:forEach var="category" items="${categories}">
                            <c:if test="${category.id == record.categoryId}">
                                <td>${category.title}</td>
                            </c:if>
                        </c:forEach>

                        <c:choose>
                            <c:when test="${record.planedOutcomeId > 0}">
                                <c:forEach var="plannedOutcome" items="${plannedOutcomes}">
                                    <c:if test="${plannedOutcome.id == record.planedOutcomeId}">
                                        <td>${plannedOutcome.note}</td>
                                    </c:if>
                                </c:forEach>
                            </c:when>
                            <c:when test="${record.planedOutcomeId == 0}">
                                <td>None</td>
                            </c:when>
                        </c:choose>
                        <td>
                            <div class="form-group">
                                <form action="${pageContext.request.contextPath}/edit-record" method="get">
                                    <button type="submit" class="btn btn-warning" name="editRecordButton"
                                            value="${record.id}">Edit
                                    </button>
                                </form>
                                <form action="${pageContext.request.contextPath}/delete-category" method="get">
                                    <button type="submit" class="btn btn-danger" name="buttondelete"
                                            value="${record.id}">Delete
                                    </button>
                                </form>
                            </div>

                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
</body>

</html>