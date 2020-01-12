<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: int
  Date: 10.01.20
  Time: 22:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>Edit Comment</title>
    <link rel="stylesheet" type="text/css" href="../../css/login.css"/>
</head>
<body>
<c:if test="${not empty comment}">
    <form method="POST" action="${pageContext.request.contextPath}/editComment">
    <input type="hidden" name="id" value="${comment.id}" />
<div class="login-wrap">
    <div class="login-html">
        <input id="tab-2" type="radio" name="tab" class="sign-up"><label for="tab-2" class="tab">Edit Comment</label>
        <div class="login-form">
            <div class="sign-up-htm">
                <form action="${pageContext.request.contextPath}/editComment" method="post">
                    <div class="group">
                        <label for="place" class="label">Choose place</label>



                        <select  name="place">       <!----place_id -->
                            <option value="" selected>Italy</option>
                            <option value="">Germany</option>
                            <option value="">Tokyo</option>
                        </select>
                        <!--  <input id="first" type="text" class="input" required> -->
                    </div>
                    <div class="group">
                        <label for="text" class="label">Text of comment</label>
                        <textarea id="text" name="text_of_comment" cols="60" rows="4">${comment.text_of_comment}</textarea>
                        <!-- <input id="text" type="texta" class="input" required> -->
                    </div>


                    <div class="group">
                        <input type="submit" class="button" value="Edit">
                    </div>
                    <div class="group">
                        <a href="${pageContext.request.contextPath}/mainPage">
                            <input type="submit" class="button" value="Cancel">
                        </a>
                    </div>
                    <div class="hr"></div>
                </form>
            </div>
        </div>
    </div>
</div>
        </c:if>
</body>
</html>
