<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: int
  Date: 10.01.20
  Time: 19:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>BootStrap</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/mainPage.css"/>

    <header class="page-header header container-fluid">
        <div class="row">
            <div class="col-md-4">
                <h1>Trip Planner</h1>
            </div>
            <div class="col-md-4">
                <img alt="logo" src="${pageContext.request.contextPath}/images/timetotravel.jpg" height="100" width="225"/>
            </div>
            <div class="col-md-4">
                <form name="search" action="${pageContext.request.contextPath}/searchPlaceByTemplate" method="post" class="form-inline form-search pull-right">
                    <div class="input-group">
                        <label class="sr-only" for="searchInput">Search</label>
                        <input class="form-control" id="searchInput" type="text" name="search" placeholder="Search place by template">
                        <div class="input-group-btn">
                            <button type="submit" class="btn btn-primary">GO</button>
                        </div>
                    </div>
                </form>
                <c:if test="${not empty error}">
                    <c:out value="${error}"/>
                </c:if>
            </div>
        </div>
    </header>

