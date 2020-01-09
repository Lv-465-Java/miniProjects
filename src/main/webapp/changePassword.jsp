<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ page contentType="text/html;charset=UTF-8" language="java" %>

        <!DOCTYPE html>

        <head>
            <title>Change password</title>
            <meta charset="utf-8">
            <meta name="viewport" content="width=device-width, initial-scale=1">
            <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
            <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
            <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
            <link rel="stylesheet" href="resource/css/file.css">
        </head>

        <body>

            <form action="change-user-password" method="post">

                <div class="form-header">
                    <h5 class="form-title" name="changePasswordTitle">Change password</h5>
                    <button type="button" class="close" aria-label="Close">
                        <span aria-hidden="true">&times;</span></button>
                </div>

                <div class="form-group" id="all-forms">
                    <label for="Current Password" class="floatLabel">Current Password<span class="asterisk">*</span></label>
                    <input id="CurrentPassword" name="current_password" type="password" required>
                </div>
                <label for="NewPassword" class="floatLabel">New Password<span class="asterisk">*</span></label>
                <input id="New Password" name="new_password" type="password" required>
                <div class="form-group" id="all-forms">
                    <label for="ConfirmPassword" class="floatLabel">Confirm Password<span class="asterisk">*</span></label>
                    <input id="Confirm Password" name="confirm_password" type="password" required>
                </div>
                <div class="form-group" id="all-forms">
                    <c:if test="${not empty errors}">
                        <p class="reference" id="errorChangePassword">${errors}</p>
                    </c:if>
                </div>
                <div class="form-footer">
                    <button type="button" class="btn btn-secondary" value="Close"></button>
                    <input type="submit" class="btn btn-primary" value="Save changes"></input>
                </div>
            </form>
        </body>