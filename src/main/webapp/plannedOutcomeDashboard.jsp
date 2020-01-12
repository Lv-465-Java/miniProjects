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

<div class="profileContainer">
    <div class="profileInfo">
        <div class="addPlannedOutcomeButton">
            <p class="reference" id="profileAddCategory"><a
                    href="${pageContext.request.contextPath}/add-planned-outcome">Add new
                planned outcome</a></p>
        </div>

        <div class="categoriesTable">

            <table class="table table-hover" id="profileTable">
                <thead>
                <tr>
                    <th scope="col"></th>
                    <th scope="col">Category</th>
                    <th scope="col">Sum</th>
                    <th scope="col">Date</th>
                    <th scope="col">Note</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="plannedOutcome" items="${plannedOutcomes}">
                    <tr>

                        <c:forEach var="category" items="${categories}">
                            <c:if test="${category.id == plannedOutcome.categoryId}">
                                <td>
                                    <div class="color-holder call-picker"
                                         style="background-color: ${category.color}"></div>
                                </td>
                                <td>${category.title}</td>
                            </c:if>
                        </c:forEach>

                        <td>${plannedOutcome.sum}</td>
                        <td>${plannedOutcome.date}</td>
                        <td>${plannedOutcome.note}</td>
                        <td>
                            <div class="form-group">
                                <form action="${pageContext.request.contextPath}/edit-planned-outcome" method="get">
                                    <button type="submit" class="btn btn-warning" name="editPlannedOutcomeButton"
                                            value="${plannedOutcome.id}">Edit
                                    </button>
                                </form>
                                <form action="${pageContext.request.contextPath}/delete-category" method="get">
                                    <button type="submit" class="btn btn-danger" name="editPlannedOutcomeButton"
                                            value="${plannedOutcome.id}">Delete
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