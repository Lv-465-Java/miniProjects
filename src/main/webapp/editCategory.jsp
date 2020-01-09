<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>

<head>
    <title>Edit category</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="resource/css/file.css">
</head>

<body>

    <div class="modal fade" id="editCategory" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
                <div class="modal-dialog modal-dialog-centered" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="exampleModalLongTitle">Edit category</h5>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>

                        <div class="modal-body">
                            <form method="post" action="<c:url value="edit-category"/>">

                                <label for="Title" class="floatLabel">Title<span class="asterisk">*</span></label>
                                <input id="title" name="title" type="text" required value=<c:out value="${category.title}">
                                </c:out>>
                                <label for="Color" class="floatLabel">Color</label>
                                <input id="color" name="color" type="color" value=<c:out value="${category.color}">
                                </c:out>>
                                <label for="Description" class="floatLabel">Description</label>
                                <input id="description" name="description" type="text" value=<c:out value="${category.description}">
                                </c:out>>

                        <label for="financial-type">Financial Type</label>
                          <select class="browser-default custom-select" id="financial-type" name="financial_type"
                          value=<c:out value="${category.financialTypeId}"> </c:out>>
                            <c:forEach var="financialType" items="${financialTypes}">
                            <option id="option-1" value="${financialType.id}">${financialType.typeName}</option>
                            </c:forEach>
                          </select>

                                <div class="modal-footer">
                                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                                    <input type="submit" class="btn btn-primary" value="Save changes">
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>

</body>