<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2020-01-14
  Time: 03:18
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <title>Product Page</title>
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.11.2/css/all.css">
    <link rel="stylesheet" href="static/css/bootstrap.min.css">
    <link rel="stylesheet" href="static/css/mdb.min.css">
    <link rel="stylesheet" href="static/css/style.css">
</head>
<body>
<jsp:include page="/fragments/home-header.jsp"/>

<main class="mt-5 pt-4">
<%--    <form action="${pageContext.request.contextPath}/product-page">--%>

        <div class="container dark-gray-text mt-5">
            <div class="row wow fadeIn">
                <div class="col-md-6 mb-4">
                    <img src="${pageContext.request.contextPath}/static/images/${phoneDto.photo}"
                         class="img-fluid">
                </div>
                <div class="col-md-6 mb-4">
                    <div class="p-4">
                        <div class="mb-3">
                            <a id="modelId" href="">
                                <span class="badge purple mr-1">Category</span>
                            </a>
                            <a href="">
                                <span class="badge blue mr-1">New</span>
                            </a>
                            <a href="">
                                <span class="badge red mr-1">Bestseller</span>
                            </a>
                        </div>
                        <h4>
                            <span class="badge purple mr-1">${producerDto.name}</span>
                            <span class="badge purple mr-1">${modelDto.name}</span>
                        </h4>
                        <p class="lead font-weight-bold">Price</p>
                        <p class="lead">
                        <span class="mr-1">
                            <del>1500</del>
                        </span>
                            <span id="price" class="mr-1">
                            <span>${phoneDto.price}$</span>
                        </span>
                        </p>
                        <p class="lead font-weight-bold">Year</p>
                        <div>
                            <p class="lead">${phoneDto.year}</p>
                        </div>
                        <p class="lead font-weight-bold">Color</p>
                        <div>
                            <p id="color" class="lead">${phoneDto.color}</p>
                        </div>
                        <p class="lead font-weight-bold">Screen Diagonal</p>
                        <div>
                            <p></p>
                            <p id="screenDiagonal" class="lead">${phoneDto.screenDiagonal} Gb</p>
                        </div>
                        <p class="lead font-weight-bold">Internal Memory</p>
                        <div>
                            <p id="internalMemory" class="lead">${phoneDto.internalMemory} Gb</p>
                        </div>

                        <p class="lead font-weight-bold">Description</p>
                        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Animi, atque dolorem fugit hic
                            ipsum
                            iste itaque laboriosam maxime, minima molestiae, neque omnis quae quidem quod repudiandae
                            sed
                            totam.
                        </p>

                        <form action="${pageContext.request.contextPath}/product-page" method="post" class="d-flex justify-content-left">
                            <input type="hidden" name="phoneId" value="${phoneDto.id}">
<%--                            <a href="/shopping-cart">--%>
<%--                            <a href="/shopping-cart?phoneId=${phoneDto.id}">--%>
                                <button name="userId" type="submit" class="btn btn-primary btn-md my-0 p" value="${userDto.id}">
                                    Add to cart <i class="fa fa-shopping-cart ml-1"></i>
                                </button>
<%--                            </a>--%>
                        </form>
                        <c:if test="${not empty error}">
                            <div class="alert alert-info">
                                    ${error}
                            </div>
                        </c:if>
                        <c:if test="${not empty success}">
                            <div class="alert alert-success">
                                    ${success}
                            </div>
                        </c:if>
                    </div>
                </div>
            </div>
            <hr>
            <div class="row display-flex justify-content-center wow fadeIn">
                <div class="col-md-6 text-center">
                    <h4 class="my-4 h4">Additional information</h4>
                    <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Accusamus amet animi corporis dolore
                        dolores ea eos est facilis, ipsa ipsam placeat qui quibusdam sapiente sint soluta suscipit ullam
                        unde voluptatum.</p>
                </div>
            </div>
            <div class="row wow fadeIn">
                <div class="col-lg-4 col-md-12 mb-4">
                    <img src="https://wallpaperaccess.com/full/1174935.jpg" alt="" class="img-fluid">
                </div>
                <div class="col-lg-4 col-md-12 mb-4">
                    <img src="https://images.wallpaperscraft.ru/image/basketbol_paren_forma_nadpis_nike_reklama_11518_1280x720.jpg"
                         alt="" class="img-fluid">
                </div>
                <div class="col-lg-4 col-md-12 mb-4">
                    <img src="https://i.ytimg.com/vi/6fwKAwenjjY/maxresdefault.jpg" alt="" class="img-fluid">
                </div>
            </div>
        </div>
<%--    </form>--%>
</main>
<jsp:include page="/fragments/footer.jsp"/>


<script type="text/javascript" src="static/js/jquery.min.js"></script>
<script type="text/javascript" src="static/js/popper.min.js"></script>
<script type="text/javascript" src="static/js/bootstrap.min.js"></script>
<script type="text/javascript" src="static/js/mdb.min.js"></script>
<script type="text/javascript"></script>
</body>
</html>
