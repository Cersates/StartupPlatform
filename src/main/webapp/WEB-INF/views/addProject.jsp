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
    <title>New startup</title>
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

    <f:form method="POST" commandName="project" action="add-project" class="navbar-form navbar-left">

        <h2 class="form-signin-heading">New startup</h2>

        <label for="title" class="sr-only">Title</label>
        <f:input path="title" id="title" class="form-control" placeholder="Sturtup title" size="70"
                 required="required" autofocus="autofocus"/><br><br>

        <label for="description" class="sr-only">Description</label>
        <f:textarea path="description" id="description" class="form-control" rows="5" placeholder="Sturtup description"
                    cols="100" required="required"/><br><br>

        Need for external financing $ <f:input path="financing" class="prices form-control"/><br/><br/>

        <div class="form-group">
            <label for="sel1">Sphere of activity:</label>
            <f:select path="sphere" class="form-control" id="sel1">
                <option>Internet of things</option>
                <option>Online education</option>
                <option>Developing Mobile Applications</option>
                <option>Handheld devices and accessories</option>
                <option>Software for business</option>
                <option>Cybersecurity</option>
                <option>"Green" technology</option>
                <option>Other</option>
            </f:select>
        </div>
        <br/><br/>

        <input type="submit" value="Add startup" class="btn btn-default"/>

    </f:form>

</div> <!-- /container -->


</body>
</html>