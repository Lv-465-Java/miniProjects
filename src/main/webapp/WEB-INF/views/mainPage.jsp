<%--
  Created by IntelliJ IDEA.
  User: int
  Date: 07.01.20
  Time: 19:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Main Page</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
    <link rel="stylesheet" type="text/css" href="css/mainPage.css">
</head>
<body>
<div class="wrapper container">
    <jsp:include page="/fragments/header.jsp"/>
<%--    <header class="page-header header container-fluid">--%>
<%--        <div class="row">--%>
<%--            <div class="col-md-8">--%>
<%--                <h1>Trip Planner</h1>--%>
<%--            </div>--%>
<%--            <div class="col-md-4">--%>
<%--                <form name="search" action="#" method="get" class="form-inline form-search pull-right">--%>
<%--                    <div class="input-group">--%>
<%--                        <label class="sr-only" for="searchInput">Search</label>--%>
<%--                        <input class="form-control" id="searchInput" type="text" name="search" placeholder="Search">--%>
<%--                        <div class="input-group-btn">--%>
<%--                            <button type="submit" class="btn btn-primary">GO</button>--%>
<%--                        </div>--%>
<%--                    </div>--%>
<%--                </form>--%>
<%--            </div>--%>
<%--            <!--  <div class="col-md-2">--%>
<%--               <h4>--%>
<%--                 <a href="/login.jsp">Log out</a></h4>--%>
<%--             </div> -->--%>

<%--        </div>--%>
<%--    </header>--%>




    <!-- <nav class="navbar navbar-expand-md">
  <a class="navbar-brand" href="#">Logo</a>
  <button class="navbar-toggler navbar-dark" type="button" data-toggle="collapse" data-target="#main-navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="main-navigation"> -->
    <nav class="navbar navbar-default">

        <ul class="nav navbar-nav">
            <div class="row">
                <div class="col-lg-4 col-md-4 col-sm-6">
                    <li class="nav-item">
                        <a class="nav-link" href="#">${userDto.username}</a>
                    </li>
                </div>
                <div class="col-lg-4 col-md-4 col-sm-6">
                    <li class="nav-item">
                        <a class="nav-link" href="${pageContext.request.contextPath}/personalCabinet">Personal cabinet</a>
                    </li>
                </div>
                <div class="col-lg-4 col-md-4 col-sm-6">
                    <li class="nav-item">
                        <a class="nav-link" href="${pageContext.request.contextPath}/logout">Log out</a>
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
                        <li class="list-group-item"><a href="${pageContext.request.contextPath}/placeList">Places</a></li>
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
                        The world is a book and those who do not travel read only a page
                    </p>
                    <small>Saint Augustine</small>
                </blockquote>
            </div>
            <div class="container features">
                <div class="row">
                    <div class="col-lg-4 col-md-4 col-sm-6">
                        <img src="${pageContext.request.contextPath}/images/france-paris.jpg" class="img-fluid" alt="france">
                        <h3 class="feature-title">France,Paris,The Eiffel Tower</h3>
                        <p>ppreciated for its elegance and joie de vivre, Paris is a grand European capital filled with architectural masterpieces like the Eiffel Tower and the Notre-Dame Cathedral. Reflecting the city's rich heritage, the Louvre (one of the top museums in Paris) contains an exceptional fine arts collection, while the Musée d'Orsay and the Musée de l'Orangerie display treasures of French Impressionist art. Other charms of Paris are its atmospheric medieval quarters and graceful boulevards. Quintessential tourist experiences include shopping at bookshops in the Latin Quarter, strolling the Champs-Elysées, and people-watching from a sidewalk café terrace on the Boulevard Saint-Germain-de-Prés.

                            To see one of the country's most impressive palaces, tourists can take a 30-minute train ride from Paris to Versailles. The UNESCO-listed Château de Versailles is among the best day trips from Paris.</p>
                    </div>
                    <div class="col-lg-4 col-md-4 col-sm-6">
                        <img src="${pageContext.request.contextPath}/images/germany-neuschwanstein-castle.jpg" class="img-fluid" alt="germany">
                        <h3 class="feature-title">Germany</h3>
                        <h3></h3>Neuschwanstein,The Ultimate Fairytale Castle</h3>
                        <p>The quaint old town of Füssen, situated between the Ammergau and Allgäu Alps and a popular alpine resort and winter sports center, is a good base from which to explore nearby Neuschwanstein Castle, one of Europe's most famous (and picturesque) royal castles.

                            King Ludwig II of Bavaria built this many-towered and battlement-covered fantasy fortress - the inspiration for Walt Disney's famous theme park castles - from 1869-86.

                        </p>
                    </div>
                    <div class="col-lg-4 col-md-4 col-sm-6">
                        <img src="${pageContext.request.contextPath}/images/greece-santorini.jpg" class="img-fluid">
                        <h3 class="feature-title">Greece,Santorini</h3>
                        <p>tunning Santorini is the most dramatic of all the Greek isles. It is best known for the west coast cliff-top towns of Fira and Oia, which appear to hang over a deep, blue sea-filled caldera. Made up of typical Cycladic whitewashed cubic buildings, many of which have been converted into boutique hotels with infinity pools, both Fira and Oia are considered romantic destinations, popular for weddings and honeymoons.

                            Things to do in Santorini include sunbathing and swimming at the black volcanic-sand beaches on the south and east coasts and visiting the archaeological site of Akrotiri, an Ancient Minoan settlement buried below lava following the volcanic eruption that created the caldera, some 3,600 years ago. The island has an airport and is served by ferries and catamarans from Athens' port, Piraeus.</p>
                    </div>
                </div>




<%--                <h2>Our trip</h2>--%>
<%--                <div class="trip">--%>
<%--                    <div class="row">--%>
<%--                        <div class="col col-md-4">--%>
<%--                            <img src="" alt="John Doe" class="thumbnail">--%>
<%--                            <div class="caption">--%>
<%--                                <h3>John Doe</h3>--%>
<%--                                <p></p>--%>
<%--                            </div>--%>
<%--                        </div>--%>
<%--                        <div class="col col-md-4 col-md-offset-1">--%>
<%--                            <img src="" alt="Saundra Pittsley" class="thumbnail">--%>
<%--                            <div class="caption">--%>
<%--                                <h3>Saundra Pittsley</h3>--%>
<%--                                <p></p>--%>
<%--                            </div>--%>
<%--                        </div>--%>
<%--                        …--%>
<%--                    </div>--%>
<%--                    <div class="row">--%>
<%--                        <div class="col col-md-4">--%>
<%--                            <img src="" alt="Ericka Nobriga" class="thumbnail">--%>
<%--                            <div class="caption">--%>
<%--                                <h3>Ericka Nobriga</h3>--%>
<%--                                <p></p>--%>
<%--                            </div>--%>
<%--                        </div>--%>
<%--                        <div class="col col-md-4 col-md-offset-1">--%>
<%--                            <img src="" alt="Cody Rousselle" class="thumbnail">--%>
<%--                            <div class="caption">--%>
<%--                                <h3>Cody Rousselle</h3>--%>
<%--                                <p></p>--%>
<%--                            </div>--%>
<%--                        </div>--%>
                        …
<%--                    </div>--%>
<%--                </div>--%>

            </div>
        </section>
    </div>
</div>



<%--<footer class="page-footer">--%>
<%--    <div class="container">--%>
<%--        <div class="row">--%>
<%--            <div class="col-lg-8 col-md-8 col-sm-12">--%>
<%--                <h6 class="text-uppercase font-weight-bold">Additional Information</h6>--%>
<%--                <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque interdum quam odio, quis placerat ante luctus eu. Sed aliquet dolor id sapien rutrum, id vulputate quam iaculis.</p>--%>
<%--                <!-- <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque interdum quam odio, quis placerat ante luctus eu. Sed aliquet dolor id sapien rutrum, id vulputate quam iaculis.</p> -->--%>
<%--            </div>--%>
<%--            <div class="col-lg-4 col-md-4 col-sm-12">--%>
<%--                <h6 class="text-uppercase font-weight-bold">Contact</h6>--%>
<%--                <p>1640 Fedkovycha str., Lviv--%>
<%--                    <br/>info@mywebsite.com--%>
<%--                    <!--  <br/>+ 01 234 567 88 -->--%>
<%--                    <br/>+ 01 234 567 89</p>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--        <div class="footer-copyright text-center">© 2020 Copyright: MyWebsite.com</div>--%>
<%--</footer>--%>
<jsp:include page="/fragments/footer.jsp"/>

</body>
</html>
