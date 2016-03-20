<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>

<c:if test="${empty sessionScope.userId}">
    <c:redirect url="/jsp/login.jsp"/>
</c:if>

<html>
<head>
    <title>Home</title>
    <link href="../css/styles.css" rel="stylesheet">
</head>
<body>

<header align="center">
    <img src="../images/header.jpg" alt="Header" width="999" align="middle">
</header>

<div class="middle">

    <div class="container">
        <main class="content">
            <article class="size_text">
                <p class="content_block">

                <form name='auto' method='POST' action='ControllerServlet' class='radial'>

                    <b>Address:</b><br>
                    <input type='text' size='70' class='inp radial' spellcheck="false" name='address' required><br>

                    <b>DateAdd:</b><br>
                    <input type='text' size='20' class='inp radial' name='dateAdd' required><br>

                    <input type='submit' name='register_btn' value='Add new address' size='40' class='radial'>
                    <input type="hidden" name="action" value="addAddressToParse">

                </form>

                </p>
            </article>
        </main>
    </div>
    <!-- .container-->

    <aside class="left-sidebar">
        <ul class="main-menu">
            <jsp:include page="/jsp/menu.jsp"/>
        </ul>
    </aside>
    <!-- .left-sidebar -->

</div>
<!-- .middle-->

<footer class="footer">
    <p><strong>Одесса 2015 ©</strong></p>
</footer>
<!-- .footer -->


</body>
</html>
