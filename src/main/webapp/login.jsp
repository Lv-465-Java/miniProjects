<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
<head>
<title>Sign In My-WALLET</title>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<link rel="stylesheet" href=<c:url value="resource/css/sign.css"></c:url>>
</head>

<body>
    <div id="container">
           <div class="signIn">
            <form method="post">
                 <label for="email" class="floatLabel">Email</label>
                 <input id="Email" name="email" type="text">
                 <label for="password" class="floatLabel">Password</label>
                 <input id="Password" name="password" type="password">
                 <input type="submit" class="btn btn-primary" id="pointer">Sign In</button>
            </form>

           <p id="referenceToSignIn">Do not have an account? <a href="signUp.jsp">Sign up</a></p>
        </div>

        <div class="whysignIn">
          <h1>Welcome to MY-WALLET</h1>
          <p>Understanding your cash flow is a major part of successfully managing your finances. How much is coming in, when it hits your bank account, and where it’s going are all important aspects of financial success.
          <br>Luckily, the MY-WALLET management app is designed to help you see your bank balance, track your spending, and analyze your habits. Moreover, such analysis will help you make better financial decisions, based on the data gathered from your accounts.
          <br> Do not hesitate and start your well-planned financial life with us today.</p>
        </div>
      </div>

</body>
</html>