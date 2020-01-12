<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Date picker</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

</head>
<body>

<div class="container">
    <div class="row">
        <div class='col-sm-3'>
            <div class="form-group">
                <div id="filterDate2">

                    <div class="input-group" id="RecordDate" data-date-format="dd.mm.yyyy">
                        <input type="date" class="form-control" id="datepicker" placeholder="dd.mm.yyyy">
                    </div>

                </div>
            </div>
        </div>
    </div>
</div>


<script>
    $(function () {
        $("#datepicker").datepicker();
    });
</script>


</body>
</html>