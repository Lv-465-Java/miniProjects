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

    <div class="nav navbar-nav">
        <div class="row">
            <div class="col-1"></div>
            <div class= col-3>
                <a class="nav-link" href="#">${userDto.username}</a>
            </div>
            <div class="col-3">
                <a class="nav-link" href="${pageContext.request.contextPath}/logout">Log out</a>
            </div>
        </div>
    </div>


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
                            </ul>
                        </li>
                        <li class="list-group-item">Comments
                            <ul>
                                <li><a href="${pageContext.request.contextPath}/createComment">Create comment</a></li>
                                <li><a href="${pageContext.request.contextPath}/commentList">Get all comment</a></li>
                            </ul>
                        </li>
                        <li class="list-group-item">Trips
                            <ul>
                                <li><a href="${pageContext.request.contextPath}/createTrip">Create trip</a></li>
                                <li><a href="${pageContext.request.contextPath}/tripList">Get all trips</a></li>
                            </ul>
                        </li>
                        <li class="list-group-item">Transports
                        <ul>
                            <li><a href="${pageContext.request.contextPath}/createTransport">Create transport</a></li>
                            <li><a href="${pageContext.request.contextPath}/transportList">Get all transport</a></li>
                        </ul>
                        </li>
                        <li class="list-group-item">Users
                        <ul>
                            <li><a href="${pageContext.request.contextPath}/registration">Create user</a></li>
                            <li><a href="${pageContext.request.contextPath}/userList">Get all users</a></li>
                        </ul>
                        </li>
                        <li class="list-group-item">Rates
<%--                        <ul>--%>
<%--                            --%>
<%--                            <li><a href="${pageContext.request.contextPath}/deleteRate">Delete rate</a></li>--%>
<%--                        </ul>--%>
<%--                        </li>--%>
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

                        </p>
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

                            Things to do in Santorini include sunbathing and swimming at the black volcanic-sand beaches on the south and east coasts and visiting the archaeological site of Akrotiri, an Ancient Minoan settlement buried below lava following the volcanic eruption that created the caldera, some 3,600 years ago.</p>
                    </div>
                </div>
            </div>
        </section>
    </div>
</div>


<jsp:include page="/fragments/footer.jsp"/>

</body>
</html>

