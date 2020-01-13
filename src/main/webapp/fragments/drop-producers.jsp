<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2020-01-12
  Time: 20:45
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="producer-dropdown">
    <select name="producers">
        <option selected disabled value="producer">Producer</option>
        <c:forEach items="${producers}" var="producer">
            <option value="${producer.name}">${producer.name}</option>
        </c:forEach>
    </select>
</div>


