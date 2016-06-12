<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>

<html>
<head>
    <title>New project</title>
    <link href="/css/styles.jsp" rel="stylesheet">
</head>
<body>

<div class="middle">

    <div class="container">
        <div align="center">
            <h3>New project</h3>
            <br/>
            <br/>
            <br/>

            <f:form method="POST" commandName="project" action="add-project">

                <b>Title:</b><br>
                <f:input path="title" size='40' cssClass='radial'/><br/><br/>

                <b>Description:</b><br>
                <f:textarea path="description" cols="60" rows="10" class='radial'/><br>

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
