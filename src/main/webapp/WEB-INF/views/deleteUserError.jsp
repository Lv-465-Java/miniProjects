<%--
  Created by IntelliJ IDEA.
  User: int
  Date: 08.01.20
  Time: 20:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete User</title>
</head>
<body>
<%--<jsp:include page="_header.jsp"></jsp:include>--%>
<%--<jsp:include page="_menu.jsp"></jsp:include>--%>

<h3>Delete User</h3>

<p style="color: red;">${error}</p>
<a href="${pageContext.request.contextPath}/userList">User List</a>

<%--<jsp:include page="_footer.jsp"></jsp:include>--%>
</body>
</html>
