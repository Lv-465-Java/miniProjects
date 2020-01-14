<%--
  Created by IntelliJ IDEA.
  User: Marian
  Date: 04.01.2020
  Time: 18:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<header>
    <div class="menu-center">
        <a href="${pageContext.request.contextPath}"><img class="logo" alt="Logo" src="${pageContext.request.contextPath}/resources/images/logo.jpg"/></a>
        <nav class="menu-top">
            <ul>
                <c:if test="${!session}">
                <li><a href="${pageContext.request.contextPath}/login">Log in</a></li>
                <li><a href="${pageContext.request.contextPath}/registration">Sign up</a></li>
                </c:if>
                <c:if test="${session}">
                <li><a href="${pageContext.request.contextPath}/profile">My profile</a></li>
                <li><a href="${pageContext.request.contextPath}/logout">Log out</a></li>
                </c:if>
            </ul>

        </nav>
    </div>
</header>
