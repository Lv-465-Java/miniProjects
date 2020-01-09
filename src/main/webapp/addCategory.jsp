<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ page contentType="text/html;charset=UTF-8" language="java" %>

        <!DOCTYPE html>

        <head>
            <title>Add category</title>
            <meta charset="utf-8">
            <meta name="viewport" content="width=device-width, initial-scale=1">
            <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
            <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
            <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
            <link rel="stylesheet" href="resource/css/file.css">
        </head>

        <body>

            <form action="add-category" method="post">

                <div class="form-header">
                    <h5 class="form-title" name="addCategoryTitle">Add new category</h5>
                    <button type="button" class="close" aria-label="Close">
                        <span aria-hidden="true">&times;</span></button>
                </div>

                <div class="form-group" id="all-forms">
                    <label for="title" class="floatLabel">Title<span class="asterisk">*</span></label>
                    <input id="CategoryTitle" name="title" type="text" required>
                </div>
                <label for="color" class="floatLabel">Color</label>
                <input id="CategoryColor" name="color" type="color">
                <div class="form-group" id="all-forms">
                    <label for="description" class="floatLabel">Description</label>
                    <input id="CategoryDescription" name="description" type="text">
                </div>

                <div class="form-group" id="all-forms">
                    <label for="financial_type">Financial Type</label>
                    <select class="form-select" id="financial-type" name="financial_type" value=<c:out value="${category.financialTypeId}">
                        </c:out>>
                        <option selected disabled>Select type</option>
                        <c:forEach var="financialType" items="${financialTypes}">
                            <option id="option" value="${financialType.id}">${financialType.typeName}</option>
                        </c:forEach>
                    </select>
                </div>

                <div class="form-footer">
                    <input type="button" class="btn btn-secondary" value="Close">
                    </button>
                    <input type="submit" class="btn btn-primary" value="Save changes"></input>
                </div>
            </form>
        </body>