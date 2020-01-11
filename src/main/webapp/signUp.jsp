<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <title>Sign Up in My-WALLET</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <link rel="stylesheet" href=<c:url value="resource/css/file.css">
    </c:url>>
</head>

<body>
<div class="mainContainer">
    <div class="signUp">
        <form autocomplete="on" method="post">
            <label for="firstName" class="floatLabel">First name<span class="asterisk">*</span></label>
            <input id="firstName" name="first_name" type="text" required>
            <label for="lastName" class="floatLabel">Last name<span class="asterisk">*</span></label>
            <input id="lastName" name="last_name" type="text" required>
            <label for="Email" class="floatLabel">Email<span class="asterisk">*</span></label>
            <input id="Email" name="email" type="email" required>
            <label for="Password" class="floatLabel">Password<span class="asterisk">*</span></label>
            <input id="Password" name="password" type="password" required>

            <c:if test="${not empty error}">
                <p class="reference" id="error">${error}</p>
            </c:if>

            <input type="submit" class="btn btn-primary" id="mainPageButton" value="Sign Up">
        </form>
        <p class="reference">Already existing user? <a href="login">Sign in</a></p>
    </div>

    <div class="whySignUp">
        <h1>Welcome to MY-WALLET</h1>
        <p>Understanding your cash flow is a major part of successfully managing your finances. How much is coming in,
            when it hits your bank account, and where it is going are all important aspects of financial success.
            <br>
            <br>Luckily, the MY-WALLET management app is designed to help you see your bank balance, track your
            spending, and analyze your habits. Moreover, such analysis will help you make better financial decisions,
            based on the data gathered from your accounts.
            <br>
            <br>Do not hesitate and start your well-planned financial life with us today.</p>
    </div>
</div>

</body>

</html>