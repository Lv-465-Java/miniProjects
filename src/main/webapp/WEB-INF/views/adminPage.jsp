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
    <title>Admin Page</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
    <link rel="stylesheet" type="text/css" href="css/mainPage.css"/>
</head>
<body>
<div class="wrapper container">
    <jsp:include page="/fragments/header.jsp"/>

    <nav class="navbar navbar-default">
        <ul class="nav navbar-nav">
            <div class="row">
                <div class="col-md-10">
                    <li class="nav-item">
                        <a class="nav-link" href="#">Admin Page</a>
                    </li>
                </div>
<%--                <div class="col-md-4">--%>
<%--                    <li class="nav-item">--%>
<%--                        <a class="nav-link" href="#">Personal cabinet</a>--%>
<%--                    </li>--%>
<%--                </div>--%>
                <div class="col-md-10">
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
                <div class="panel-heading">ADMIN MENU</div>
                <div class="panel-body">
                    <ul class="list-group submenu">
                        <li class="list-group-item">Places
                            <ul>
                                <li><a href="${pageContext.request.contextPath}/createPlace">Create place</a></li>
                                <li><a href="${pageContext.request.contextPath}/placeList">Get all places</a></li>
                                <li><a href="${pageContext.request.contextPath}/editPlace">Update place</a></li>
                                <li><a href="${pageContext.request.contextPath}/editPlaceDescription">Update place description</a></li>
                                <li><a href="${pageContext.request.contextPath}/deletePlace">Delete place</a></li>
                            </ul>
                        </li>
                        <li class="list-group-item">Comments
                            <ul>
                                <li><a href="${pageContext.request.contextPath}/createComment">Create comment</a></li>
                                <li><a href="${pageContext.request.contextPath}/commentList">Get all comment</a></li>
                                <li>Get comment by id</li>
                                <li>Get comment by date</li>
                                <li>Update comment</li>
                                <li><a href="${pageContext.request.contextPath}/deleteComment">Delete comment</a></li>
                            </ul>
                        </li>
                        <li class="list-group-item">Trips
                            <ul>
                                <li><a href="${pageContext.request.contextPath}/createTrip">Create trip</a></li>
                                <li><a href="${pageContext.request.contextPath}/tripList">Get all trips</a></li>
                                <li>Get trip by id</li>
                                <li>Update trip</li>
                                <li><a href="${pageContext.request.contextPath}/deleteTrip">Delete trip</a></li>
                            </ul>
                        </li>
                        <li class="list-group-item">Transports
                        <ul>
                            <li><a href="${pageContext.request.contextPath}/createTransport">Create transport</a></li>
                            <li><a href="${pageContext.request.contextPath}/transportList">Get all transport</a></li>
                               <li>Get transport by id</li>
<%--                               <li>Update transport</li>--%>
                            <li><a href="${pageContext.request.contextPath}/deleteTransport">Delete transport</a></li>
                        </ul>
                        </li>
                        <li class="list-group-item">Users
                        <ul>
                            <li><a href="${pageContext.request.contextPath}/registration">Create user</a></li>
                            <li><a href="${pageContext.request.contextPath}/userList">Get all users</a></li>
                              <li>Get user by id</li>
                              <li>Get user by username</li>
                            <li><a href="${pageContext.request.contextPath}/editUser">Update user</a></li>
                            <li><a href="${pageContext.request.contextPath}/deleteUser">Delete user</a></li>
                        </ul>
                        </li>
                        <li class="list-group-item">Rates
                        <ul>
                              <li>Create rate</li>
                            <li><a href="${pageContext.request.contextPath}/rateList">Get all rates</a></li>
                              <li>Update rate</li>
                            <li><a href="${pageContext.request.contextPath}/deleteRate">Delete rate</a></li>
                        </ul>
                        </li>
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
                <div class="row">
                    <div class="col-lg-4 col-md-4 col-sm-12">
                        <h3 class="feature-title">France,Paris,The Eiffel Tower</h3>
                        <img src="${pageContext.request.contextPath}/images/france-paris.jpg" class="img-fluid">
                        <p>ppreciated for its elegance and joie de vivre, Paris is a grand European capital filled with architectural masterpieces like the Eiffel Tower and the Notre-Dame Cathedral. Reflecting the city's rich heritage, the Louvre (one of the top museums in Paris) contains an exceptional fine arts collection, while the Musée d'Orsay and the Musée de l'Orangerie display treasures of French Impressionist art. Other charms of Paris are its atmospheric medieval quarters and graceful boulevards. Quintessential tourist experiences include shopping at bookshops in the Latin Quarter, strolling the Champs-Elysées, and people-watching from a sidewalk café terrace on the Boulevard Saint-Germain-de-Prés.

                            To see one of the country's most impressive palaces, tourists can take a 30-minute train ride from Paris to Versailles. The UNESCO-listed Château de Versailles is among the best day trips from Paris. Built for Louis XIV (the "Sun King"), this opulent 17th-century palace is a testament to the glory and absolute power that was once the realm of France's kings. The château's splendid Baroque facade, dazzling Hall of Mirrors, and fountain-adorned formal gardens allow visitors to imagine a scene of France's bygone royal court.</p>
                    </div>
                    <div class="col-lg-4 col-md-4 col-sm-12">
                        <h3 class="feature-title">Germany,Neuschwanstein,The Ultimate Fairytale Castle</h3>
                        <img src="${pageContext.request.contextPath}/images/germany-neuschwanstein-castle.jpg" class="img-fluid">
                        <p>The quaint old town of Füssen, situated between the Ammergau and Allgäu Alps and a popular alpine resort and winter sports center, is a good base from which to explore nearby Neuschwanstein Castle, one of Europe's most famous (and picturesque) royal castles.

                            King Ludwig II of Bavaria built this many-towered and battlement-covered fantasy fortress - the inspiration for Walt Disney's famous theme park castles - from 1869-86.

                            A variety of tour options are offered, including guided tours of the sumptuous interior taking in the Throne Room, the Singers' Hall... and some of the country's most spectacular views.</p>
                    </div>
                    <div class="col-lg-4 col-md-4 col-sm-12">
                        <h3 class="feature-title">Greece,Santorini</h3>
                        <img src="${pageContext.request.contextPath}/images/greece-santorini.jpg" class="img-fluid">
                        <p>tunning Santorini is the most dramatic of all the Greek isles. It is best known for the west coast cliff-top towns of Fira and Oia, which appear to hang over a deep, blue sea-filled caldera. Made up of typical Cycladic whitewashed cubic buildings, many of which have been converted into boutique hotels with infinity pools, both Fira and Oia are considered romantic destinations, popular for weddings and honeymoons.

                            Things to do in Santorini include sunbathing and swimming at the black volcanic-sand beaches on the south and east coasts and visiting the archaeological site of Akrotiri, an Ancient Minoan settlement buried below lava following the volcanic eruption that created the caldera, some 3,600 years ago. The island has an airport and is served by ferries and catamarans from Athens' port, Piraeus.</p>
                    </div>
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

            </div>
        </section>
    </div>
</div>


<jsp:include page="/fragments/footer.jsp"/>

</body>
</html>

