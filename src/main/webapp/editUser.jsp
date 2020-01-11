<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>

<head>
    <title>Edit user</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="resource/css/file.css">
    <link rel="stylesheet" href="resource/css/forms.css">
</head>

<body>
<jsp:include page="/header.jsp"/>

<div class="formsContainer">
    <div class="form-group">
        <form action="${pageContext.request.contextPath}/edit-user" method="post">
            <label for="firstName" class="floatLabel">First name<span class="asterisk">*</span></label>
            <input id="firstName" name="first_name" type="text" required
                   value=
                   <%--@elvariable id="user" type="com.softserve.entity.User"--%>
                   <c:out value="${user.firstName}"> </c:out>>

            <label for="lastName" class="floatLabel">Last name<span class="asterisk">*</span></label>
            <input type="text" name="last_name" id="lastName" required
                   value=<c:out value="${user.lastName}"> </c:out>>
            <div class="form-footer">
                <button type="submit" class="btn btn-primary" id="mainPageButton2">Save changes</button>
            </div>
        </form>
        </form>
        <form action="${pageContext.request.contextPath}/profile" method="get">
            <button type="submit" class="btn btn-primary" id="mainPageButton">Cancel</button>
        </form>
    </div>

</div>

</body>