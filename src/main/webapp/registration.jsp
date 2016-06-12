<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>

<html>
<head>
    <title>Registration</title>
    <link href="/css/styles.jsp" rel="stylesheet">
</head>
<body>

<div class="middle">

    <div class="container">
        <div align="center">
            <h3>Registration</h3>
            <br/>
            <br/>
            <br/>

            <f:form method="POST" commandName="user" action="registration">

                <b>Login:</b><br>
                <f:input path="login" size='20' cssClass='radial'/><br>

                <b>Password:</b><br>
                <f:input path="password" size='20' class='radial' spellcheck="false"/><br>

                <b>Firstname:</b><br>
                <f:input path="firstname" size='20' class='radial' spellcheck="false"/><br>

                <b>Lastname:</b><br>
                <f:input path="lastname" size='20' class='radial' spellcheck="false"/><br>

                <b>Email:</b><br>
                <f:input path="email" size='20' class='radial' spellcheck="false"/><br>

                <b>About:</b><br>
                <f:textarea path="about" size='20' class='radial' spellcheck="false"/><br>

                <input type="submit"/>
            </f:form>

        </div>
    </div>
    <!-- .container-->


</div>
<!-- .middle-->

<footer class="footer">
    <p><strong>Одесса 2015 ©</strong></p>
</footer>
<!-- .footer -->


</body>
</html>
