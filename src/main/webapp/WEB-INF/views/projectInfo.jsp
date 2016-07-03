<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>

<c:if test="${empty userSession}">
    <c:redirect url="/login"/>
</c:if>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>Home</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <%--<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">--%>
    <!-- Bootstrap core CSS -->
    <link href="/resources/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <!-- Custom styles for this template -->
    <link href="/resources/css/starter-template.css" rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
    <!-- 2. Подключить скрипт moment-with-locales.min.js для работы с датами -->
    <script type="text/javascript" src="/resources/datetimepicker/js/moment-with-locales.min.js"></script>
    <!-- 4. Подключить скрипт виджета "Bootstrap datetimepicker" -->
    <script type="text/javascript" src="/resources/datetimepicker/js/bootstrap-datetimepicker.min.js"></script>
    <!-- 6. Подключить CSS виджета "Bootstrap datetimepicker" -->
    <link rel="stylesheet" href="/resources/datetimepicker/css/bootstrap-datetimepicker.min.css"/>

    <!-- Инициализация виджета "Bootstrap datetimepicker" -->
    <script type="text/javascript">
        $(function () {
            //Инициализация datetimepicker1 и datetimepicker2
            $("#datetimepicker1").datetimepicker({pickTime: false, maxDate: new Date(), defaultDate: new Date()});
            $("#datetimepicker2").datetimepicker({pickTime: false, maxDate: new Date(), defaultDate: new Date()});
            //При изменении даты в 8 datetimepicker, она устанавливается как минимальная для 9 datetimepicker
            $("#datetimepicker1").on("dp.change", function (e) {
                $("#datetimepicker2").data("DateTimePicker").setMinDate(e.date);
            });
            //При изменении даты в 9 datetimepicker, она устанавливается как максимальная для 8 datetimepicker
            $("#datetimepicker2").on("dp.change", function (e) {
                $("#datetimepicker1").data("DateTimePicker").setMaxDate(e.date);
            });
        });
    </script>

    <script language="JavaScript" type="text/javascript">
        $(document).ready(function () {
            $('.prices').keypress(function (e) {
                if (!(e.which == 8 || e.which == 44 || e.which == 45 || e.which == 46 || (e.which > 47 && e.which < 58))) return false;
            });
        });
    </script>


</head>
<body>
<jsp:include page="menu.jsp"/><!--/.nav-collapse -->

<div class="container">

    <%--<div class="col-sm-4">--%>

    <%--<p>Date Birth: ${user.getDateBirth()}</p>--%>
    <%--<p>Email: ${user.getEmail()}</p>--%>
    <%--<p>About startuper: ${user.getAbout()}</p>--%>
    <%--</div>--%>


    <div class="col-sm-8">
        <%--<c:if test="${!empty info}">--%>
        <div class="page-header">
            <h1>${project.getTitle()}</h1>
        </div>
        <div>
            <a href="/addToFavorites/${project.getId()}" type="button" class="btn btn-xs btn-success">Add to
                favorite</a>
            <a href="/removeFromFavorites/${project.getId()}" type="button" class="btn btn-xs btn-danger">Remove from
                favorite</a>
            <br/>
            Founder: <a href="/userInfo/${user.getId()}"> ${user.getFirstname()} ${user.getLastname()}</a><br/>
            Date registration: ${project.getDateRegistration()}<br/>
            Need for external financing: ${project.getFinancing()}<br/>
            Sphere of activity: ${project.getSphere()}<br/><br/>
        </div>
        <div class="well">
            <p>${project.getDescription()}</p>
        </div>
        <%--</c:if>--%>
    </div>


    <%--Title--%>
    <%--Description--%>
    <%--Date registration--%>
    <%--Need for external financing--%>
    <%--Sphere of activity:--%>


</div><!-- /.container -->


</body>
</html>
