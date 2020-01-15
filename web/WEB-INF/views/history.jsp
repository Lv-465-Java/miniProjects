<%--
  Created by IntelliJ IDEA.
  User: arch
  Date: 05.01.20
  Time: 22:41
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <title>History</title>
</head>
<body>
<jsp:include page="fragments/header.jsp"/>
<br>
<div class="row justify-content-center">
    <form action="${pageContext.request.contextPath}/delete-record" method="post">
        <button type="submit" name="CLEAR" class="btn btn-danger" value="${history_record.id}">Clear history
        </button>
    </form>
    <button type="button" class="btn btn-light btn-lg" disabled></button>
    <form action="${pageContext.request.contextPath}/history" method="post">
    <div class="navbar-nav">
        <div class="dropdown">
            <button class="btn btn-primary dropdown-toggle" type="button" id="dropdownMenuButton"
                    data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                Period
            </button>
            <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                <button type="submit" class="dropdown-item" name="today" value="today">Today</button>
                <button type="submit" class="dropdown-item" name="last week" value="last week">Last week</button>
                <button type="submit" class="dropdown-item" name="last month" value="last month">Last month</button>
                <button type="submit" class="dropdown-item" name="last year" value="last year">Last year</button>
                <button type="submit" class="dropdown-item" name="all" value="all">All</button>
            </div>
        </div>
    </div>
    </form>
</div>

<table class="table">
    <thead class="thead-dark">
    <tr>
        <th>Task</th>
        <th>Modified Date</th>
        <th>Status</th>
        <th>Delete</th>
    </tr>
    </thead>
    <c:forEach var="history_record" items="${historyList}">
        <tr>
            <td>${history_record.task}</td>
            <td>${history_record.modifiedDate}</td>
            <td>${history_record.status}</td>
            <form action="${pageContext.request.contextPath}/delete-record" method="post">
                <th>
                    <button type="submit" name="DELETE" class="btn btn-danger" value="${history_record.id}">DELETE
                    </button>
                </th>
            </form>
        </tr>
    </c:forEach>
</table>

<div style="display: flex; justify-content: center;">
    <c:if test="${currentPage > 1}">
        <td><a class="btn btn-info" href="history?page=${currentPage - 1}">Previous</a></td>
    </c:if>
    <table>
        <thead class="thead-dark">
        <tr>
            <c:forEach begin="1" end="${numOfPages}" var="i">
                <c:choose>
                    <c:when test="${currentPage eq i}">
                        <td>
                            <div class="btn btn-secondary">${i}</div>
                        </td>
                    </c:when>
                    <c:otherwise>
                        <td><a class="btn btn-primary" href="history?page=${i}">${i}</a></td>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </tr>
        </thead>
    </table>
    <c:if test="${currentPage lt numOfPages}">
        <td><a class="btn btn-info" href="history?page=${currentPage + 1}">Next</a></td>
    </c:if>
</div>
</body>
</html>
