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
</head>

<body>
<jsp:include page="menu.jsp"/><!--/.nav-collapse -->

<div class="container">

    <c:if test="${user.type == 'Startuper'}">

        <div class="col-sm-4">
            <h3>User startups:</h3>
            <div class="list-group">
                <c:forEach var="project" items="${projectList}">
                    <a href="/projectInfo/${project.getId()}" class="list-group-item">${project.getTitle()}</a>
                </c:forEach>
            </div>
        </div>

        <div class="col-sm-8">
            <h3 align="center">User info</h3>
            <p>${user.getFirstname()} ${user.getLastname()}</p>
            <p>Date Birth: ${user.getDateBirth()}</p>
            <p>Email: ${user.getEmail()}</p>
            <p>About startuper: ${user.getAbout()}</p>
        </div>
    </c:if>

    <c:if test="${user.type != 'Startuper'}">

        <div class="col-sm-12">
            <h3 align="center">User info</h3>
            <p>${user.getFirstname()} ${user.getLastname()}</p>
            <p>Date Birth: ${user.getDateBirth()}</p>
            <p>Email: ${user.getEmail()}</p>
            <p>About startuper: ${user.getAbout()}</p>
        </div>
    </c:if>


</div><!-- /.container -->


</body>
</html>
