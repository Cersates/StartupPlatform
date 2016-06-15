<%@page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>

<c:if test="${not empty userSession}">
    <c:redirect url="/homeUser"/>
</c:if>

<html>
<head>
    <title>Authorization</title>
    <!-- Bootstrap core CSS -->
    <link href="/resources/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <!-- Custom styles for this template -->
    <%--<link href="./css/signin.css" rel="stylesheet">--%>
    <link href="/resources/css/signin.css" rel="stylesheet">
</head>
<body>


<div class="container">


    <f:form method="POST" modelAttribute="user" action="login" cssClass='form-signin'>
        <c:out value="${userSession.type}"/>
        <h2 class="form-signin-heading">Please sign in</h2>
        <label for="inputEmail" class="sr-only">Email address</label>
        <f:input path="email" type="email" id="inputEmail" class="form-control" placeholder="Email address"
                 required="required" autofocus="autofocus"
                 value="aaa@aaa"/><br>

        <label for="inputPassword" class="sr-only">Password</label>
        <f:input path="password" type="password" id="inputPassword" class="form-control" placeholder="Password"
                 required="required"
                 value="aaa"/><br>

        <c:if test="${not empty message}">
            <div class="alert alert-danger" role="alert">
                <c:out value="${message}"/>
            </div>
        </c:if>

        <input type="submit" value="Sign in" class="btn btn-lg btn-primary btn-block"/>
        <a href="/registration" class="btn btn-lg btn-primary btn-block">Registration</a>
    </f:form>


</div> <!-- /container -->


</body>
</html>