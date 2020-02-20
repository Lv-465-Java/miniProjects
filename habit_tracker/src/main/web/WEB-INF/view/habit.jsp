<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: maric
  Date: 1/9/2020
  Time: 2:41 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/style.css"/>">
</head>
<body>
<jsp:include page="/WEB-INF/view/header.jsp"></jsp:include>

<div class="row">
        <jsp:include page='bar.jsp'>
            <jsp:param name="all_habits" value="${all_habits}"/>
            <jsp:param name="name" value="${name}"/>
        </jsp:include>
<div class="col-sm-8">
<h2 id="name">${habit.name}</h2>
    <c:if test="${error ne null}">
        <p class="text-center">
            <font color="red">${error}</font>
        </p>
    </c:if>
<center>
    <div class="habit-calendar-and-desc row">
        <div class="col-sm-6">
    <script language="javascript" type="text/javascript">
        var day_of_week = new Array('Sun','Mon','Tue','Wed','Thu','Fri','Sat');
        var month_of_year = new Array('January','February','March','April','May','June','July','August','September','October','November','December');


        //  DECLARE AND INITIALIZE VARIABLES
        var Calendar = new Date();

        var year = Calendar.getFullYear();     // Returns year
        var month = Calendar.getMonth();    // Returns month (0-11)
        var today = Calendar.getDate();    // Returns day (1-31)
        var weekday = Calendar.getDay();    // Returns day (1-31)

        var DAYS_OF_WEEK = 7;    // "constant" for number of days in a week
        var DAYS_OF_MONTH = 31;    // "constant" for number of days in a month
        var cal;    // Used for printing
        var all_do_date =[];

        Calendar.setDate(1);    // Start the calendar day at '1'
        Calendar.setMonth(month);    // Start the calendar month at now


        /* VARIABLES FOR FORMATTING
        NOTE: You can format the 'BORDER', 'BGCOLOR', 'CELLPADDING', 'BORDERCOLOR'
              tags to customize your caledanr's look. */
        var TR_start = '<TR>';
        var TR_end = '</TR>';
        var highlight_start = '<TD WIDTH="30" bgcolor="#bebf9b"  style="box-shadow:"><CENTER>';
        var highlight_end   = '</CENTER></TD>';
        var TD_start = '<TD WIDTH="30" ><CENTER>';
        var TD_end = '</CENTER></TD>';
        var TD_start_do_date = '<TD WIDTH="30" bgcolor="#87a08b"><CENTER>';
        var TD_end_do_date = '</CENTER></TD>';

        /* BEGIN CODE FOR CALENDAR
        NOTE: You can format the 'BORDER', 'BGCOLOR', 'CELLPADDING', 'BORDERCOLOR'
        tags to customize your calendar's look.*/

        cal =  '<TABLE BORDER=1 CELLSPACING=0 CELLPADDING=0 BORDERCOLOR=BBBBBB><TR><TD>';
        cal += '<TABLE BORDER=0 CELLSPACING=0 CELLPADDING=2>' + TR_start;
        cal += '<TD COLSPAN="' + DAYS_OF_WEEK + '" BGCOLOR="#EFEFEF"><CENTER><B>';
        cal += month_of_year[month]  + '   ' + year + '</B>' + TD_end + TR_end;
        cal += TR_start;

        //   DO NOT EDIT BELOW THIS POINT  //

        // LOOPS FOR EACH DAY OF WEEK
        for(index=0; index < DAYS_OF_WEEK; index++)
        {

// BOLD TODAY'S DAY OF WEEK
            if(weekday == index)
                cal += TD_start + '<B>' + day_of_week[index] + '</B>' + TD_end;
// PRINTS DAY
            else
                cal += TD_start + day_of_week[index] + TD_end;
        }

        cal += TD_end + TR_end;
        cal += TR_start;

        // FILL IN BLANK GAPS UNTIL TODAY'S DAY
        for(index=0; index < Calendar.getDay(); index++)
            cal += TD_start + '  ' + TD_end;

        // LOOPS FOR EACH DAY IN CALENDAR
        for(index=0; index < DAYS_OF_MONTH; index++)
        {
            if( Calendar.getDate() > index )
            {
                // RETURNS THE NEXT DAY TO PRINT
                week_day = Calendar.getDay();

                // START NEW ROW FOR FIRST DAY OF WEEK
                if(week_day == 0)
                    cal += TR_start;

                if(week_day != DAYS_OF_WEEK)
                {

                    // SET VARIABLE INSIDE LOOP FOR INCREMENTING PURPOSES
                    var day = Calendar.getDate();
                    <%--var arr = ${habit.do_date}.includes;--%>
                    <%--.includes('Erlich')--%>
                    if(${habit.do_date}.includes(day))
                        cal += TD_start_do_date + day + TD_end_do_date;
                    else if( today==day )
                        cal += highlight_start + day + highlight_end + TD_end;
                    else
                        cal += TD_start + day + TD_end;
                }

                // END ROW FOR LAST DAY OF WEEK
                if(week_day == DAYS_OF_WEEK)
                    cal += TR_end;
            }

            // INCREMENTS UNTIL END OF THE MONTH
            Calendar.setDate(Calendar.getDate()+1);

        }// end for loop

        cal += '</TD></TR></TABLE></TABLE>';

        //  PRINT CALENDAR
        document.write(cal);

        //  End -->
    </script></div>
        <div class="col-sm-6">
            <div class="habit-desc">
    <h4>Description</h4>
                <div class="desc-link">
                <a href="<c:url value="/edit_habit_description/${id}"/>">Edit description</a></div></div>
    <h5>${habit.description}</h5>
    </div>
    </div>
</center>
    <c:if test="${habit.first_date ne null}">

        <h3 class="mt-2">You start doing this habit <span class="habit-counter">${habit.first_date}</span></h3>
</c:if>
    <h3 class="mt-2">You have done your habits <span class="habit-counter">${habit.amount_of_do_date}</span> times</h3>
    <h3 class="mt-2">Your best strike is <span class="habit-counter">${habit.habit_strike}</span>  days</h3>
    <br/>
    <a href="<c:url value="/delete_habit/${id}"/>" >Delete habit</a>
</div>
</div>
</body>
</html>
