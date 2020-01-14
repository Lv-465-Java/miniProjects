<%--<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>--%>
<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2020-01-08
  Time: 14:35
  To change this template use File | Settings | File Templates.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <title>Online Shop</title>
    <!-- MDB icon -->
    <!--    <link rel="icon" href="img/mdb-favicon.ico" type="image/x-icon">-->
    <%--    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"--%>
    <%--          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">--%>
    <!-- Font Awesome -->
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.11.2/css/all.css">
    <!-- Bootstrap core CSS -->
    <link rel="stylesheet" href="static/css/bootstrap.min.css">
    <!-- Material Design Bootstrap -->
    <link rel="stylesheet" href="static/css/mdb.min.css">
    <!-- Your custom styles (optional) -->
    <link rel="stylesheet" href="static/css/style.css">
    <style>
        html,
        body,
        header,
        .carousel {
            height: 60vh;
        }

        @media (max-width: 740px) {
            html,
            body,
            header,
            .carousel {
                height: 100vh;
            }
        }

        @media (min-width: 800px) and (max-width: 850px) {
            html,
            body,
            header,
            .carousel {
                height: 100vh;
            }
        }

    </style>
</head>
<body>

<!-- Start your project here-->
<jsp:include page="/fragments/home-header.jsp"/>
<jsp:include page="/fragments/photo-carousel.jsp"/>

<main>
    <div class="container">

        <nav class="navbar navbar-expand-lg navbar-dark
     mdb-color lighten-3 mt-3 mb-5">
            <%--            <span class="navbar-brand">Categories:</span>--%>

            <button class="navbar-toggler" type="button"
                    data-toggle="collapse" data-target="#nextNav"
                    aria-controls="nextNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="nextNav">
                <%--                <ul class="navbar-nav mr-auto">--%>
                <%--                    <li class="nav-item active">--%>
                <%--                        <a href="#" class="nav-link">All</a>--%>
                <%--                    </li>--%>
                <%--                    <li class="nav-item">--%>
                <%--                        <a href="#" class="nav-link">Shirts</a>--%>
                <%--                    </li>--%>
                <%--                    <li class="nav-item">--%>
                <%--                        <a href="#" class="nav-link">Sport Wears</a>--%>
                <%--                    </li>--%>
                <%--                </ul>--%>
                <form class="form-inline my-2 my-lg-0">
                    <div class="md-form my-2 my-lg-0">
                        <input type="text" class="form-control mr-sm-2"
                               placeholder="Search" aria-label="Search">
                    </div>
                </form>
            </div>
        </nav>
        <form action="${pageContext.request.contextPath}/home" method="get">
            <section class="text-center mb-4">
                <div class="row wow fadeIn">
                    <c:forEach var="producer" items="${producers}">
                        <c:forEach var="model" items="${models}">
                            <c:forEach var="phone" items="${phones}">
                                <c:choose>
                                    <c:when test="${model.producerId == producer.id
                                  && phone.modelId == model.id}">
                                        <div class="col-lg-3 col-md-6 mb-4">
                                            <div class="card">

                                                <div class="view overlay">
                                                    <img class="card-img-top"
                                                         src="${pageContext.request.contextPath}/static/images/${phone.photo}"
                                                         alt="adidas">
                                                    <a href="">
                                                        <div class="mask rgba-white-slight"></div>
                                                    </a>
                                                </div>

                                                <div class="card-body text-center">
                                                    <a href="" class="gray-text">
                                                        <h5>${producer.name}</h5>
                                                        <h5></h5>
                                                    </a>
                                                    <h5>
                                                        <strong>
                                                            <a href="" class="dark-grey-text">${model.name}
                                                                <span class="badge badge-pill danger-color">New</span></a>
                                                        </strong>
                                                    </h5>
                                                    <h4 class="font-weight-bold blue-text">
                                                        <strong>${phone.price}$</strong>
                                                    </h4>
                                                </div>
                                                <form action="${pageContext.request.contextPath}/product-page">
                                                    <a href="/product-page?phoneId=${phone.id}">
                                                        <button name="phoneId" value="${phone.id}"
                                                                class="btn blue-gradient btn-md">
                                                            Details
                                                        </button>
                                                    </a>
                                                </form>
                                            </div>
                                        </div>
                                    </c:when>
                                </c:choose>
                            </c:forEach>
                        </c:forEach>
                    </c:forEach>
                </div>
            </section>
        </form>

        <nav class="d-flex justify-content-center wow fadeIn">
            <ul class="pagination pg-blue">
                <li class="page-item disabled">
                    <a href="#" class="page-link" aria-label="Previous">
                        <span aria-hidden="true">&laquo;</span>
                    </a>
                </li>
                <li class="page-item active">
                    <a href="#" class="page-link" aria-label="Previous">
                        <span aria-hidden="true">1</span>
                    </a>
                </li>
                <li class="page-item ">
                    <a href="#" class="page-link" aria-label="Previous">
                        <span aria-hidden="true">2</span>
                    </a>
                </li>
                <li class="page-item ">
                    <a href="#" class="page-link" aria-label="Previous">
                        <span aria-hidden="true">3</span>
                    </a>
                </li>
                <li class="page-item ">
                    <a href="#" class="page-link" aria-label="Previous">
                        <span aria-hidden="true">4</span>
                    </a>
                </li>
                <li class="page-item ">
                    <a href="#" class="page-link" aria-label="Previous">
                        <span aria-hidden="true">5</span>
                    </a>
                </li>
                <li class="page-item ">
                    <a href="#" class="page-link" aria-label="Next">
                        <span aria-hidden="true">&raquo;</span>
                    </a>
                </li>
            </ul>
        </nav>
    </div>
</main>
<jsp:include page="/fragments/footer.jsp"/>

<!-- jQuery -->
<script type="text/javascript" src=static/js/jquery.min.js></script>
<script type="text/javascript" src="static/js/bootstrap.min.js"></script>
<script type="text/javascript" src="static/js/mdb.min.js"></script>
<script type="text/javascript" src="static/js/popper.min.js"></script>
<script type="text/javascript"></script>
</body>
</html>
