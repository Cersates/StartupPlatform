<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>

<c:if test="${empty sessionScope.userId}">
    <c:redirect url="/jsp/login.jsp.jsp"/>
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

                <form name='auto' method='POST' action='ControllerServlet' class='radial' id="connect">
                    <input type='submit' name='connect_btn' value='Press to connect to the database' size='40' class='radial'>
                    <input type="hidden" name="action" value="connect">
                </form>

                <form name='auto' method='POST' action='ControllerServlet' class='radial' id="addrform">
                    Choose string to parse:<br>

                    <input type='submit' name='autoriz_btn' value='Parse' size='40' class='radial'>
                    <input type="hidden" name="action" value="parse">
                </form>

                <br>
                <select name="addrlist" form="addrform">

                    <c:forEach var="address" items="${requestScope.addrList}">
                        <option value="${address.getAddress()}">${address.getAddress()}</option>
                    </c:forEach>

                </select>


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
