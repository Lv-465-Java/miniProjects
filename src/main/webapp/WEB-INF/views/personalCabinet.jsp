<%--
  Created by IntelliJ IDEA.
  User: int
  Date: 11.01.20
  Time: 16:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Personal cabinet</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
    <link rel="stylesheet" type="text/css" href="$css/mainPage.css"/>
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
            <div class="col-5">
                <a class="nav-link" href="${pageContext.request.contextPath}/personalCabinet">Personal cabinet</a>
            </div>
            <div class="col-3">
                <a class="nav-link" href="${pageContext.request.contextPath}/logout">Log out</a>
            </div>
        </div>
    </div>


    <div class="heading"></div>
    <form action="${pageContext.request.contextPath}/uploadPoster" method="post" enctype="multipart/form-data" name="poster">
    <div class="row">
        <div class="col-4">
            <input type="file" name="file"/>
            <input type="submit" value="Upload">
        </div>
        <img src="${pageContext.request.contextPath}/posters/${fileName}" alt="poster" height="100" width="250">
    </div>
    </form>


    <div class="row">
        <aside class="col-md-3">
            <div class="panel panel-primary">
                <div class="panel-heading">MY MENU</div>
                <div class="panel-body">
                    <ul class="list-group submenu">
                        <li class="list-group-item active">
                            <a href="${pageContext.request.contextPath}/editUser">Edit profile</a></li>
                        <li class="list-group-item">Comments
                            <ul>
                                <li><a href="${pageContext.request.contextPath}/getUserComment">My comments</a></li>
                                <li><a href="${pageContext.request.contextPath}/createComment">Create comment</a></li>
                                <li>Get comment by date</li>
                                <li><a href="${pageContext.request.contextPath}/editComment">Update comment</a></li>
                                <li>Update comment by place</li>
                                <li><a href="${pageContext.request.contextPath}/deleteComment">Delete comment</a></li>
                            </ul>
                        </li>
                        <li class="list-group-item">Trips
                            <ul>
                                <li><a href="${pageContext.request.contextPath}/getUserTrip">My trips</a></li>
                                <li><a href="${pageContext.request.contextPath}/createTrip">Create trip</a></li>
                                <li>Get trip by departure day</li>
                                <li><a href="${pageContext.request.contextPath}/editTrip">Update trip</a></li>
                                <li>Update day of arrival</li>
                                <li><a href="${pageContext.request.contextPath}/deleteTrip">Delete trip</a></li>
                                <li>Delete trip by departure day</li>
                            </ul>
                        </li>
                        <li class="list-group-item"><a href="${pageContext.request.contextPath}/evaluatePlace">Evaluate the place</a></li>
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
                    <!-- <div class="col-lg-4 col-md-4 col-sm-12">
                      <h3 class="feature-title">France,Paris,The Eiffel Tower</h3>
                      <img src="/home/int/Download/Foto/france-paris.jpg" class="img-fluid">
                      <p>ppreciated for its elegance and joie de vivre, Paris is a grand European capital filled with architectural masterpieces like the Eiffel Tower and the Notre-Dame Cathedral. Reflecting the city's rich heritage, the Louvre (one of the top museums in Paris) contains an exceptional fine arts collection, while the Musée d'Orsay and the Musée de l'Orangerie display treasures of French Impressionist art. Other charms of Paris are its atmospheric medieval quarters and graceful boulevards. Quintessential tourist experiences include shopping at bookshops in the Latin Quarter, strolling the Champs-Elysées, and people-watching from a sidewalk café terrace on the Boulevard Saint-Germain-de-Prés.

            To see one of the country's most impressive palaces, tourists can take a 30-minute train ride from Paris to Versailles. The UNESCO-listed Château de Versailles is among the best day trips from Paris. Built for Louis XIV (the "Sun King"), this opulent 17th-century palace is a testament to the glory and absolute power that was once the realm of France's kings. The château's splendid Baroque facade, dazzling Hall of Mirrors, and fountain-adorned formal gardens allow visitors to imagine a scene of France's bygone royal court.</p>
                    </div>
                    <div class="col-lg-4 col-md-4 col-sm-12">
                      <h3 class="feature-title">Germany,Neuschwanstein,The Ultimate Fairytale Castle</h3>
                      <img src="/home/int/Download/Foto/germany-neuschwanstein-castle.jpg" class="img-fluid">
                      <p>The quaint old town of Füssen, situated between the Ammergau and Allgäu Alps and a popular alpine resort and winter sports center, is a good base from which to explore nearby Neuschwanstein Castle, one of Europe's most famous (and picturesque) royal castles.

            King Ludwig II of Bavaria built this many-towered and battlement-covered fantasy fortress - the inspiration for Walt Disney's famous theme park castles - from 1869-86.

            A variety of tour options are offered, including guided tours of the sumptuous interior taking in the Throne Room, the Singers' Hall... and some of the country's most spectacular views.</p>
                    </div>
                    <div class="col-lg-4 col-md-4 col-sm-12">
                     <h3 class="feature-title">Greece,Santorini</h3>
                      <img src="/home/int/Download/Foto/greece-santorini.jpg" class="img-fluid">
                      <p>tunning Santorini is the most dramatic of all the Greek isles. It is best known for the west coast cliff-top towns of Fira and Oia, which appear to hang over a deep, blue sea-filled caldera. Made up of typical Cycladic whitewashed cubic buildings, many of which have been converted into boutique hotels with infinity pools, both Fira and Oia are considered romantic destinations, popular for weddings and honeymoons.

            Things to do in Santorini include sunbathing and swimming at the black volcanic-sand beaches on the south and east coasts and visiting the archaeological site of Akrotiri, an Ancient Minoan settlement buried below lava following the volcanic eruption that created the caldera, some 3,600 years ago. The island has an airport and is served by ferries and catamarans from Athens' port, Piraeus.</p>
                    </div> -->
                </div>




                <!--  <h2>Our trip</h2>
                   <div class="trip">
             <div class="row">
               <div class="col col-md-4">
                 <img src="/images/team/Doe.jpg" alt="John Doe" class="thumbnail">
                 <div class="caption">
                   <h3>John Doe</h3>
                   <p></p>
                 </div>
               </div>
               <div class="col col-md-4 col-md-offset-1">
                 <img src="/images/team/Pittsley.jpg" alt="Saundra Pittsley" class="thumbnail">
                 <div class="caption">
                   <h3>Saundra Pittsley</h3>
                   <p></p>
                 </div>
               </div>
               …
             </div>
             <div class="row">
               <div class="col col-md-4">
                 <img src="/images/team/Nobriga.jpg" alt="Ericka Nobriga" class="thumbnail">
                 <div class="caption">
                   <h3>Ericka Nobriga</h3>
                   <p></p>
                 </div>
               </div>
               <div class="col col-md-4 col-md-offset-1">
                 <img src="/images/team/Rousselle.jpg" alt="Cody Rousselle" class="thumbnail">
                 <div class="caption">
                   <h3>Cody Rousselle</h3>
                   <p></p>
                 </div>
               </div>
               …
             </div>
           </div> -->

            </div>
        </section>
    </div>
</div>


<jsp:include page="/fragments/footer.jsp"/>
</body>
</html>
