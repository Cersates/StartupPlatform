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

    <form method="POST" commandName="project" action="search-result" class="navbar-form navbar-left" role="search">


        <br/>
        <br/>
        <div class="row">
            <div class="col-xs-6">
                <div class="form-group">
                    <div class="input-group date" id="datetimepicker1">
                        <label>Sturtup registration from:</label>
                        <input name="dateRegistrationFrom" type="text" class="form-control"/>
                        <span class="input-group-addon">
                            <span class="glyphicon glyphicon-calendar"></span>
                        </span>
                    </div>
                </div>
            </div>
            <div class="col-xs-6">
                <div class="form-group">
                    <div class="input-group date" id="datetimepicker2">
                        <label>Sturtup registration to:</label>
                        <input name="dateRegistrationTo" type="text" class="form-control"/>
                        <span class="input-group-addon">
                            <span class="glyphicon glyphicon-calendar"></span>
                        </span>
                    </div>
                </div>
            </div>
        </div>
        <br/>

        <div class="form-group">
            <label for="sel1">Sphere of activity:</label>
            <select name="sphere" class="form-control" id="sel1">
                <option>Internet of things</option>
                <option>Online education</option>
                <option>Developing Mobile Applications</option>
                <option>Handheld devices and accessories</option>
                <option>Software for business</option>
                <option>Cybersecurity</option>
                <option>"Green" technology</option>
                <option>Other</option>
            </select>
        </div>

        <c:if test="${userSession.type == 'Investor'}">

            <br/>
            <br/>
            <p>Need for external financing</p>
            from $ <input name="financingFrom" class="prices form-control"/> to $ <input
                name="financingTo" class="prices form-control"/>
        </c:if>

        <c:if test="${userSession.type != 'Investor'}">

            from $ <input type="hidden" name="financingFrom" class="prices form-control"/> to $ <input type="hidden"
                                                                                                       name="financingTo"
                                                                                                       class="prices form-control"/>
        </c:if>

        <br/>
        <br/>
        <div class="form-group">
            <input name="title" type="text" class="form-control" size='70' placeholder="Title of sturtup"/>
        </div>
        <br/>
        <br/>
        <button type="submit" class="btn btn-default">Search</button>
    </form>


    <div class="col-sm-12">
        <h3>Found:</h3>
        <c:if test="${not empty resultSearch}">
            <div class="list-group">
                <c:forEach var="project" items="${resultSearch}">
                    <a href="/projectInfo/${project.getId()}" class="list-group-item">${project.getTitle()}</a>
                </c:forEach>
            </div>
        </c:if>
    </div>


</div><!-- /.container -->


</body>
</html>
