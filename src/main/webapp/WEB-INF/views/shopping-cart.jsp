<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2020-01-14
  Time: 04:27
  To change this template use File | Settings | File Templates.
--%>
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
    <!-- For demo purpose -->
    <div class="container text-white py-5 text-center">
        <h1 class="display-4">Online Shop Cart</h1>
    </div>
    <!-- End -->

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
                            <tr>
                                <th scope="row" class="border-0">
                                    <div class="p-2">
                                        <img src="https://res.cloudinary.com/mhmd/image/upload/v1556670479/product-1_zrifhn.jpg"
                                             alt="" width="70" class="img-fluid rounded shadow-sm">
                                        <div class="ml-3 d-inline-block align-middle">
                                            <h5 class="mb-0"><a href="#" class="text-dark d-inline-block align-middle">Timex
                                                Unisex Originals</a></h5><span
                                                class="text-muted font-weight-normal font-italic d-block">Category: Watches</span>
                                        </div>
                                    </div>
                                </th>
                                <td class="border-0 align-middle"><strong>$79.00</strong></td>
                                <td class="border-0 align-middle"><strong>3</strong></td>
                                <td class="border-0 align-middle"><a href="#" class="text-dark"><i
                                        class=" fa fa-shopping-cart"></i></a></td>
                                <td class="border-0 align-middle"><a href="#" class="text-dark"><i
                                        class="fa fa-trash"></i></a></td>
                            </tr>
                            <tr>
                                <th scope="row">
                                    <div class="p-2">
                                        <img src="https://res.cloudinary.com/mhmd/image/upload/v1556670479/product-3_cexmhn.jpg"
                                             alt="" width="70" class="img-fluid rounded shadow-sm">
                                        <div class="ml-3 d-inline-block align-middle">
                                            <h5 class="mb-0"><a href="#" class="text-dark d-inline-block">Lumix camera
                                                lense</a></h5><span class="text-muted font-weight-normal font-italic">Category: Electronics</span>
                                        </div>
                                    </div>
                                </th>
                                <td class="align-middle"><strong>$79.00</strong></td>
                                <td class="align-middle"><strong>3</strong></td>
                                <td class="align-middle"><a href="#" class="text-dark"><i class="fa fa-shopping-cart"></i></a>
                                </td>
                                <td class="align-middle"><a href="#" class="text-dark"><i class="fa fa-trash"></i></a>
                                </td>
                            </tr>
                            <tr>
                                <th scope="row">
                                    <div class="p-2">
                                        <img src="https://res.cloudinary.com/mhmd/image/upload/v1556670479/product-2_qxjis2.jpg"
                                             alt="" width="70" class="img-fluid rounded shadow-sm">
                                        <div class="ml-3 d-inline-block align-middle">
                                            <h5 class="mb-0"><a href="#" class="text-dark d-inline-block">Gray Nike
                                                running shoe</a></h5><span
                                                class="text-muted font-weight-normal font-italic">Category: Fashion</span>
                                        </div>
                                    </div>
                                <td class="align-middle"><strong>$79.00</strong></td>
                                <td class="align-middle"><strong>3</strong></td>
                                <td class="align-middle"><a href="#" class="text-dark"><i class="fa fa-shopping-cart"></i></a>
                                </td>
                                <td class="align-middle"><a href="#" class="text-dark"><i class="fa fa-trash"></i></a>
                                </td>
                            </tr>
                            </tbody>
                        </table>
                    </div>
                    <!-- End -->
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
