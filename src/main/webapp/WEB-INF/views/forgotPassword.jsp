<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: int
  Date: 08.01.20
  Time: 16:40
  To change this template use File | Settings | File Templates.
--%>


<%--    <form id="resetForm" action="reset_password" method="post">--%>
<%--        <table>--%>
<%--            <tr>--%>
<%--                <td>Email:</td>--%>
<%--                <td><input type="text" name="email" id="email" size="20"></td>--%>
<%--            </tr>--%>
<%--            <tr>--%>
<%--                <td colspan="2" align="center">--%>
<%--                    <button type="submit">Send me new password</button>--%>
<%--                </td>--%>
<%--            </tr>--%>
<%--        </table>--%>
<%--    </form>--%>
<%--</div>--%>

<%--<jsp:directive.include file="footer.jsp" />--%>

<%--<script type="text/javascript">--%>

<%--    $(document).ready(function() {--%>
<%--        $("#resetForm").validate({--%>
<%--            rules: {--%>
<%--                email: {--%>
<%--                    required: true,--%>
<%--                    email: true--%>
<%--                }--%>
<%--            },--%>

<%--            messages: {--%>
<%--                email: {--%>
<%--                    required: "Please enter email",--%>
<%--                    email: "Please enter a valid email address"--%>
<%--                }--%>
<%--            }--%>
<%--        });--%>

<%--    });--%>
<%--</script>--%>
<%--</body>--%>
<%--</html>--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Send an e-mail</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}././css/login.css"/>
</head>
<body>
<div class="login-wrap">
    <div class="login-html">
        <input id="tab-2" type="radio" name="tab" class="sign-up"><label for="tab-2" class="tab">Send New E-mail</label>
        <div class="login-form">
            <div class="sign-up-htm">
                <form action="${pageContext.request.contextPath}/forgotPassword" method="post">
                    <div class="group">
                        <label for="recipient_address" class="label">Recipient address</label>
                        <input id="recipient_address" name="recipient_address" type="text" class="input" required>
                    </div>
                    <div class="group">
                        <label for="subject" class="label">Subject</label>
                        <input id="subject" name="subject" type="text" class="input" required>
                    </div>
                    <div class="group">
                        <label for="content" class="label">Content</label>
                        <textarea id="content" name="content" cols="60" rows="4" >Enter a context...</textarea>
                    </div>
                    <div class="group">
                        <input type="submit" class="button" value="Send">
                    </div>
                    <div class="group">
                        <a href="${pageContext.request.contextPath}/login">
                            <input type="submit" class="button" value="Cancel">
                        </a>
                    </div>
                    <div class="hr"></div>
                </form>
<%--                ${message}--%>
            </div>
        </div>
    </div>
</div>

</body>
</html>