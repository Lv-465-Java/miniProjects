<%--suppress ALL --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <title>My profile</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="resource/css/file.css">
</head>

<body>
<jsp:include page="/header.jsp"/>

<div class="profileContainer">
    <div class="profileInfo">
        <div class="userInfo">
            <h2 id="profileName">
                <c:out value="${user.firstName}"> </c:out>
                <c:out value="${user.lastName}"> </c:out></h2>
            <h3 id="profileEmail"><c:out value="${user.email}"> </c:out></h3>
        </div>

        <div class="editUserButton">
            <form action="${pageContext.request.contextPath}/edit-user" method="get">
                <button type="submit" class="btn btn-primary">Edit User</button>
            </form>
            <form action="${pageContext.request.contextPath}/change-user-password" method="get">
                <button type="submit" class="btn btn-primary">Change password</button>
            </form>
        </div>

        <div class="profileCategories">
            <p class="reference" id="profileAddCategory"><a href="${pageContext.request.contextPath}/add-category">Add
                new category</a></p>

            <table class="table table-hover" id="profileTable">
                <thead>
                <tr>
                    <th scope="col"></th>
                    <th scope="col">Title</th>
                    <th scope="col">Description</th>
                </tr>
                </thead>
                <tbody>
                <%--@elvariable id="categories" type="java.util.List"--%>
                <c:forEach var="category" items="${categories}">
                    <tr>
                        <td>
                            <div class="color-holder call-picker" style="background-color: ${category.color}"></div>
                        </td>
                        <td>${category.title}</td>
                        <td>${category.description}</td>
                        <td>
                            <div class="form-group">

                                <form action="${pageContext.request.contextPath}/edit-category" method="get">
                                    <button type="submit" class="btn btn-warning" name="editCategoryButton"
                                            value="${category.id}">Edit
                                    </button>
                                </form>
                                <form action="${pageContext.request.contextPath}/delete-category" method="get">
                                    <button type="submit" class="btn btn-danger" name="buttonDelete"
                                            value="${category.id}">Delete
                                    </button>
                                </form>

                            </div>

                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
</body>

</html>