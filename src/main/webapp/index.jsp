<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2020-01-12
  Time: 18:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Online Shop</title>
</head>
<body>
<div class="limiter">
    <div class="container-login100">
        <div class="wrap-login100">
            <div class="login100-form-title">
					<span class="login100-form-title-1">
						To Do List
					</span>
            </div>

            <form class="login100-form validate-form action=" action="${pageContext.request.contextPath}/main" method="post">
                <input class="inputS" type="submit" name="submitLogin" value="Sign in"> <br>
                <input class="inputS" type="submit" name="submitRegistration" value="Sign up"> <br>
            </form>

        </div>
    </div>
</div>
</body>
</html>
