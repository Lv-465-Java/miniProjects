<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ page contentType="text/html;charset=UTF-8" language="java" %>

        <!DOCTYPE html>
        <html lang="en">

        <head>
            <title>Edit category</title>
            <meta charset="utf-8">
            <meta name="viewport" content="width=device-width, initial-scale=1">
            <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
            <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
            <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
            <link rel="stylesheet" href=<c:url value="resource/css/file.css"></c:url>>
            <link rel="stylesheet" href=<c:url value="resource/css/forms.css"></c:url>>
        </head>

        <body>

            <form action="delete-category" method="post">

                <div class="form-footer">
                    <input type="button" class="btn btn-secondary" value="Close">
                    </button>
                    <input type="hidden" name="buprofile" value="${category.id}">
                    <input type="submit" class="btn btn-primary">Save changes</input>
                </div>
            </form>
        </body>
        </html>