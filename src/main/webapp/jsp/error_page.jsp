<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${empty sessionScope.userId}">
  <c:redirect url="/jsp/login.jsp.jsp"/>
</c:if>

<html>
<head>
    <title>Error page</title>
</head>
<body>
  <div align="center">
    <p><h1>Error!!!</h1></p>
    <p>${message}</p>
  </div>
</body>
</html>
