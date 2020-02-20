<%--
  Created by IntelliJ IDEA.
  User: maric
  Date: 1/3/2020
  Time: 10:40 AM
  To change this template use File | Settings | File Templates.
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" isELIgnored="false" %>
<!DOCTYPE html>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>--%>
<%--<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>--%>
<%--<c:set var="hostUrl">${pageContext.request.requestURL}</c:set>--%>
<%--<c:set var="hostUri">${pageContext.request.requestURI}</c:set>--%>
<%--<c:set var="hostContext" value="${fn:substring(hostUrl, 0, fn:length(hostUrl) - fn:length(hostUri))}${pageContext.request.contextPath}" />--%>
<html>
<head>
    <title>Login</title>
    <link rel="stylesheet" type="text/css" href="./css/style.css">
</head>
<body>
<div class="wrapper fadeInDown">
    <div id="formContent">
        <form action="login" method="POST">
            <h1>Welcome</h1>
            <br>
            <div>
                <font color="red">
                <c:forEach var="configParams" items="${messages}">
                    <c:if test="${configParams.key=='loginVal'}">
                        <c:out value="${configParams.value}" />
                    </c:if>
                </c:forEach>
                </font>
            </div>
            <div>
                <font color="red">
                    <c:forEach var="configParams" items="${messages}">
                        <c:if test="${configParams.key=='login'}">
                            <c:out value="${configParams.value}" />
                        </c:if>
                    </c:forEach>
                </font>
            </div>
            <input type="text" id="login" class="fadeIn second" name="login" placeholder="login">
            <div>
                <font color="red">
                    <c:forEach var="configParams" items="${messages}">
                        <c:if test="${configParams.key=='password'}">
                            <c:out value="${configParams.value}" />
                        </c:if>
                    </c:forEach>
                </font>
            </div>
            <input type="password" id="password" class="fadeIn third" name="password"  placeholder="password">
            <input type="submit" class="fadeIn fourth" value="Login">
        </form>
        <div id="formFooter">
            <p>Don't have an account? <a href="<c:url value="/signup"/>" class="underlineHover">Sign up</a> </p>
        </div>

    </div>
</div>
</body>
</html>
