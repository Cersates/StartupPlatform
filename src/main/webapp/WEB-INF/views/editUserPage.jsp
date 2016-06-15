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
            $("#datetimepicker1").datetimepicker({
                pickTime: false,
                maxDate: new Date(),
                defaultDate: new Date()
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

    <f:form method="post" commandName="user" action="editUser" cssClass='form-signin'>
        <h2 class="form-signin-heading">Edit info about me</h2>

        <label for="inputEmail" class="sr-only">Email address</label>
        <f:input path="email" type="email" id="inputEmail" class="form-control" placeholder="Email address"
                 required="required" autofocus="autofocus" value="${userSession.email}"/><br>

        <label for="inputFirstname" class="sr-only">Firstname</label>
        <f:input path="firstname" id="inputFirstname" class="form-control" placeholder="Firstname"
                 required="required" autofocus="autofocus" value="${userSession.firstname}"/><br>

        <label for="inputLastname" class="sr-only">Lastname</label>
        <f:input path="lastname" id="inputLastname" class="form-control" placeholder="Lastname"
                 required="required" autofocus="autofocus" value="${userSession.lastname}"/><br>

        <label for="about" class="sr-only">About</label>
        <f:textarea path="about" id="about" class="form-control" rows="2" placeholder="About"
                    cols="50" value="${userSession.about}"/><br>


        <input type="submit" value="Update" class="btn btn-lg btn-primary btn-block"/>
    </f:form>

</div><!-- /.container -->


</body>
</html>
