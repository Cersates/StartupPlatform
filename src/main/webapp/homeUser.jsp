<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>

<%--<c:if test="${empty userId}">--%>
<%--<c:redirect url="/login.jsp"/>--%>
<%--</c:if>--%>

<html>
<head>
    <title>Home</title>
    <link href="/css/styles.jsp" rel="stylesheet">
</head>
<body>

<div class="middle">

    <div class="container">
        <main class="content">
            <article class="size_text">
                <p class="content_block">
                    <c:if test="${empty info}">
                        <c:out value="Wellcome!"/>
                    </c:if>

                    <c:if test="${!empty info}">
                <table>
                    <tr>
                        <td><i>Title: </i></td>
                        <td>${info.getTitle()}</td>
                    </tr>
                    <tr>
                        <td><i>Description: </i></td>
                        <td>${info.getDescription()}</td>
                    </tr>
                </table>
                </c:if>


                </p>


            </article>
        </main>
    </div>
    <!-- .container-->

    <aside class="left-sidebar">
        <ul class="main-menu">
            <c:forEach var="project" items="${projectList}">
                <tr>
                    <li><a href="/homeUser/${project.getId()}">${project.getTitle()}</a></li>
                </tr>
            </c:forEach>
            <br/>
            <li><a href="/add-project">Add Project</a></li>
            <li><a href="/login">Logout</a></li>

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
