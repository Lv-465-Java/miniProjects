<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2020-01-14
  Time: 04:27
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Shopping Cart</title>
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.11.2/css/all.css">
    <!-- Bootstrap core CSS -->
    <link rel="stylesheet" href="static/css/bootstrap.min.css">
    <link rel="stylesheet"
          href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.4.1/js/bootstrap.bundle.min.js">
    <link rel="stylesheet" href="static/css/shopping-cart.css">
    <script type="text/javascript" src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
            integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
            crossorigin="anonymous"></script>
</head>
<body>
<div class="px-4 px-lg-0">
    <div class="container text-white py-5 text-center">
        <h1 class="display-4">Online Shop Cart</h1>
        <h4>Nickname: ${pageContext.session.getAttribute("userDto").nickname}</h4>
    </div>

    <div class="pb-5">
        <div class="container">
            <div class="row">
                <div class="col-lg-12 p-5 bg-white rounded shadow-sm mb-5">

                    <!-- Shopping cart table -->
                    <div class="table-responsive">
                        <table class="table">
                            <thead>
                            <tr>
                                <th scope="col" class="border-0 bg-light">
                                    <div class="p-2 px-3 text-uppercase">Product</div>
                                </th>
                                <th scope="col" class="border-0 bg-light">
                                    <div class="py-2 text-uppercase">Price</div>
                                </th>
                                <th scope="col" class="border-0 bg-light">
                                    <div class="py-2 text-uppercase">Date of Purchase</div>
                                </th>
                                <th scope="col" class="border-0 bg-light">
                                    <div class="py-2 text-uppercase">Buy</div>
                                </th>
                                <th scope="col" class="border-0 bg-light">
                                    <div class="py-2 text-uppercase">Remove</div>
                                </th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="cartElement" items="${cartElements}">
                                <c:forEach var="producer" items="${producers}">
                                    <c:forEach var="model" items="${models}">
                                        <c:forEach var="phone" items="${phones}">
                                            <c:choose>
                                                <c:when test="${producer.id == model.producerId &&
                                                model.id == phone.modelId && cartElement.phoneId == phone.id}">
                                                    <tr>
                                                        <th scope="row" class="border-0">
                                                            <div class="p-2">
                                                                <img src="${pageContext.request.contextPath}/static/images/${phone.photo}"
                                                                     alt="" width="70"
                                                                     class="img-fluid rounded shadow-sm">
                                                                <div class="ml-3 d-inline-block align-middle">
                                                                    <h5 class="mb-0"><a href="#"
                                                                                        class="text-dark d-inline-block align-middle">${model.name}</a>
                                                                    </h5><span
                                                                        class="text-muted font-weight-normal font-italic d-block">Producer: ${producer.name}</span>
                                                                </div>
                                                            </div>
                                                        </th>
                                                        <td class="border-0 align-middle">
                                                            <strong>${phone.price}$</strong></td>
                                                        <td class="border-0 align-middle">
                                                            <strong>${cartElement.dateOfBuying}</strong></td>
                                                        <form action="${pageContext.request.contextPath}/update-cart"
                                                              method="post">
                                                            <td class="border-0 align-middle">
                                                                <button name="update" value="${cartElement.phoneId}"
                                                                        class="btn blue-gradient btn-md">UPDATE
                                                                </button>
                                                            </td>
                                                        </form>
                                                        <form action="${pageContext.request.contextPath}/delete-cart"
                                                              method="post">
                                                            <td class="border-0 align-middle">
                                                                <button name="phoneId" value="${cartElement.phoneId}"
                                                                        class="btn blue-gradient btn-md">DELETE
                                                                </button>
                                                            </td>
                                                        </form>
                                                    </tr>
                                                </c:when>
                                            </c:choose>
                                        </c:forEach>
                                    </c:forEach>
                                </c:forEach>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
