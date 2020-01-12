<%--suppress ALL --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="resource/css/file.css">
    <link rel="stylesheet" href="resource/css/forms.css">
</head>
<body>

<div class="color-wrapper">
    <input type="text" readonly name="color" placeholder="#FFFFFF" id="pickcolor" class="call-picker" value="${category.color}">
    <div class="color-holder call-picker" style="background-color: ${category.color}"></div>
    <div class="color-picker" id="color-picker" style="display: none"></div>
</div>

<script>

    var colorList = ['000000', '993300', '333300', '003300', '003366', '000066', '333399', '333333',
        '660000', 'FF6633', '666633', '336633', '336666', '0066FF', '666699', '666666', 'CC3333', 'FF9933', '99CC33', '669966', '66CCCC', '3366FF', '663366', '999999', 'CC66FF', 'FFCC33', 'FFFF66', '99FF66', '99CCCC', '66CCFF', '993366', 'CCCCCC', 'FF99CC', 'FFCC99', 'FFFF99', 'CCffCC', 'CCFFff', '99CCFF', 'CC99FF', 'FFFFFF'];
    var picker = $('#color-picker');

    for (var i = 0; i < colorList.length; i++) {
        picker.append('<li class="color-item" data-hex="' + '#' + colorList[i] + '" style="background-color:' + '#' + colorList[i] + ';"></li>');
    }

    $('body').click(function () {
        picker.fadeOut();
    });

    $('.call-picker').click(function (event) {
        event.stopPropagation();
        picker.fadeIn();
        picker.children('li').hover(function () {
            var codeHex = $(this).data('hex');

            $('.color-holder').css('background-color', codeHex);
            $('#pickcolor').val(codeHex);
        });
    });
</script>

</body>
</html>