<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2020-01-12
  Time: 20:45
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<table class="table table-dark">
    <thead class="thead-dark">
    <tr>
        <td>ID</td>
        <td>Name</td>
        <td>Actions <a class="btn-add btn-floating btn-large waves-effect waves-light "><i class="material-icons">+</i></a></td>
    </tr>
    </thead>
    <tbody class="producer-container">

    <c:forEach var="producer" items="${producersList}">
        <tr>
            <td>${producer.id}</td>
            <td>${producer.name}</td>
<%--            <td> <button data-id="${producer.id}" class="btn-white" >DELETE</button>--%>
<%--                <button data-id="${producer.id}" class="btn-white">UPDATE</button></td>--%>
        </tr>
    </c:forEach>
    </tbody>
</table>


</body>
</html>
