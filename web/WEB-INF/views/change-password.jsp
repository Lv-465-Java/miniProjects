<%--
  Created by IntelliJ IDEA.
  User: arch
  Date: 10.01.20
  Time: 23:19
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
    <title>Edit</title>
</head>
<body>
<jsp:include page="fragments/header.jsp"/>
<div class="row justify-content-center">
    <div class="col-12 col-md-10 col-lg-8">
        <form action="${pageContext.request.contextPath}/change-password" method="post">
            <div class="form-group row">
                <label for="oldPassword" class="col-sm-2 col-form-label">Old password</label>
                <div class="col-sm-10">
                    <input class="form-control" type="password" id="oldPassword"
                           name="oldPassword" placeholder="Password">
                </div>
            </div>
            <div class="form-group row">
                <label for="newPassword" class="col-sm-2 col-form-label">New password</label>
                <div class="col-sm-10">
                    <input class="form-control" type="password" id="newPassword"
                           name="newPassword" placeholder="Password">
                </div>
            </div>
            <div class="form-group row">
                <label for="repeatPassword" class="col-sm-2 col-form-label">Repeat password</label>
                <div class="col-sm-10">
                    <input class="form-control" type="password" id="repeatPassword"
                           name="repeatPassword" placeholder="Password">
                </div>
            </div>
            <div class="row justify-content-center">
                <button type="submit" name="confirm" class="btn btn-success btn-lg">Confirm</button>
                <button type="button" class="btn btn-light btn-lg" disabled></button>
                <button type="submit" class="btn btn-primary btn-lg" name="cancel" value="cancel">Cancel</button>
            </div>
        </form>
    </div>
</div>
</body>
</html>
