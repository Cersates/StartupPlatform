<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>

<html>
<head>
    <title>Registration</title>
    <!-- Bootstrap core CSS -->
    <link href="/resources/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <!-- Custom styles for this template -->
    <%--<link href="./css/signin.css" rel="stylesheet">--%>
    <link href="/resources/css/signin.css" rel="stylesheet">
</head>
<body>


<div class="container">


    <f:form method="POST" commandName="user" action="registration" cssClass='form-signin'>
        <h2 class="form-signin-heading">Registration</h2>

        <label for="inputEmail" class="sr-only">Email address</label>
        <f:input path="email" type="email" id="inputEmail" class="form-control" placeholder="Email address"
                 required="required" autofocus="autofocus"
                 value="aaa@aaa"/><br>

        <label for="inputPassword" class="sr-only">Password</label>
        <f:input path="password" type="password" id="inputPassword" class="form-control" placeholder="Password"
                 required="required"
                 value="aaa"/><br>

        <label for="inputFirstname" class="sr-only">Firstname</label>
        <f:input path="firstname" id="inputFirstname" class="form-control" placeholder="Firstname"
                 required="required" autofocus="autofocus"/><br>

        <label for="inputLastname" class="sr-only">Lastname</label>
        <f:input path="lastname" id="inputLastname" class="form-control" placeholder="Lastname"
                 required="required" autofocus="autofocus"/><br>

        <label for="about" class="sr-only">About</label>
        <f:textarea path="about" id="about" class="form-control" rows="2" placeholder="About"
                    cols="50" required="required"/><br>

        <div class="form-group">
            <label for="sel1">Register as:</label>
            <f:select path="type" class="form-control" id="sel1">
                <option>Startuper</option>
                <option>Mentor</option>
                <option>Investor</option>
            </f:select>
        </div>

        <input type="submit" value="Register" class="btn btn-lg btn-primary btn-block"/>
    </f:form>


</div> <!-- /container -->


</body>
</html>