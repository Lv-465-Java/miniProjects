<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<link href="${pageContext.request.contextPath}/resources/css/add-car.css" rel="stylesheet">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<div align="center" class="container ">
    <div class="row">

        <div class="col-md-4">
            <div class="form_main">
                <div class="css1" >
                <h4 class="heading"><strong>Add </strong> Car <span></span></h4>
                <div class="form">
<form method="post" action="/add-car" id="contactFrm" name="contactFrm">

<label><input type="text" name="brand"placeholder="Brand"class="txt"></label><br>
<label><input type="text" name="model" placeholder="model" class="txt"></label><br>
<label><input type="number" name="year" placeholder="year" class="txt"></label><br>
<label><input type="text" name="number"  placeholder="number" class="txt"></label><br>
<label><input type="text" name="vinCode"  placeholder=" vinCode" class="txt"></label><br>
<label><input type="text" name="date"  placeholder="date" class="txt"></label><br>
    <label><input type="text" name="name"  placeholder="name" class="txt"></label><br>
    <label><input type="number" name="tel" placeholder="tel" class="txt"></label><br>
    <input type="submit" value="Save" name="Save" class="txt2">
</form>
                </div>
            </div>
        </div>
        </div>
    </div>
</div>

