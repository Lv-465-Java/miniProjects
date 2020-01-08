<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%--<c:set var="hostUrl">${pageContext.request.requestURL}</c:set>--%>
<%--<c:set var="hostUri">${pageContext.request.requestURI}</c:set>--%>
<%--<c:set var="hostContext" value="${fn:substring(hostUrl, 0, fn:length(hostUrl) - fn:length(hostUri))}${pageContext.request.contextPath}" />--%>
<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2020-01-08
  Time: 12:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>

</head>
<body>
<h1>Login</h1>
<c:if test="${not empty error}">
    <p>
        <span style="color: red; ">${error}</span>
    </p>
</c:if>
<br><br>
<form  method="post">
    Login: <input type="text" name="nickname">
    <br><br>
    Password: <input type="password" name="password">
    <br><br>
    <input type="submit" name="submit" value="Signin"> <br>
</form>
</body>
</html>
