<%--suppress ELValidationInJSP --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html lang="en">

<head>
    <title>Sign In My-WALLET</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="resource/css/file.css">
</head>

<body>

<%--<div class="mainContainer">--%>

    <div class="signIn">
        <form autocomplete="on" action="${pageContext.request.contextPath}/login" method="post">
            <label for="Email" class="floatLabel">Email<span class="asterisk">*</span></label>
            <input id="Email" name="email" type="email" required>

            <label for="Password" class="floatLabel">Password<span class="asterisk">*</span></label>
            <input id="Password" name="password" type="password" required>

            <c:if test="${not empty error}">
                <p class="errorActionMessage" id="error">${error}</p>
            </c:if>

            <button type="submit" class="btn btn-primary" id="loginButton">Sign In</button>
        </form>

        <p class="referenceToAction">Do not have an account? <a href="${pageContext.request.contextPath}/register">Sign
            up</a>
        </p>
    </div>

    <div class="whySign">
        <h1>Welcome to MY-WALLET</h1>
        <p>Understanding your cash flow is a major part of successfully managing your finances. How much is coming in,
            when it hits your bank account, and where it is going are all important aspects of financial success.
            <br>
            <br>Luckily, the MY-WALLET management app is designed to help you see your bank balance, track your
            spending, and analyze your habits. Moreover, such analysis will help you make better financial decisions,
            based on the data gathered from your accounts.
            <br>
            <br> Do not hesitate and start your well-planned financial life with us today.</p>
    </div>
<%--</div>--%>

</body>

</html>