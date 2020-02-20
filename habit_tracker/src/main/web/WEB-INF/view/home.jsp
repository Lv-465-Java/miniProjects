<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: maric
  Date: 1/4/2020
  Time: 1:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="http://localhost:8080/habit_tracker/css/style.css">
    <script>
        function record_habit(event, habitId){
            jQuery.get("${pageContext.request.contextPath}/do_habit/${habitId}", event.checked);
        }

        async function checkIfHabitDone(habitId) {
            return await jQuery.get(`/habit/check_if_habit_done/${habitId}`).data.status;
        }
    </script>
</head>
<body>
<jsp:include page="/WEB-INF/view/header.jsp"></jsp:include>
<%--    <div class="navbar navbar-inverse navbar-static-top">--%>
<%--        <div class="container">--%>
<%--            <a href="<c:url value="/home"/>" class="navbar-brand">Home</a>--%>
<%--            <a class="navbar-brand" href="<c:url value="/create_habit"/>" onclick="ga('send', 'event', 'Navbar', 'Community links', 'Themes');" target="_blank" rel="noopener"> Create habit</a>--%>
<%--            <a class="navbar-brand" href="<c:url value="/delete_user"/>" >Delete user</a>--%>
<%--            <a class="navbar-brand" href="<c:url value="/logout"/>">Log out</a>--%>
<%--            <button class="navbar-toggle" data-toggle="collapse" data-target=".navHeaderCollapse">--%>
<%--                <span class="icon-bar"></span>--%>
<%--                <span class="icon-bar"></span>--%>
<%--                <span class="icon-bar"></span>--%>
<%--            </button>--%>
<%--            <div class="collapse navbar-collapse navHeaderCollapse">--%>
<%--                <ul class="nav navbar-nav navbar-right text-center">--%>
<%--                    <li class="active"><a href="#">prvo</a></li>--%>
<%--                    <li calass="dropdown">--%>
<%--                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">Socijalno <b class="caret"></b></a>--%>
<%--                        <ul class="dropdown-menu">--%>
<%--                            <li><a href="">facebook</a></li>--%>
<%--                            <li><a href="">google+</a></li>--%>
<%--                            <li><a href="">instagram</a></li>--%>
<%--                        </ul>--%>
<%--                    </li>--%>
<%--                    <li><a href="#">trece</a></li>--%>
<%--                </ul>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--</div>--%>

<div class="row">

<jsp:include page='bar.jsp'>
        <jsp:param name="all_habits" value="${all_habits}"/>
        <jsp:param name="name" value="${name}"/>
    </jsp:include>

<%--<div class="col-sm-4" id="sidebar">--%>
<%--    <aside class="aside">--%>
<%--        <header class="primary-header" role="banner">--%>
<%--<h1 class="primary-logo"><c:out value="${name}"/></h1>--%>
<%--        </header>--%>
<%--<c:forEach var="habit" items="${all_habits}">--%>
<%--    <div class="habit-one-line">--%>
<%--    <a href="<c:url value="/habit/${habit.id}"/>"> <h4><c:out value="${habit.name}"/></h4></a>--%>
<%--    <input type="checkbox" class="checkbox-class" <c:if test="${habit.isDoneToday=='true'}"> checked</c:if>--%>
<%--           onchange=window.location.href="http://localhost:8080/habit_tracker/do_habit/${habit.id}">--%>
<%--    </div>--%>
<%--</c:forEach>--%>
<%--    </aside>--%>
<%--</div>--%>
<div class="col-sm-8 main-content" >
    <c:if test="${error ne null}">
        <p class="text-center">
            <font color="red">${error}</font>
        </p>
    </c:if>
    <h3 class="mt-2">You have done your habits <span class="habit-counter">${all_amount}</span> times</h3>
    <table class="table table-bordered col-sm-8 habit-table">
        <thead>
            <tr>
                <th>Name</th>
                <th>Amount</th>
                <th>Strike</th>
            </tr>
        </thead>
        <tbody><c:forEach var="habit" items="${all_habits}">
            <tr class="habit-row">
                <td>${habit.name}</td>
                <td>${habit.do_date}</td>
                <td>${habit.habit_strike}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

</div>
</div>
</body>
</html>
