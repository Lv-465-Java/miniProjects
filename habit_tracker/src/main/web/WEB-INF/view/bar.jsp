<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: maric
  Date: 1/14/2020
  Time: 12:22 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">`
   <link rel="stylesheet" type="text/css" href="http://localhost:8080/habit_tracker/css/style.css">
</head>
<body>
<%--<div  id="sidebar">--%>
<div class="col-sm-3" id="sidebar">
    <%String all_habits = request.getParameter("all_habits");%>
    <%String name = request.getParameter("name");%>
    <aside class="aside">
        <header class="primary-header" role="banner">
            <a href="<c:url value="/home"/>" class="primary-logo"><c:out value="${name}"/></a>
        </header>
        <c:forEach var="habit" items="${all_habits}">
            <div class="habit-one-line">
                <a href="<c:url value="/habit/${habit.id}"/>"> <h4><c:out value="${habit.name}"/></h4></a>
                <input type="checkbox" class="checkbox-class" <c:if test="${habit.isDoneToday=='true'}"> checked</c:if>
                       onchange=window.location.href="http://localhost:8080/habit_tracker/do_habit/${habit.id}">
            </div>
        </c:forEach>
    </aside>
</div>
<%--</div>--%>
</body>
</html>
