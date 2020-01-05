<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<head>
<title>My profile</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<link rel="stylesheet" href="resource/css/header.css">
<link rel="stylesheet" href="resource/css/profile.css">
</head>

<body>

    <div class="header container">
        <a>Profile</a>
        <a>Records</a>
        <a>Planned Outcomes</a>
        <a>Logout</a>
    </div>

    <div class="profileContainer">
        <div class="profileInfo">
            <h2 id="profileName"><c:out value="${user.firstName}"></c:out>  <c:out value="${user.lastName}"></c:out></h2>
            <h3 id="profileEmail"><c:out value="${user.email}"></c:out></h3>
            <p id="profilePassword">Change password</p>

            <div class="profileCategories">

                    <table class="table">
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
                                </tr>
                  </c:forEach>
                              </tbody>
                            </table>
             </div>
        </div>
    </div>
</body>
</html>