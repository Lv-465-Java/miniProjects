<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Car Service</title>
</head>
<body>
<div style="text-align: center;">
    <h1>Cars Management</h1>
    <h2>
        <a href="${pageContext.request.contextPath}/add-car">Add New Car</a>
        &nbsp;&nbsp;&nbsp;
        <a href="${pageContext.request.contextPath}/admin/cars">List All Cars</a>
    </h2>
</div>
<div align="center">

    <c:if test="${check != null}">
    <form action="/update" method="post">
        </c:if>
        <c:if test="${check != null}">
        <form action="/add-car" method="post">
            </c:if>
            <table border="1" cellpadding="5">
                <caption>
                    <h2>
                        <c:if test="${check != null}">
                            Edit Car
                        </c:if>
                        <c:if test="${check == null}">
                            Add New Car
                        </c:if>
                    </h2>
                </caption>
                <c:if test="${check != null}">
                    <input type="hidden" name="id" value="<c:out value='${check.id}' />"/>
                </c:if>
                <tr>
                    <th>Date:</th>
                    <td>
                        <input type="text" name="date" size="45"
                               value="<c:out value='${check.date}' />"
                        />
                    </td>
                </tr>
                <tr>
                    <td colspan="2" align="center">
                        <input type="submit" name="save" value="Save"/>
                    </td>
                </tr>
            </table>
        </form>
</div>
</body>
</html>
