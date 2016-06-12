<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--selectParseString.jsp--%>
<div>
    <li><a href="/selectParseString.jsp">Select string for parse</a></li>
    <li><a href="/addAddress.jsp">Add address for parse</a></li>
    <%--<li><a href="ControllerServlet?action=">Some other menu item</a></li>--%>

    <%--<c:if test="${sessionScope.userId==1}">--%>
        <%--<li><a href="/ControllerServlet?action=allUsers">All users</a></li>--%>
    <%--</c:if>--%>

    <li><a href="ControllerServlet?action=signOut">Sign Out</a></li>
</div>
