<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: int
  Date: 08.01.20
  Time: 19:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit User</title>
</head>
<body>
<%--<jsp:include page="_header.jsp"></jsp:include>--%>
<%--<jsp:include page="_menu.jsp"></jsp:include>--%>

<h3>Edit Product</h3>

<%--<p style="color: red;">${errorString}</p>--%>
<c:if test="${not empty user}">
    <form method="POST" action="${pageContext.request.contextPath}/editUser">
    <input type="hidden" name="id" value="${user.id}" />
<div class="login-wrap">
    <div class="login-html">
        <input id="tab-2" type="radio" name="tab" class="sign-up"><label for="tab-2" class="tab">Sign Up</label>
        <div class="login-form">
            <div class="sign-up-htm">
                <form action="<c:out value="/editUser"/>" method="post">
                    <div class="group">
                     <label for="id" class="label">Id</label>
                     <input id="id" type="hidden" class="input" value="${user.id}">
                     </div>
                    <div class="group">
                        <label for="first" class="label">First Name</label>
                        <input id="first" type="text" class="input" value="${user.first_name}">
                    </div>
                    <div class="group">
                        <label for="last" class="label">Last Name</label>
                        <input id="last" type="text" class="input" value="${user.last_name}">
                    </div>
                    <div class="group">
                        <label for="user" class="label">Username</label>
                        <input id="user" type="text" class="input" value="${user.username}">
                    </div>
                    <div class="group">
                        <label for="email" class="label">Email</label>
                        <input id="email" type="text" class="input" value="${user.email}">
                    </div>
                    <div class="group">
                        <label for="pass" class="label">Password</label>
                        <input id="pass" type="password" class="input" data-type="password" value="${user.password}">
                    </div>
                    <div class="group">
                        <label for="passw" class="label">Repeat Password</label>
                        <input id="passw" type="password" class="input" data-type="password" value="${user.password}">
                    </div>
                    <div class="group">
                        <input type="submit" class="button" value="Edit">
                    </div>
                    <div class="group">
                        <%--                    <form action="<c:out value="/login"/>" method="get">--%>
                        <a href="<c:out value="/userList"/>">
                            <input type="submit" class="button" value="Cancel">
                            <%--                    </form>--%>
                        </a>
                    </div>
                    <div class="hr"></div>
                </form>
                <c:if test="${not empty error}">
                    <c:out value="${error}"/>
                </c:if>
            </div>
        </div>
    </div>
</div>
</c:if>

<%--<jsp:include page="_footer.jsp"></jsp:include>--%>


</body>
</html>
