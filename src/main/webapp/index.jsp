<%--<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2020-01-08
  Time: 14:35
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <title>Material Design for Bootstrap</title>
    <!-- MDB icon -->
    <!--    <link rel="icon" href="img/mdb-favicon.ico" type="image/x-icon">-->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <!-- Font Awesome -->
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.11.2/css/all.css">
<%--    <link rel="stylesheet" href=<c:url value="static/css/bootstrap.min.css">--%>
<%--    </c:url>>--%>

<%--    <link rel="stylesheet" href=<c:url value="static/css/mdb.min.css">--%>
<%--    </c:url>>--%>
<%--    <!-- Your custom styles (optional) -->--%>
<%--    <link rel="stylesheet" href=<c:url value="static/css/authentication.css">--%>
<%--    </c:url>>--%>


<%--    <link rel="stylesheet" href=<c:url value="/static/css/register.css">--%>
<%--    </c:url>>--%>
    <!-- Bootstrap core CSS -->
<%--    <link rel="stylesheet" href="/static/css/bootstrap.min.css">--%>
<%--    <link rel="stylesheet" href="<%=request.getContextPath()%>/static/css/bootstrap.min.css">--%>
<%--    <!-- Material Design Bootstrap -->--%>
<%--    <link rel="stylesheet" href="<%=request.getContextPath()%>/static/css/mdb.min.css">--%>
<%--    <!-- Your custom styles (optional) -->--%>
<%--    <link rel="stylesheet" href="<%=request.getContextPath()%>/static/css/authentication.css">--%>


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
<nav class="navbar fixed-top navbar-expand-lg navbar-light white scrolling-navbar">
    <div class="container">
        <a href="#" class="navbar-brand waves-effect">
            <strong class="blue-text">OnlineShop</strong>
        </a>
        <button class="navbar-toggler" type="button"
                data-toggle="collapse" data-target="#navbarContent"
                aria-controls="navbarContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarContent">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item active">
                    <a href="" class="nav-link waves-effect">Home</a>
                </li>
                <li class="nav-item">
                    <a href="" class="nav-link waves-effect">Product</a>
                </li>
                <li class="nav-item">
                    <a href="" class="nav-link waves-effect">About us</a>
                </li>
                <li class="nav-item">
                    <a href="" class="nav-link waves-effect">Blog</a>
                </li>
            </ul>
            <ul class="navbar-nav nav-flex-icons">
                <li class="nav-item">
                    <a href="#" class="nav-link waves-effect">
                        <span class="badge red z-depth-1 mr-1">13</span>
                        <i class="fa fa-shopping-cart"></i>
                        <span class="clearfix d-none d-sm-inline-block">Cart</span>
                    </a>
                </li>
                <li class="nav-item">
                    <a href="#" class="nav-link waves-effect">
                        <i class="fab fa-facebook"></i>
                    </a>
                </li>
                <li class="nav-item">
                    <a href="#" class="nav-link waves-effect">
                        <i class="fab fa-twitter"></i>
                    </a>
                </li>
                <li class="nav-item">
                    <a href="#" class="nav-link border border-light rounded waves-effect">
                        <i class="fab fa-github"></i>
                    </a>
                </li>
            </ul>
        </div>
    </div>
</nav>

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

<main>
    <div class="container">

        <nav class="navbar navbar-expand-lg navbar-dark
     mdb-color lighten-3 mt-3 mb-5">
            <span class="navbar-brand">Categories:</span>

            <button class="navbar-toggler" type="button"
                    data-toggle="collapse" data-target="#nextNav"
                    aria-controls="nextNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="nextNav">
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item active">
                        <a href="#" class="nav-link">All</a>
                    </li>
                    <li class="nav-item">
                        <a href="#" class="nav-link">Shirts</a>
                    </li>
                    <li class="nav-item">
                        <a href="#" class="nav-link">Sport Wears</a>
                    </li>
                </ul>
                <form class="form-inline my-2 my-lg-0">
                    <div class="md-form my-2 my-lg-0">
                        <input type="text" class="form-control mr-sm-2"
                               placeholder="Search" aria-label="Search">
                    </div>
                </form>
            </div>
        </nav>

        <section class="text-center mb-4">
            <div class="row wow fadeIn">

                <div class="col-lg-3 col-md-6 mb-4">
                    <div class="card">

                        <div class="view overlay">
                            <img class="card-img-top"
                                 src="data:image/jpeg;base64,/9j/4AAQSkZJRgABAQAAAQABAAD/2wCEAAkGBxAPEBAQDw8PDxAPDw8PDw8PDQ8PDQ8NFREWFhURFRUYHSggGBomGxUVITEhJi0rLi4wFx81ODMtNygtLisBCgoKDg0OFxAQGy0dHR83Ly0uKys3MjAtNy04KystLSstNzU3Nys3MCs3LSstLS0rLS8rLS0rLSs3Ky0tLS0tLf/AABEIAOEA4QMBIgACEQEDEQH/xAAbAAEAAgMBAQAAAAAAAAAAAAAAAQIDBAUGB//EAEsQAAEDAgQEAQcGBw4HAAAAAAEAAgMEEQUSITEGE0FRYRQiMnGBkbEHUnKhwfAjM0KU0uHxFRYkNENTYnN0gpKi0eJFVGOTo7LC/8QAFwEBAQEBAAAAAAAAAAAAAAAAAAECA//EAB0RAQACAgMBAQAAAAAAAAAAAAABEQIhEjFBUSL/2gAMAwEAAhEDEQA/APuKIiAiIgIiICKjpO2qxuef2IMxcO6rzAsBCIMpl7LAZSXEXIt02V1glFnXPVBnDz3KtzSsbSrEoL84+CqZT9wtGlr2yPexu8Tg2Qa+a4tDhuNdCNltlClZJD3+tZY5Da++i15FeP0Qg2hIFIcO6wISg2UWq1xWRsp6oMyKGuBUoCIiAiIgIiICIiAiKCUErA+S+g96iR9/UoAQFKrdLoBQIgQSFD2ZhY/sU3S6DXuW6H9SyCULIR3WN0APcepBrU1AyNxc0vJde+aaaQa+D3ED2BbJcqiAj8o+4K/LHXX1oKNAJ++6yhAAFIQSquVwsciAFYqApd+tBI+56q7ZLWDuuzvHsVjGyncWOvdBsIsETy05Xag+i7/5Pis6AiIgIiICIqOfZBZzrBYHOvujnX3VQgm6BECCOiIVDdkEhFAUoJCIlkEhEsiAiBECyFSlkEBVkCuqSbIIYpcb/BQw6IwaILdFAKkqpQXIBGuysx9tDqOh7ev/AFUN2TN+tBnRarH5Po/+v6vgtpAREQYXy9veqLDCCCWO1I1afnM6H1jb9qzFACjqpUIJRECA4LHEVlWE6O8DqguQgUoUEhSqseDcAgkbgEXCsCglc7H8Yhoad9RUPDI2WGt/OedGsFgTcnsD36LoL598o2I0QeHVjmSx0Lc/kZAc6SrlbZji06OswkC+gzuJ2WcpqFir273BXFDcRhLiI2zx25scTy+Ozr5XscQCWmxHrBXpF8R4d4wpBXUctJBLG+d4pKimawcmKm2D2hoFyDldpoA11wCvtoUwyuCYrfkpQqLqr3hou4gAblxAA9pW0WKq/ZWuquQV6KzdlU7K7UAqih7rlXaEEyGwVIhp8VkkFwoi2QMiQHILE3aD5vcDt4qeq0cbxJtLC+V2uUea3q550a0eJNgg6fOb85vvChfKPJsT+e/3lEH1OsBAztGYt6dSzqB4/wCioxwcAQbgi4PgttaJby35fyJCSz+i/ct9u/vQZUCIgBQTbVSAsNU6zbXFzsO5QZYzfVVmH1K7BYKH9UENN7KxVGK5QfJeK4aanq6u8lVRTyTGUVVNFHz54nxscY2SAF4aHeI1B6Lao+OzQU0E1RUvxCGSXkyF0LIqyJ+UuHmg66NJs7foei6vymcISV4jlpmsdM20b2yzmGIxBxcCSBc6kiwt6W+i8bhvyX1tpGzinZDLyy+KGpLhIY35m5Xv1YbFwuc2hPhbjMZROmu4n6+xYRikFZCyemkbLFILte3v1aQdWuGxB1C+G8dUgmrJp4jFWN57nTem+KN4kcwQvLDmYcrGixtfXRe74PwXEsPnY1raV1G4yc6JksTHAlwyzABurg0AWvtcdlwaP5P8RhqamaKaOLyirkeZI6rK4U5lc5t22s42dexuNAO6udzDMZPPYjQ4dE9sT6erNW+YTGmiizQNY45nNjMjW5oxt11NtQF95o6pr4Y5rhrHxNku4gBrS0G57WXzOt4bxp0bms8ncM92vqq7myhuovGWRsyXuLi5HbquhxVgeKT0lLh9Myl8nbTQNqnOrHslkla0AxsIHoC17uBv201mETFt5Vr4xcVfKRGJ5aGmqY6N8ej62endNEDluWxtBtexHnO0O1tivNYnhsk83JrcUpJTM2MZZBI2oMkjs8XKzO825YNiB0tst2m+TaqjyPd5PLOPJ2kvdHkZFEC3l5XZruyhmosLNAsNV0+HOCa11ZS1GICB5pyZpJmzCd807BaFrQWDltBObSwJaNNkmMspSMuMz78fTIY8rWt+a1rfcLKzhorBQ5dmWMqXbIj3WF+yCGNt4nqrha8U4J3WwEFnKI9lLlKDFLLl7bXJOzR3Xl8OhdilR5Q+/kdO8imZ0mkGhnPfw7D1lW4gqH1U37nwE3ks6rkH8lT/ADL/ADnfD1r1VFSshjbGwWaxoaAEGXIOw9yKyICxVMIe0tdseo3B6EeKyqrkGhSzE3Y/8Yz0v6Q6PHgVsBYq2Am0jPxjL26BzerD61zsT4kp6ZjS9xdI8Xjp2DNUPPbL010udEG7iVcynjfLIcrI23J79gO5J0A8VxuFqeQtdUVBPMqXGbKSSGjZoHazbD2LXpcMqMQkbPXDlQMOaGjBuL9HyH8p3w6L1D4xpptoPAWQWCgqApQQ1WVQpCDFWUrJo3xSND45Glj2nYtIsV4vGcNpqaLyX9zsTnghjeWOppXPD2yMe0xg8zOT5zhlO1wRoAR7tQpMWW+WYBQ4ZR8qpgwXF4nytljyuinkkjja5oJe0vIF9LdSAVhqaHCZajI7AMWcXTNYH+SytpTcuaH+kA1gzk6gWvtovR8RcP4qZWyUGJyCMOBfTTuAu29y1smU6dNR13K5uAUfEAFfFPUHmcmOShlks+ESZ3h0TnADUtA72uDrayxW276vbNh/DuHG9LHR4rHDEHsyOnro6dzczr2a5wa4EuP3AWnNT4fSuZLHhONSOp53RRCNlQ62QEXa1z7csgnwN10YKLF4qZrp555qiapgYYoJBaCnAcXuzFve1yeg31JVIcDx2oneZcSko6USHIGinkrJIwbX81uRl9xuRcXCz3PSY1740MQwyhr54Gz4LjD3Suc5r3udHDTiTLmLzzQGCzQcu+lrX0X0HAsGp6CBtPSs5cTC4hpe55u5xcblxJOpK2qWHlsazO9+UWzyPL5HHu491lXWIpLlKglCVBVRVY6lt2EfO8322NllKiVl2+NwR6wg4FVVVPlbYYWMMUcAmma8We/M4tDWEbEZSb9brrUkzX2cx2YXykHRzD81w6FauHxO8uqZH2sYoGxDry7G5P8Aezraq8JbIeZG50Mw/lGfleD27OHrQbq4/EuNilY1sYElTMcsEPUnq93Zo6rFiOPPpYyJYXSVF8sTImu5czjs7N+QO99ul1XhzA3tc6rqyJKuaxJt5sTekbB0AQbPCmDmmjc6Q56iZxknkO7nnf2LuqjSroCIiAquVlVyCq1G4ZDzOdymc0jV+UZltlOgUQWN+3tKyFYpNm+1UhDUcoZspcioUhQpCDkcR8UUeHMD6ucRguDAAx8ji+17WaCdtVGCcV0Va6RlNPzOUxkj3cuRkfLf6JDnAA9RpsQuFh2LR0FbXRV0s5dNNz4XyRyywiFxOWOPKDYAZR2JBG+/lMcx2XEKbFYcOp3sNNJTyxhjG5pqXmecQy2hzNzeodxZc+UtVqZepx75RaFsM4o62mfUsDTHdzTE852hwDr2OhPXppsurgeOOlqpIZJYSG0cFTlYyVoZmZGXu5hbkey77gh1xfVed4g4hwyWijhpoKeZ5ycqlfS/gomMkbzQ45cjLNDgDexNjtqudfy6SugY3kubg2HguhY6WAwOEUrmCMa7XaGi9wdu85TaaqHrcY41pmsnZC+YTsL4oy6lmZE+pG0bZJGBhJOxJsb7rYqOKIKKmp34hM2KeZgPKbeaZ7x6QY2Nt3AX3AsuJX45hwwowwyPgaxjYYssclJK2Ua5o8wbc3aSctzvcbhadBjz4KiklrxKaOagidDM6nY+OKpsL5nNGbP5rzYDQOvtqHLa15T1WCcZUFb/ABeozANLiXxyRNFg4kXeALgNJI6DXZYm8ZUU55dNVxGRzssZdcMe4OsWtJ3P2arx1HicFZjkr6VjZaJ1A9sz2wMLZ53RyXcy4uSWgtI65XX31pxDxW2mpqeakdQVtM6VjaajfTSR1HNs8OdEyxtcuFiANCbXzK8pPzu9PqzfHfr2urEKkRJDSRlJAJb8021CuF0ZRZWQKUHMq35KumttIydh8bZHD7feuq06e0rjYybT0R/60jf8UZ/RXZAsiIe0bkA220RuyP8AtVnBQQVdpVCrR7IQsiIqoqOV1RyJKEUP2UhtlBD9lWUbKzvtCibp9+iDDGd/WruWJhs5ZXKqgKQoCsEGKrpIpm5Joo5W3ByyxtkbcbGzgrQ00bDdkbGEgAlrGtJA2Gg2WQKUGocOgBc4QQhzwQ93JZme0m5DjbUK8dOxpu1jGmwbdrGg5QAA246aDTwCzKpQYZKCFzjI6CFzy3KXuiYXlnzSSLkeCvJSxvYGPjjdGLWjcxrmC21mkW0WYKEGOGljZYMjjZbbJG1oG+1h4n3lY/IIQ8ScmLmNvlk5TOYLm5s61xcraVXIIRArAIFlKIg5GON8+jd2q2/XFIF2iuNxAbMhPaqgPvJH2rslBU7hXcqdQrFRFXbK7BoqP+1ZQqQIiIoqFXVCiSq7p61Yqp3CsVBU9PWk/ROoSfoqrUdo5Z1hm6FZboCkIpCCQiIghVViVUILhCgVboLEqpRAgkKygIglQSpVRug5PEp/BR+NVTj/AD3+xdsrh8Tfi4f7XB8Su6UFD09alEURHULKsce5PsWRVRERAVCrrG5l+uiCAdQpe09FZrAFZBRjLKs/RZVim6INaZXaqyBWagspUIgsllUFS4oIKKFYIJKqihBKAIrBAREQSVVqsqoOVxGPMg/tcH2ruELi8SfimH5tRTn/AMgH2rtoMWb2KSVchUMaJSYxoroERRERAREQEREBYZt/YsywSnVBikUtCiTopQWCFVBVkAKCiXQLqbqqkIJUIpAQApuilAul0SyBdQpsgQcvif8Aizj2kpz7pmLtN2HqXF4nH8Fk+lCfdMxdmPYeoILIiICIiAiIgIiICIiAteXcrYWs86n1oKuVbqSpAQFKKEEooupQQpaFCkIJREQSl1CIJurKqZkE2RpUKQEHN4kF6SfwaHe5wP2LrQG7W/RHwXJ4jP8ABKn+qd8F06T8Wz6DfggzIiICIiAiIgIiICIiAtQnVbZWmgkBCpVSgsoRAEEBSrIgql1ZLIIUpZEBERBKXSymyAFKoUuUGhxGB5JU/wBS8+4XXSpD+DZ9BvwXL4m0o6jxjy+9wH2rq0osxg7Mb8EGVERAREQEREBERAREQQ7Zai3F5ytjxMvcIfI2x381z2yOfbx86yDslVXCGEYm/V+IMj8IqaK3+YFXGD4i3bEQ7wfTQ2+pqDuBqnMPvquE6lxUbS0cn0oZGn6nKrf3VG8VE4dg6Vp99yg7xcO6nTuFwPK8TG9DA76NS4fFqq6uxE/8Oj/O/wDYg9CD4ovOtr8RG2HM/O/9isK/ERq7D2f3KvX62IPQXUrgfvhkZ+NoKtniwRyD6iPgg4uph6Talh7OpZb/AFAoO+l1w2cW0RveYt+nDMz4tWRvFFCdfKoh9IlvxCDtBLrjHiihAv5XD/j1926xni2g/wCYH/bl/RQdslGrg/vuof5535vP+in78KH+ckPqpqj9FBucTi9JN6mH2CRq68Pot+iPgvIYxxFDUxGCnMjpJnxsAdBMwBmcFxu5ttgV7CNtmgdgB9SCyIiAiIgIiICIiAiIgIiICIiAiIgIiICIiCCtKpUog42I+j7Vw6zoiINU7hdqLYIiDdjWaNSiDZg9IetdVEQEREBERAREQf/Z"
                                 alt="adidas">
                            <a href="">
                                <div class="mask rgba-white-slight"></div>
                            </a>
                        </div>

                        <div class="card-body text-center">
                            <a href="" class="gray-text">
                                <h5>T-shirt</h5>
                            </a>
                            <h5>
                                <strong>
                                    <a href="" class="dark-grey-text">Adidas t-shirt
                                        <span class="badge badge-pill danger-color">New</span></a>
                                </strong>
                            </h5>
                            <h4 class="font-weight-bold blue-text">
                                <strong>150$</strong>
                            </h4>
                        </div>
                    </div>
                </div>
                <div class="col-lg-3 col-md-6 mb-4">
                    <div class="card">

                        <div class="view overlay">
                            <img class="card-img-top"
                                 src="https://images.ua.prom.st/721296564_w640_h640_futbolka-supreme-belaya.jpg"
                                 alt="supreme">
                            <a href="">
                                <div class="mask rgba-white-slight"></div>
                            </a>
                        </div>

                        <div class="card-body text-center">
                            <a href="" class="gray-text">
                                <h5>T-shirt</h5>
                            </a>
                            <h5>
                                <strong>
                                    <a href="" class="dark-grey-text">Supreme t-shirt
                                        <span class="badge badge-pill danger-color">New</span></a>
                                </strong>
                            </h5>
                            <h4 class="font-weight-bold blue-text">
                                <strong>190$</strong>
                            </h4>
                        </div>
                    </div>
                </div>
                <div class="col-lg-3 col-md-6 mb-4">
                    <div class="card">

                        <div class="view overlay">
                            <img class="card-img-top"
                                 src="https://thumbnail.image.rakuten.co.jp/@0_mall/freshstore/cabinet/51908/519082205_2.jpg?_ex=640x640"
                                 alt="nike">
                            <a href="">
                                <div class="mask rgba-white-slight"></div>
                            </a>
                        </div>

                        <div class="card-body text-center">
                            <a href="" class="gray-text">
                                <h5>T-shirt</h5>
                            </a>
                            <h5>
                                <strong>
                                    <a href="" class="dark-grey-text">Nike t-shirt</a>
                                </strong>
                            </h5>
                            <h4 class="font-weight-bold blue-text">
                                <strong>350$</strong>
                            </h4>
                        </div>
                    </div>
                </div>
                <div class="col-lg-3 col-md-6 mb-4">
                    <div class="card">

                        <div class="view overlay">
                            <img class="card-img-top"
                                 src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ-3y4xUMbOrVHX755sV27-TqU0vqVyasur0-XfZ4cnYhJRXnRt&s"
                                 alt="nasa">
                            <a href="">
                                <div class="mask rgba-white-slight"></div>
                            </a>
                        </div>

                        <div class="card-body text-center">
                            <a href="" class="gray-text">
                                <h5>T-shirt</h5>
                            </a>
                            <h5>
                                <strong>
                                    <a href="" class="dark-grey-text">Nasa t-shirt
                                        <span class="badge badge-pill danger-color">New</span></a>
                                </strong>
                            </h5>
                            <h4 class="font-weight-bold blue-text">
                                <strong>350$</strong>
                            </h4>
                        </div>
                    </div>
                </div>

            </div>
            <div class="row wow fadeIn">
                <div class="col-lg-3 col-md-6 mb-4">
                    <div class="card">

                        <div class="view overlay">
                            <img class="card-img-top"
                                 src="https://images.ua.prom.st/721296564_w640_h640_futbolka-supreme-belaya.jpg"
                                 alt="supreme">
                            <a href="">
                                <div class="mask rgba-white-slight"></div>
                            </a>
                        </div>

                        <div class="card-body text-center">
                            <a href="" class="gray-text">
                                <h5>T-shirt</h5>
                            </a>
                            <h5>
                                <strong>
                                    <a href="" class="dark-grey-text">Supreme t-shirt</a>
                                </strong>
                            </h5>
                            <h4 class="font-weight-bold blue-text">
                                <strong>150$</strong>
                            </h4>
                        </div>
                    </div>
                </div>
                <div class="col-lg-3 col-md-6 mb-4">
                    <div class="card">

                        <div class="view overlay">
                            <img class="card-img-top"
                                 src="data:image/jpeg;base64,/9j/4AAQSkZJRgABAQAAAQABAAD/2wCEAAkGBxAQEBAQDw8PDxASEA8QDw8PDw8PEBAPFREWFhUVFRUYHSggGBolGxUVITEhJSkrLi4uFx8/ODMvNygtLisBCgoKDg0OFxAQGisdHR0tLjAuKy0rNysrNi0rLysrKysuNzA3MDc3LTctKyszLSs1LSswMC0rNystMC0tLS8yLf/AABEIAOEA4QMBIgACEQEDEQH/xAAcAAEAAgIDAQAAAAAAAAAAAAAAAQIGBwMEBQj/xABNEAACAQMBBAYEBgsPBQAAAAAAAQIDBBEhBQYSMQcTQVFhcSKBkdEUMnKhscEjJUJDUlRVYmOClBUWJDNEc3SSk6Oys8LS8Bc1ZISi/8QAGQEBAQEBAQEAAAAAAAAAAAAAAAECAwQF/8QAKxEBAAICAQMACQUBAAAAAAAAAAECAxExBCFBElFSYXGBkcHwEyKhseEF/9oADAMBAAIRAxEAPwDcYAAAAAAAAAAAAAAefR23aTrytoXNCdxFNyoRqRlUilzyly5r2gd/BBYhgUYRYJAAjzbveGypV1bVbqhTrtJqlOpGMsPlz7+49KLTWU013rVAWAAAAAAAAAAAAAAAAAAAAAAAAB4u8e9Nls+Kd1XjCUviUo+nWn8mC1x4vC8TVO8fS9dVeKFjTjaQ5dbUUatd+KXxIf8A15liNptubaG0KNvB1LitToU1znVnGEfn5mvN5OmC2pZhY0pXVTl1tRSpUF4r7qfsS8TTV7d1a8+sr1alapr6dWcqkvJOT0Xgdc1FU2yHbm+20r3KrXU4U2/4mh9gpLwxHWS+U2eLs2/q2lelc28uCrRnxReMrD0aku2L5NdzZwMtJGtI+k9yd8rfadLMMU7iCXX2zeZQf4UfwoPsftwzJGfJFpcTpTjOnOdOpDWnUpylCcfFSWqfYZzszpb2nSXDUdvdJLGatJxqeuVNxXzGJq1tv7Bie/u+9LZlPhjw1bua+xUM/FT++VMaqPhzfZ2tao2p0q7UrpxhUo20Xp/B6WJ4+XNya81gwqpUlKTlOUpzk8ynOTlOT75SerfiyxU259oXM69SdWvJ1KlSTnUlLVyk/oXYl2JI7m729F9YNq1ualOGc9U8VKLXyJZS9WGeVnXHmH2P1M0y2zsPpnmsRv7RS/S2j4X66U39EvUbA2Jvxs28wqN3TU3ypVn1NXPcozxn1ZPmhrkGk9HqvEnowu31yD5x3U38v7DEIVOvoL+T13KUUv0c/jQ9WV4G2d2ukywvHGnUk7SvLRU67ShJ90KvxX5PD8DE1mF2zUEJ51Wq7ySKAAAAAAAAAAADr317SoU5Va9SFKnFZlUqSUYpebNU72dLkm3T2ZDEeTuq0NX/ADdN8vOX9UsRsbM27ty2saXW3VaNKHKKeXOcu6EFrJ+SNT72dLNaspUtnwlbU3o688OvJfmJZVPzy35GvL++rXE3VuKtStVfOdSTk8dy7l4LQ65uKs7cd05VJSnOU6k5elKc5SnOUl2uT1bOOjPOj17n4HYwdWUOF6csmkc7RATygBBZciAngCGkyuvfn1IuQwK6948iRgCKa7Sy5BEgCQwFWiK/IEV+QGS7n78XuzoqFOarUM5+D1suCXaoS5w9Wngbl3X6QbG+4afH8HuH94rNLifdTn8Wflo/A+d4ouZmsES+sgfPe7XSLf2fDBz+FUF96rtuSj3QqfGj68rwNrbv9I2zrvhi6vwas8LqrnFPL7o1PiS9ufAxNZhdsuABFAAAMG316Sbaw4qVDhurpaOnGX2Kk/0s12/mrXvxzMv2pZK4oVaDnOmqtOdPjpycJw4ljMWuTR8tbS2fO3q1beolGdGcqc0lhZi8ZXg+a8GarG0l294N47raFRTu6sqmH6FNLgpU/kQWi83l+J5xwpnMpG2R5IyXwUkyqlMpVjktGWSJAccNC7DQCIBJAUIOalQcteSOzG2j3Z82enH0mS8b4j3vPfqKV7cugD042sJPHox0espYWUs8134080dapa/gv1M1foskcd0r1NJ57OqSHHGjPQsNj1q2HCOE+UpZ18Ukm2vHGDyxWZnTvuOXnlooyu53N6io6devTzGKlUlTqxapt8oyXDpLwznyyYq9H5Pn3ltSa635K2ieEdvze0PVky5+oRMtLEkEgCXrzAQGRbtb531g0qNZzor+T181KWO6OuYfqtLwZvbdDbv7oWlO6dGVDjcouEmpJuL4XKEu2OU8Npcj512Lsyd3c0Lam8SrVFDi58Mec5eqKk/UfTmz7OFClSoUlw06UIU4LujFYRiyw7AAMKGjumrYzpXsLqK9C5ppSeNOuppReX4w4GvKRvEx/fnYCv7KrRwutS623b7K0E+H2rMX4SZYnUkvmpuK8fIh1H3JeYqp9i9WMNPufcccab7TqwOXi2WjEvGCRYCnCQy7ONhQAAQzmtqWdXyXzs4jKt3t1Lq6pRqUowUHVVCEqknFTruPFwLCeNO14WqWcnp6WlZvu/EOGe1orqvMurs+nBQq1akVUVNU4wpyclGVScnhy4WnwpRm8JrLx2ZOWVzSacZwhT41rO2dRuOG8cdOb4Zck/RcXrz7D19kbpXlSjV9CMVWhXhRhKXp1K1tNSmo40T9CcNWubxlI8243auYWdO+4YztqkoxjKnLikpPKxKOMrWLXnjvPqfqUmZ/d+fm3h9C+o1DoXdvKDi5NThJOUKkH6NRdrUms5TxlPVdyOsZtYbkXsatO0rKilcRdRUnV9JKK/jINJpTWXp2pNPQ4rjcirbqE6jozpznOnCt1mKTqRz6LytG+GWM6aYznCfDJ1+LHHtT7ns6f/mZM1o3MUifNp19PMsUs7fiqQlwcajOLllJxcc6p50fkerO/oW7beJTajiMKaU1hLGvJLKzjyxyO/Z7Guq8bnquqg7VN3KqSdN0IJNuTTWvxZcuWHoYRdL03rnLznvPDObNMzk1FY41zPxl7s+Do8VIw0m17+1xHwiPz7OztTaDrzzjhpp5hT7E8Yy++Xi+zTkdGJMQ9GcJmZncuMRqNQmXIQ5EtFYciKuiSEyyAIEYPX3U2LK/vKNrHKU5cVWS+4oR1qS8HjReMkQbN6GN2urpz2hVj6dVOnbJrWNHPpT/AFmseUfE2ecdvQjThGnCKjCEYwhFaKMYrCS9SOQ5zO2gAEAAAaL6VdzZ2ted5RjxWtablU4V/EVpPVP82UstPveO7OAH1dc28KsJ06kYzpzi4ThJZjKLWGmjSO1Oia/+EVI2vUu34vsNWrW4X1b1Skkm8rlnGuM9puLJMNf5Ib7zaVn0L1G069/CK+6jSoSk/VKUl9BlWyuirZdHDnTqXUl91Xqy4X+pDhj7Uy+lCafP7nq/IiDyl5GedMuyba0uaMLW3p28Xa8U1SjwRnJ1JJPC0ykufijAafYWO4uSSwUVNs9HG9FCxtVGVWNOUrvrLiNdVnGVt1WOK34E11iko6PnjnyxqiEmtVjPik8HcoTclq8vk239bPT01IyTOOe2/s5ZbRSIvrctv7B332fb0OqhOUaDqX86tCorh10qlSUqKoSS4cYeHlrDec9/m2m9MKNlcRTp1qc6NJQUYVOG32mqjliacY+jqpqSST6mS56PXKpSbwk28J4Xc0sfSjtW911Llh9Yprhqx+4nT4k3F88vKTz2NJrU9N+kxxPm0z4YxdRktG+1K+vXz7czv4fNsO43vtoV9l3UKyqu2tJ29aLjcU1KrKkoqScoelDOctJvwPN2HvFB30JVa8I2tvWrXcFRjcOlKM+sdX7HJcTnxVFPLWmJ64xjGNrWlCUevtqrlHhhx0qzXWqeFxJY7E29O5c2dXYyzWp5TacuCWmVwSjJSy+z0c+rPcWnSUmm59XHq/33rn6jJjtFY89973MxP9R7vrtndrvPacW3OO4oxjewrU7SULWpGT6yNXDqyjSUvvkU85eVLzeq7r43qR6CkuH0orLjHhlh9jeXo0uzGqf1nl1J5bfj8xnqqVx01HnX8Q44LTe258fdUtNaZIZaHI+c9qYspSeE0+9lo6GxOhrYNrd1L53VvSuFCNsqaqwUlBydTia7m8R9hJnQ11JY1WqLp51R9D3PRvsipzsox/m6txS+aM0jwrjoasW26VxeUk/uOKlUivJyhn2snpQaaZibn6F933Rt53tRYnc4VLvVvF6P9aWX5KJ163QzbtYhfXEX2uVOlLTtxjGpsu2oRpwhTglGEIxhCK5KMVhL2IzaVhygAyoAAAAAAAAAANJdPtTN1aR7raTz8qq1/p+c1nRNj9PMv4dbrutIv21qvuNc0eR1rwz5WYZJEe8qIZe3b4tPXnRJd7ZRkcT5dmjx4li01ndeTVZ7W4erGsmkovK5NvOqznHeo89EKuE8J8SjlKXpYkk3hpPVLwPLjJp6PByxun2pP5j6eHq6a/d2l482G9p7ceI9TuqTXLTybRzRu54kuLHFHhk1GKlJPnGU/jNeGdcHn/CvD5zrzuJN4b07kdL9biiO3dyr02SeeztXN02lDibitEstpLLeEuzVv2s6ZZFD5eXLOS25e6lIpGoXRNMiBaK1ObaWja/QLP0r9f0d+v019RqhPU2b0D1sXN9T/Co0Jr1Tmn9KM24WG5wAc2gAAAAAAAAAAAAAAAGjennHw637/gcc+XXVMfWa7gtEbA6d4fbGg++ypr2Vq3vMAidY4ZVm+wnsK82WKiHyKxFR9hKQECRBIExZWSyTEdoCmwu0q9HkvkAi8nhFEKj0QVbtXibF6D39sa677ST9lWHvNdS7DY3Qd/3Cv/RH/mwM24IbwABzaAAAAAAAAAAAAAAAAaF6cp52rSWdI2VHTuzWrv3GCJmb9Nr+2y/odv8A5lUwdnSOGZUjzLnHAuaRx82cjOOm9WWcgICBAEomXMr2kyAnmVTxoWREkBaIqlabLTAmfJPyNhdCU8bTqR77Oq/ZUp+8169Yme9CUvto332Vdf3tEzbhYb6ABzaAAAAAAAAAAAAAAAAfP/TTLO15eFrbL/G/rMHk9DMOl+Wdr3HhC3S/sYv6zDpdh1jhkiWZC0RWT0KisCxCJAMhkkMCCWESwCCIiwwJ5MsRzCYF4GadDDxteC77a5/0P6jCoGZdEDxtij/M3C9sF7jNuFh9CgA5tAAAAAAAAAAAAAAAAPm/pVqZ2ze+EqEfZbUjFe0yHpGqcW19oP8AT8P9WnCP1GP5wsnWGFZvVIVX2EUu2T7SObKLJBk8iqYAMIiTAsiGw2QBKLFUAHIsQQngDlRlnRbU4dr2n53Ww9tOXuMSPf3GqcO07CX/AJMF/WTj/qJPCw+mQAcmgAAAAAAAAAAAAABBKA+XN8ZcW0r9v8cuV7Ksl9R4lV5aj7fI9HeKtxXl7N85Xd1L++mebSXNvmzqwvLuJCQyURjJJSVQqBdyK5AAkAgCxKK5JyBYMgkBTl2MyDcjH7pWGfxuj/iMdkvaj1t2KrV5ZSTxi8tP8+CfzEnhYfU4AOTQAAAAAAAAAABDJKsBklMqVqPEZfJl9AHyRfVOsq1Hz4qlSbfe5Sb+snkcNvhRT7WkJa9p2YWlW7FqV4W+bwckUktA3/zAFVFIZJY9QEEZ1LKRTOvqx2AWIHEv+YI41nmvmAsySJNNaEZ5AXJTEcFE9QORnb2E8Xdou+7tcefXwOrjQ5LebhOnUXOFSnUXyozUl9BJH1swcVtU44Qk/uoxl7UcpybAAAAAAAAAAAAAEYIaLEAeW93rF87K0/ZqP+06890dmPV7OsX/AOrR9x7mCGhsY/LcrZX5Nsv2emvqKvcvZf5Nsv2en7jIcENDcjHf3k7K/J1n/YQH7zNl/k2y/Z6XuMgwMDY8SG6uz48rCzXlbUfcc0d3rJcrK0Xlb0f9p6mCMDY839w7T8Utf2el7iy2Pa/itt/YUvcd/AwB5dXd6yl8aytH521H3HXe5+zHz2dZfs1L3HuKJZIbGPVNxNlPns+2XyafB/hwdV9G2yG8/AkvKtcJezjMtwWSG5GJf9M9j/if9/c/7y0ejTZC/kfanrXuGtPBzMtwSNyK06ailGOiSSS8EWAAAAAAAAAAAAAAAAAAAACCAABDAIDIAAAAASABJKAAkAFAAAAAAAAAAAf/2Q=="
                                 alt="nasa">
                            <a href="">
                                <div class="mask rgba-white-slight"></div>
                            </a>
                        </div>

                        <div class="card-body text-center">
                            <a href="" class="gray-text">
                                <h5>T-shirt</h5>
                            </a>
                            <h5>
                                <strong>
                                    <a href="" class="dark-grey-text">Nasa t-shirt
                                        <span class="badge badge-pill danger-color">New</span></a>
                                </strong>
                            </h5>
                            <h4 class="font-weight-bold blue-text">
                                <strong>76$</strong>
                            </h4>
                        </div>
                    </div>
                </div>
                <div class="col-lg-3 col-md-6 mb-4">
                    <div class="card">

                        <div class="view overlay">
                            <img class="card-img-top"
                                 src="https://images.ua.prom.st/721296564_w640_h640_futbolka-supreme-belaya.jpg"
                                 alt="supreme">
                            <a href="">
                                <div class="mask rgba-white-slight"></div>
                            </a>
                        </div>

                        <div class="card-body text-center">
                            <a href="" class="gray-text">
                                <h5>T-shirt</h5>
                            </a>
                            <h5>
                                <strong>
                                    <a href="" class="dark-grey-text">Supreme t-shirt
                                        <span class="badge badge-pill danger-color">New</span></a>
                                </strong>
                            </h5>
                            <h4 class="font-weight-bold blue-text">
                                <strong>50$</strong>
                            </h4>
                        </div>
                    </div>
                </div>
                <div class="col-lg-3 col-md-6 mb-4">
                    <div class="card">

                        <div class="view overlay">
                            <img class="card-img-top"
                                 src="https://images.ua.prom.st/721296564_w640_h640_futbolka-supreme-belaya.jpg"
                                 alt="supreme">
                            <a href="">
                                <div class="mask rgba-white-slight"></div>
                            </a>
                        </div>

                        <div class="card-body text-center">
                            <a href="" class="gray-text">
                                <h5>T-shirt</h5>
                            </a>
                            <h5>
                                <strong>
                                    <a href="" class="dark-grey-text">Supreme t-shirt</a>
                                </strong>
                            </h5>
                            <h4 class="font-weight-bold blue-text">
                                <strong>550$</strong>
                            </h4>
                        </div>
                    </div>
                </div>
            </div>
        </section>

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

<footer class="page-footer text-center font-small mt-4 wow fadeIn">
    <div class="pt-4">
        <a href="#" role="button" class="btn btn-outline-white">Online shop
            <i class="fa fa-graduation-cap ml-2"></i></a>
    </div>
    <hr class="my-4">
    <div class="pb-4">
        <a href="#">
            <i class="fab fa-facebook mr-3"></i>
        </a>
        <a href="#">
            <i class="fab fa-youtube mr-3"></i>
        </a>
        <a href="#">
            <i class="fab fa-twitter mr-3"></i>
        </a>
        <a href="#">
            <i class="fab fa-github mr-3"></i>
        </a>
        <a href="#">
            <i class="fab fa-telegram mr-3"></i>
        </a>
        <a href="#">
            <i class="fab fa-google-plus mr-3"></i>
        </a>
    </div>
    <div class="footer-copyright py-3">
        Online Shop
    </div>
</footer>
<!-- End your project here-->

<!-- jQuery -->
<script type="text/javascript" src="<%=request.getContextPath()%>/static/js/jquery.min.js"></script>
<!-- Bootstrap tooltips -->
<script type="text/javascript" src="<%=request.getContextPath()%>/static/js/popper.min.js"></script>
<!-- Bootstrap core JavaScript -->
<script type="text/javascript" src="<%=request.getContextPath()%>/static/js/bootstrap.min.js"></script>
<!-- MDB core JavaScript -->
<script type="text/javascript" src="/static/js/mdb.min.js"></script>
<!-- jQuery -->

<%--<script type="text/javascript" src=<c:url value="/static/js/jquery.min.js">--%>
<%--</c:url>></script>--%>
<%--<!-- Bootstrap tooltips -->--%>
<%--<script type="text/javascript" src=<c:url value="/static/js/popper.min.js">--%>
<%--</c:url>></script>--%>
<%--<!-- Bootstrap core JavaScript -->--%>
<%--<script type="text/javascript" src=<c:url value="/static/js/bootstrap.min.js">--%>
<%--</c:url>></script>--%>
<%--<!-- MDB core JavaScript -->--%>
<%--<script type="text/javascript" src=<c:url value="/static/js/mdb.min.js">--%>
<%--</c:url>></script>--%>
<!-- Your custom scripts (optional) -->
<script type="text/javascript"></script>

<script>
    new WOW().init();
</script>
</body>
</html>
