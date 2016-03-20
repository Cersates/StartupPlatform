<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>

<c:if test="${not empty sessionScope.userId}">
    <c:redirect url="/jsp/selectParseString.jsp"/>
</c:if>

<html>
<head>
    <title>Authorization</title>
    <link href="../css/styles.css" rel="stylesheet">
</head>
<body>

<header align="center">
    <img src="../images/header.jpg" alt="Header" width="999" align="middle">
</header>

<div class="middle">

    <div class="container">
        <div align="center">

            <form name='auto' method='POST' action='ControllerServlet' class='radial'>
                <strong>Login:</strong><br>
                <input type='text' size='20' class='inp radial' spellcheck='false' name='login' required><br>

                <strong>Password:</strong><br>
                <input type='password' size='20' class='inp radial' name='password' required><br>

                <p class="error"><c:out value="${requestScope.errMsg}"/></p>

                <input type='submit' name='autoriz_btn' value='Log In' size='40' class='radial'>
                <a href="/jsp/registration.jsp">Registration</a>
                <input type="hidden" name="action" value="login">

            </form>
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
