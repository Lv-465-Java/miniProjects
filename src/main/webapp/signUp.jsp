<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
<head>
<title>Sign Up in My-WALLET</title>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<link rel="stylesheet" href=<c:url value="resource/css/sign.css"></c:url>>
</head>

<body>
    <div id="container">
           <div class="signUp">
            <form>
                <label for="Firstname" class="floatLabel">First name</label>
                 <input id="Firstname" name="Firstname" type="text">
                 <label for="Lastname" class="floatLabel">Last name</label>
                 <input id="Lastname" name="Lastname" type="text">
                 <label for="Email" class="floatLabel">Email</label>
                 <input id="Email" name="Email" type="text">
                 <label for="Password" class="floatLabel">Password</label>
                 <input id="Password" name="Password" type="password">
                 <button type="button" class="btn btn-primary" id="pointer">Sign Up</button>
                </form>
           <p id="referenceToSignUp">Already existing user? <a href="login.jsp">Sign in</a></p>
        </div>

        <div class="whysignUp">
          <h1>Welcome to MY-WALLET</h1>
          <p>Understanding your cash flow is a major part of successfully managing your finances. How much is coming in, when it hits your bank account, and where it’s going are all important aspects of financial success.
          <br>Luckily, the MY-WALLET management app is designed to help you see your bank balance, track your spending, and analyze your habits. Moreover, such analysis will help you make better financial decisions, based on the data gathered from your accounts.
          <br> Do not hesitate and start your well-planned financial life with us today.</p>
        </div>
      </div>

</body>
</html>