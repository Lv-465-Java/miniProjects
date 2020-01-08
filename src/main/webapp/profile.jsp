<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>

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
            <button type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#editUserInfo">
                <h2 id="profileName">
            <c:out value="${user.firstName}"></c:out>  <c:out value="${user.lastName}"></c:out></h2></button>
            <h3 id="profileEmail"><c:out value="${user.email}"></c:out></h3>
            <p class="reference" id="profilePassword" data-toggle="modal" data-target="#changePasswordModal">
            <a>Change password</a></p>

            <div class="profileCategories">
            <p class="reference" id="profileAddCategory" data-toggle="modal" data-target="#addCategory">
            <a>Add new category</a></p>

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
                                <th scope="row">${category.id}</th>
                                <td>${category.title}</td>
                                <td>${category.description}</td>
                                <td>
                                    <button type="button" class="btn btn-outline-warning" <a href="${pageContext.request.contextPath}/EmployeeController?action=/edit&id=${category.id}">Edit</button>
                                    <button type="button" class="btn btn-outline-danger">Delete</button>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>

    <div class="modal fade" id="editUserInfo" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
            <div class="modal-dialog modal-dialog-centered" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLongTitle">Edit your info</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>

                    <div class="modal-body">
                        <form method="post" action="<c:url value="edit-user"/>">
                            <label for="Firstname" class="floatLabel">First name<span class="asterisk">*</span></label>
                            <input id="Firstname" name="first_name" type="text" required value=<c:out value="${user.firstName}">
                            </c:out>>
                            <label for="Lastname" class="floatLabel">Last name<span class="asterisk">*</span></label>
                            <input id="Lastname" name="last_name" type="text" required value=<c:out value="${user.lastName}">
                            </c:out>>

                            <div class="modal-footer">
                                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                                <input type="submit" class="btn btn-primary" value="Save changes">
                            </div>
                        </form>
                    </div>
                </div>
            </div>
    </div>

    <div class="modal fade" id="changePasswordModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
                <div class="modal-dialog modal-dialog-centered" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="exampleModalLongTitle">Change password</h5>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>

                        <div class="modal-body">
                            <form action="change-user-password" method="post">
                                <label for="Current Password" class="floatLabel">Current Password<span class="asterisk">*</span></label>
                                <input id="CurrentPassword" name="current_password" type="password" required>
                                <label for="NewPassword" class="floatLabel">New Password<span class="asterisk">*</span></label>
                                <input id="New Password" name="new_password" type="password" required>
                                <label for="ConfirmPassword" class="floatLabel">Confirm Password<span class="asterisk">*</span></label>
                                <input id="Confirm Password" name="confirm_password" type="password" required>

                                <c:if test="${not empty errors}">
                                    <p class="reference" id="errorChangePassword">${errors}</p>
                                </c:if>

                                <div class="modal-footer">
                                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                                    <input type="submit" class="btn btn-primary" value="Save changes">
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
    </div>

    <div class="modal fade" id="addCategory" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
                <div class="modal-dialog modal-dialog-centered" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="exampleModalLongTitle">Add new category</h5>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>

                        <div class="modal-body">
                            <form method="post" action="<c:url value="add-category"/>">
                                <label for="Title" class="floatLabel">Title<span class="asterisk">*</span></label>
                                <input id="title" name="title" type="text" required>
                                <label for="Color" class="floatLabel">Color</label>
                                <input id="color" name="color" type="text">
                                <label for="Description" class="floatLabel">Description</label>
                                <input id="description" name="description" type="text">

                        <label for="financial-type">Financial Type<span class="asterisk">*</span></label>
                        <select class="browser-default custom-select" id="financial-type" name="type">
                            <c:forEach var="type" items="${types}">
                                <option value="${type}">${type.id}</option>
                            </c:forEach>
                        </select>

                        <label for="financial-type">Financial Type</label>
                          <select class="browser-default custom-select" id="financial-type" name="type">
                            <option id="option-0" value="NONE" selected>Financial type...</option>
                            <option id="option-1" value="INCOME">Income</option>
                            <option id="option-2" value="OUTCOME">Outcome</option>
                          </select>

                                <div class="modal-footer">
                                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                                    <input type="submit" class="btn btn-primary" value="Save changes">
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>

</body>
</html>