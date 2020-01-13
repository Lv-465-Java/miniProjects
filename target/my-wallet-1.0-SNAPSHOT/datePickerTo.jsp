<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Date picker</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.6.1/js/bootstrap-datepicker.min.js"></script>

</head>
<body>

<br/>
<div class="row">
    <div class='col-sm-3'>
        <div class="form-group">
            <div id="filterDate2">

                <div class="input-group date" data-date-format="dd.mm.yyyy">
                    <input type="text" id="datePickerDateTo" name="toDate" class="form-control" placeholder="yyyy-mm-dd">
                    <div class="input-group-addon">
                        <span class="glyphicon glyphicon-th"></span>
                    </div>
                </div>

            </div>
        </div>
    </div>
</div>


<script>
    $('.input-group.date').datepicker({format: "yyyy-mm-dd"});
</script>


</body>
</html>