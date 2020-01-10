<%@ page contentType="text/html;charset=UTF-8" language="java" %>

    <!DOCTYPE html>
    <html lang="en">

    <head>
        <title>404</title>
        <meta charset="UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
        <link rel="stylesheet" href="resource/css/file.css">

    </head>

    <body>
        <div class="errorsContainer">
            <h1 id="errorName">404</h1>
            <h2>Incorrectly typed address,<br>or page no longer exists on site</h2>
            <p class="referenceToMainPage">Go to <a href="/login">Sign in</a></p>
        </div>
    </body>

    </html>

                                          <input type="hidden" name="buprofile" value="${category.id}">


    <input type="submit" name="edit_category" class="btn btn-outline-warning" value="Edit category">
                                                <a href="/edit-category"></a>

                                                <button type="button" class="btn btn-info btn-lg" name="editCategory">
                                                    <a href=<c:url value="/edit-category">
                                                        <c:param name="category_id " value="${category.id}" />
                                                        </c:url>>
                                                </button>

                                                [type="submit"]
                                                {
                                                	margin-top: 25px;
                                                	width: 80%;
                                                	border: 0;
                                                	background-color: #2038bd;
                                                	border-radius: 5px;
                                                	height: 50px;
                                                	color: white;
                                                	font-weight: 400;
                                                	font-size: 1em;
                                                }