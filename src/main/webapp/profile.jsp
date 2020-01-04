<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<head>
<title>My profile</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<link rel="stylesheet" href="css\header.css">
<link rel="stylesheet" href="css\profile.css">
</head>

<body>

    <div class="header container">
        <a>Profile</a>
        <a>Records</a>
        <a>Planned Outcomes</a>
        <a>Logout</a>
    </div>

    <div class="profileContainer">

        <div class="profileInfo">
        <p id="profileName">Halina Fisher</p>
        <p id="profileEmail">halina.fisher@gmail.com</p>
        <p id="profilePassword">Change password</p>
        </div>

    </div>

</body>
</html>