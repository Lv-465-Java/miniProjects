<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2020-01-12
  Time: 19:22
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<div id="carousel-ex" class="carousel slide carousel-fade pt-4" data-ride="carousel">
    <ol class="carousel-indicators">
        <li class="active" data-target="#carousel-ex" data-slide-to="0"></li>
        <li data-target="#carousel-ex" data-slide-to="1"></li>
        <li data-target="#carousel-ex" data-slide-to="2"></li>
    </ol>
    <div class="carousel-inner" role="listbox">

        <div class="carousel-item active">
            <div class="view" style="background-image: url('https://images.pexels.com/photos/699122/pexels-photo-699122.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260');
        background-repeat: no-repeat; background-size: cover;">
                <div class="mask rgba-black-strong d-flex
          justify-content-center align-items-center">
                    <div class="text-center white-text mx-5 wow fadeIn">
                        <h1 class="mb4">
                            <strong> Online Shop</strong>
                        </h1>
                        <p>
                            <strong>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Consequuntur,
                                dignissimos.</strong>
                        </p>
                        <p class="mb-4 d-none d-md-block">
                            <strong>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Deleniti distinctio, fuga
                                hic id praesentium quisquam?</strong>
                        </p>
                        <a href="#" class="btn btn-outline-white btn-lg">
                            Lorem ipsum dolor. <i class="fa fa-graduation-cap ml-2"></i>
                        </a>
                    </div>
                </div>
            </div>
        </div>

        <div class="carousel-item ">
            <div class="view" style="background-image: url('https://images.pexels.com/photos/404280/pexels-photo-404280.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260');
        background-repeat: no-repeat; background-size: cover;">
                <div class="mask rgba-black-strong d-flex
          justify-content-center align-items-center">
                    <div class="text-center white-text mx-5 wow fadeIn">
                        <h1 class="mb4">
                            <strong> Online Shop</strong>
                        </h1>
                        <p>
                            <strong>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Consequuntur,
                                dignissimos.</strong>
                        </p>
                        <p class="mb-4 d-none d-md-block">
                            <strong>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Deleniti distinctio, fuga
                                hic id praesentium quisquam?</strong>
                        </p>
                        <a href="#" class="btn btn-outline-white btn-lg">
                            Lorem ipsum dolor. <i class="fa fa-graduation-cap ml-2"></i>
                        </a>
                    </div>
                </div>
            </div>
        </div>
        <div class="carousel-item ">
            <div class="view" style="background-image: url('https://images.pexels.com/photos/594452/pexels-photo-594452.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260');
        background-repeat: no-repeat; background-size: cover;">
                <div class="mask rgba-black-strong d-flex
          justify-content-center align-items-center">
                    <div class="text-center white-text mx-5 wow fadeIn">
                        <h1 class="mb4">
                            <strong> Online Shop</strong>
                        </h1>
                        <p>
                            <strong>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Consequuntur,
                                dignissimos.</strong>
                        </p>
                        <p class="mb-4 d-none d-md-block">
                            <strong>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Deleniti distinctio, fuga
                                hic id praesentium quisquam?</strong>
                        </p>
                        <a href="#" class="btn btn-outline-white btn-lg">
                            Lorem ipsum dolor. <i class="fa fa-graduation-cap ml-2"></i>
                        </a>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div>
        <a href="#carousel-ex" class="carousel-control-prev"
           role="button" data-slide="prev">
            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
        </a>
        <a href="#carousel-ex" class="carousel-control-next"
           role="button" data-slide="next">
            <span class="carousel-control-next-icon" aria-hidden="true"></span>
        </a>
    </div>
</div>
</body>
</html>
