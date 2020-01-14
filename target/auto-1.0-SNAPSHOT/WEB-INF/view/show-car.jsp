<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<link href="${pageContext.request.contextPath}/resources/css/add-car.css" rel="stylesheet">
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script src="http://getbootstrap.com/dist/js/bootstrap.min.js"></script>
<div class="container">
    <div class="row">


        <div class="col-md-12">
            <h2>Cars</h2>
            <div class="table-responsive">
                <form action="/cars" method="post">
                <input width="750px" type="text" name="field" placeholder="Search date">
                </form>
                <table id="mytable" class="table table-bordred table-striped">

                    <thead>


                    <th>Date</th>
                    <th>Brand</th>
                    <th>Model</th>
                    <th>Number</th>
                    <th>Year</th>
                    <th>Vin-Code</th>
                    <th>Name</th>
                    <th>Tel</th>
                    <th>Edit</th>
                    <th>Delete</th>
                    </thead>
                    <tbody>
                    <tr>
                    <c:forEach var="check" items="${requestScope.checks}">
                        <c:forEach var="car" items="${requestScope.cars}">
                            <c:forEach var="client" items="${requestScope.clients}">
                                <c:choose>
                                    <c:when test="${car.id == check.idCar && client.id == check.idClient}">


                                            <td><c:out value="${check.date}"/></td>
                                            <td><c:out value="${car.brand}"/></td>
                                            <td><c:out value="${car.model}"/></td>
                                            <td><c:out value="${car.number}"/></td>
                                            <td><c:out value="${car.year}"/></td>
                                            <td><c:out value="${car.vinCode}"/></td>
                                            <td><c:out value="${client.name}"/></td>
                                            <td><c:out value="${client.tel}"/></td>
                                           <td> <a href="${pageContext.request.contextPath}/edit-car?id=<c:out value='${check.id}' />">Edit</a></td>
                                            <td> <a href="${pageContext.request.contextPath}/delete?id=<c:out value='${check.id}' />">Delete</a>  </td>
                                       </tr>
                                    </c:when>
                                </c:choose>
                            </c:forEach>
                        </c:forEach>
                    </c:forEach>





                    </tbody>

                </table>
                <h3><a href="/add-car">Add Car</a></h3>

                <div class="clearfix"></div>
                <ul class="pagination pull-right">
                    <li class="disabled"><a href="#"><span class="glyphicon glyphicon-chevron-left"></span></a></li>
                    <li class="active"><a href="#">1</a></li>
                    <li><a href="#">2</a></li>
                    <li><a href="#">3</a></li>
                    <li><a href="#">4</a></li>
                    <li><a href="#">5</a></li>
                    <li><a href="#"><span class="glyphicon glyphicon-chevron-right"></span></a></li>
                </ul>

            </div>

        </div>
    </div>
</div>
</div>
</div>


<div class="modal fade" id="edit" tabindex="-1" role="dialog" aria-labelledby="edit" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true"><span class="glyphicon glyphicon-remove" aria-hidden="true"></span></button>
                <h4 class="modal-title custom_align" id="Heading">Edit Your Detail</h4>
            </div>
            <div class="modal-body">
                <div class="form-group">
                    <input class="form-control " type="text" placeholder="Mohsin">
                </div>
                <div class="form-group">

                    <input class="form-control " type="text" placeholder="Irshad">
                </div>
                <div class="form-group">
                    <textarea rows="2" class="form-control" placeholder="CB 106/107 Street # 11 Wah Cantt Islamabad Pakistan"></textarea>


                </div>
            </div>
            <div class="modal-footer ">
                <button type="button" class="btn btn-warning btn-lg" style="width: 100%;"><span class="glyphicon glyphicon-ok-sign"></span> Update</button>
            </div>
        </div>
        <!-- /.modal-content -->
    </div>
    <!-- /.modal-dialog -->
</div>



<div class="modal fade" id="delete" tabindex="-1" role="dialog" aria-labelledby="edit" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true"><span class="glyphicon glyphicon-remove" aria-hidden="true"></span></button>
                <h4 class="modal-title custom_align" id="Heading">Delete this entry</h4>
            </div>
            <div class="modal-body">

                <div class="alert alert-danger"><span class="glyphicon glyphicon-warning-sign"></span> Are you sure you want to delete this Record?</div>

            </div>
            <div class="modal-footer ">
                <button type="button" class="btn btn-success" ><span class="glyphicon glyphicon-ok-sign"></span> Yes</button>
                <button type="button" class="btn btn-default" data-dismiss="modal"><span class="glyphicon glyphicon-remove"></span> No</button>
            </div>
        </div>
        <!-- /.modal-content -->
    </div>
    <!-- /.modal-dialog -->
</div>