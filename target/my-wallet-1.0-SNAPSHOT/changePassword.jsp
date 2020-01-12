<%--suppress ELValidationInJSP --%>
<%--suppress ELValidationInJSP --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <title>Change password</title>
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
    <div class="form-header">
        <h3 class="form-title">Change Password</h3>
    </div>
    <div class="form-group">
        <form action="${pageContext.request.contextPath}/change-user-password" method="post">

            <label for="CurrentPassword" class="floatLabel">Current Password<span class="asterisk">*</span></label>
            <input id="CurrentPassword" name="current_password" type="password" required>

            <label for="NewPassword" class="floatLabel">New Password<span class="asterisk">*</span></label>
            <input id="NewPassword" name="new_password" type="password" required>

            <label for="ConfirmPassword" class="floatLabel">Confirm Password<span class="asterisk">*</span></label>
            <input id="ConfirmPassword" name="confirm_password" type="password" required>


            <div class="form-footer">
                <button type="submit" class="btn btn-primary" id="formSaveButton">Save</button>
            </div>
        </form>
        <form action="${pageContext.request.contextPath}/profile" method="get">
            <button type="submit" class="btn btn-secondary" id="formCancelButton">Cancel
            </button>
        </form>
        <div class="form-group" id="all-forms">
            <c:if test="${not empty errors}">
                <p class="reference" id="errorChangePassword">${errors}</p>
            </c:if>
        </div>
    </div>
</div>

</body>
</html>