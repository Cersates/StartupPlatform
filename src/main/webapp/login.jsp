<%@page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>

<c:if test="${not empty userId}">
    <c:redirect url="/homeUser"/>
</c:if>

<html>
<head>
    <title>Authorization</title>
    <!-- Bootstrap core CSS -->
    <link href="./bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <!-- Custom styles for this template -->
    <%--<link href="./css/signin.css" rel="stylesheet">--%>
    <link href="<c:url value="/resources/css/signin.css" />" rel="stylesheet">
</head>
<body>


<div class="container">


    <f:form method="POST" commandName="user" action="login" cssClass='form-signin'>

        <label for="inputEmail" class="sr-only">Email</label>
        <f:input path="email" id="inputEmail" class="form-control" placeholder="Email" required="required"/><br>

        <label for="inputPassword" class="sr-only">Password</label>
        <f:input path="password" id="inputPassword" class="form-control" placeholder="Password"
                 required="required"/><br>

        <p class="error"><c:out value="${requestScope.errMsg}"/></p>

        <input type="submit" value="Sign in" class="btn btn-lg btn-primary btn-block"/>
        <a href="/registration" class="btn btn-lg btn-primary btn-block">Registration</a>
    </f:form>


</div> <!-- /container -->


</body>
</html>