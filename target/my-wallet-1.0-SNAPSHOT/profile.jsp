<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
            <jsp:include page="/header.jsp" />

            <div class="profileContainer">
                <div class="profileInfo">
                        <h2 id="profileName">
                        <c:out value="${user.firstName}"></c:out>  <c:out value="${user.lastName}"></c:out></h2>
                        <button type="button" class="btn btn-info btn-lg" name="editUser"><a href="/edit-user">Edit User</a></button>
                    <h3 id="profileEmail"><c:out value="${user.email}"></c:out></h3>
                    <p class="reference" name="profilePassword"><a href="/change-user-password">Change password</a></p>

                    <div class="profileCategories">
                        <p class="reference" id="profileAddCategory"><a href="/add-category">Add new category</a></p>

                        <table class="table table-hover">
                            <thead>
                                <tr>
                                    <th scope="col">#</th>
                                    <th scope="col">Title</th>
                                    <th scope="col">Description</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="category" items="${categories}">
                                    <tr>
                                        <td>${category.id}</td>
                                        <td>${category.title}</td>
                                        <td>${category.description}</td>
                                        <td>
                                       <form action="/edit-category" method="get">
                                          <input type="submit" class="btn btn-outline-danger" name="buttonedit" value="${category.id}">Edit</input>
                                       </form>
                                      <form action="/delete-category" method="get">
                                          <input type="submit" class="btn btn-outline-danger" name="buttondelete" value="${category.id}">Delete</input>
                                      </form>
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