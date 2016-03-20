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
    <style>
        table, th, td {
            border: 1px solid black;
            border-collapse: collapse;
        }

        th, td {
            padding: 5px;
            text-align: left;
        }
    </style>
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

                    <%--<c:forEach var="address" items="${requestScope.addrPars}">--%>
                    <%--<option value="${address.getAddress()}">${address.getAddress()}</option>--%>
                    <%--</c:forEach>--%>

                <table style="width:100%">
                    <tr>
                        <th>Country:</th>
                        <td><c:out value="${requestScope.addrPars[0]}"/></td>
                    </tr>
                    <tr>
                        <th>City:</th>
                        <td><c:out value="${requestScope.addrPars[1]}"/></td>
                    </tr>
                    <tr>
                        <th>Street:</th>
                        <td><c:out value="${requestScope.addrPars[2]}"/></td>
                    </tr>
                    <tr>
                        <th>Building:</th>
                        <td><c:out value="${requestScope.addrPars[3]}"/></td>

                    </tr>

                </table>


            </article>
        </main>
    </div>
    <!-- .container-->

    <aside class="left-sidebar">
        <ul class="main-menu">
            <jsp:include page="/jsp/menu.jsp.jsp"/>
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
