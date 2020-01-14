<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: int
  Date: 12.01.20
  Time: 15:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Place List</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/mainPage.css"/>
</head>
<body>
<div class="wrapper container">
    <jsp:include page="/fragments/header.jsp"/>


<%--     <nav class="navbar navbar-expand-md">--%>
<%--  <a class="navbar-brand" href="#">Logo</a>--%>
<%--  <button class="navbar-toggler navbar-dark" type="button" data-toggle="collapse" data-target="#main-navigation">--%>
<%--    <span class="navbar-toggler-icon"></span>--%>
<%--  </button>--%>
<%--  <div class="collapse navbar-collapse" id="main-navigation">--%>
    <nav class="navbar navbar-default">

        <ul class="nav navbar-nav">
            <div class="row">
                <div class="col-md-4">
                    <li class="nav-item">
                        <a class="nav-link" href="#">${userDto.username}</a>
                    </li>
                </div>
                <div class="col-md-4">
                    <li class="nav-item">
                        <a class="nav-link" href="${pageContext.request.contextPath}/personalCabinet">Personal cabinet</a>
                    </li>
                </div>
                <div class="col-md-4">
                    <li class="nav-item">
                        <a class="nav-link" href="${pageContext.request.contextPath}/login">Log out</a>
                    </li>
                </div>
            </div>
        </ul>
    </nav>


    <div class="heading"></div>


    <div class="row">
        <aside class="col-md-3">
            <div class="panel panel-primary">
                <div class="panel-heading">MENU</div>
                <div class="panel-body">
                    <ul class="list-group submenu">
                        <li class="list-group-item active">Places</li>
                        <li class="list-group-item"><a href="${pageContext.request.contextPath}/commentList">Comments</a></li>
                        <li class="list-group-item"><a href="${pageContext.request.contextPath}/tripList">Trips</a></li>
                        <li class="list-group-item"><a href="${pageContext.request.contextPath}/transportList">Transports</a></li>
                    </ul>
                </div>
            </div>
        </aside>



        <section class="col-md-9">
            <div class="jumbotron">
                <blockquote>
                    <p>
                        Quet
                    </p>
                    <small> Author</small>
                </blockquote>
            </div>
            <div class="container features">
                <c:forEach items="${placeList}" var="place">
                <div class="row">
                    <div class="col-lg-4 col-md-4 col-sm-12">
<%--                        <div class="col-sm">--%>
                        <div>
                            <label>${place.country}, ${place.town}</label>
                        <c:out value="${place.name}"/>
                        </div>
                    </div>
                    </div>
                    </c:forEach>
<%--                    <div class="col-lg-4 col-md-4 col-sm-12">--%>
<%--                        <h3 class="feature-title">Germany,Neuschwanstein,The Ultimate Fairytale Castle</h3>--%>
<%--                        <img src="${pageContext.request.contextPath}/images/germany-neuschwanstein-castle.jpg" class="img-fluid">--%>
<%--                        <p>The quaint old town of Füssen, situated between the Ammergau and Allgäu Alps and a popular alpine resort and winter sports center, is a good base from which to explore nearby Neuschwanstein Castle, one of Europe's most famous (and picturesque) royal castles.--%>

<%--                            King Ludwig II of Bavaria built this many-towered and battlement-covered fantasy fortress - the inspiration for Walt Disney's famous theme park castles - from 1869-86.--%>

<%--                            A variety of tour options are offered, including guided tours of the sumptuous interior taking in the Throne Room, the Singers' Hall... and some of the country's most spectacular views.</p>--%>
<%--                    </div>--%>
<%--                    <div class="col-lg-4 col-md-4 col-sm-12">--%>
<%--                        <h3 class="feature-title">Greece,Santorini</h3>--%>
<%--                        <img src="${pageContext.request.contextPath}/images/greece-santorini.jpg" class="img-fluid">--%>
<%--                        <p>tunning Santorini is the most dramatic of all the Greek isles. It is best known for the west coast cliff-top towns of Fira and Oia, which appear to hang over a deep, blue sea-filled caldera. Made up of typical Cycladic whitewashed cubic buildings, many of which have been converted into boutique hotels with infinity pools, both Fira and Oia are considered romantic destinations, popular for weddings and honeymoons.--%>

<%--                            Things to do in Santorini include sunbathing and swimming at the black volcanic-sand beaches on the south and east coasts and visiting the archaeological site of Akrotiri, an Ancient Minoan settlement buried below lava following the volcanic eruption that created the caldera, some 3,600 years ago. The island has an airport and is served by ferries and catamarans from Athens' port, Piraeus.</p>--%>
<%--                    </div>--%>
                </div>




                <h2>Our trip</h2>
                <div class="trip">
                    <div class="row">
                        <div class="col col-md-4">
                            <img src="" alt="John Doe" class="thumbnail">
                            <div class="caption">
                                <h3>John Doe</h3>
                                <p></p>
                            </div>
                        </div>
                        <div class="col col-md-4 col-md-offset-1">
                            <img src="" alt="Saundra Pittsley" class="thumbnail">
                            <div class="caption">
                                <h3>Saundra Pittsley</h3>
                                <p></p>
                            </div>
                        </div>
                        …
                    </div>
                    <div class="row">
                        <div class="col col-md-4">
                            <img src="" alt="Ericka Nobriga" class="thumbnail">
                            <div class="caption">
                                <h3>Ericka Nobriga</h3>
                                <p></p>
                            </div>
                        </div>
                        <div class="col col-md-4 col-md-offset-1">
                            <img src="" alt="Cody Rousselle" class="thumbnail">
                            <div class="caption">
                                <h3>Cody Rousselle</h3>
                                <p></p>
                            </div>
                        </div>
                        …
                    </div>
                </div>

<%--            </div>--%>
        </section>
    </div>
</div>



<jsp:include page="/fragments/footer.jsp"/>

</body>
</html>
