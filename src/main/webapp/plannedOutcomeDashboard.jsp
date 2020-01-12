<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <title>Planned outcome Dashboard</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="resource/css/file.css">
</head>

<body>
<jsp:include page="/header.jsp"/>

<div class="PlannedOutcomeContainer">
    <div class="allPlannedOutcomes">
        <p class="reference" id="AddNewPlannedOutcome"><a href="${pageContext.request.contextPath}/add-record">Add new
            planned outcome</a></p>

        <table class="table table-hover">
            <thead>
            <tr>
                <th scope="col">#</th>
                <th scope="col">Category color</th>
                <th scope="col">Category</th>
                <th scope="col">Sum</th>
                <th scope="col">Date</th>
                <th scope="col">Note</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="plannedOutcome" items="${plannedOutcomes}">
                <tr>
                    <td>${plannedOutcome.id}</td>

                    <c:forEach var="category" items="${categories}">
                        <c:if test="${category.id == plannedOutcome.categoryId}">
                            <td>${category.color}</td>
                            <td>${category.title}</td>
                        </c:if>
                    </c:forEach>

                    <td>${plannedOutcome.sum}</td>
                    <td>${plannedOutcome.date}</td>
                    <td>${plannedOutcome.note}</td>
                    <td>
                        <form action="${pageContext.request.contextPath}/edit-record" method="get">
                            <input type="submit" class="btn btn-outline-danger" name="editPlannedOutcomeButton"
                                   value="Edit">
                        </form>
                        <form action="${pageContext.request.contextPath}/delete-category" method="get">
                            <input type="submit" class="btn btn-outline-danger" name="editPlannedOutcomeButton"
                                   value="Delete">
                        </form>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
</body>

</html>