<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>

<c:if test="${not empty userId}">
    <c:redirect url="/homeUser"/>
</c:if>

<html>
<head>
    <title>Authorization</title>
    <link href="/css/styles.jsp" rel="stylesheet">
</head>
<body>

<div class="middle">
    <br/>
    <br/>
    <br/>
    <br/>
    <div class="container">
        <div align="center">


            <f:form method="POST" commandName="user" action="login">

                <b>Login:</b><br>
                <f:input path="login" size='20' cssClass='radial'/><br>

                <b>Password:</b><br>
                <f:input path="password" size='20' class='radial'/><br>

                <input type="submit"/> <a href="/registration">Registration</a>
            </f:form>

        </div>
    </div>
    <!-- .container-->


</div>
<!-- .middle-->

<footer class="footer">
    <p><strong>Одесса 2016 ©</strong></p>
</footer>
<!-- .footer -->


</body>
</html>
