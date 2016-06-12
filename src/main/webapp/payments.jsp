<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>

<!DOCTYPE html>
<html>
<head>
    <title>Payments</title>
</head>
<body>
<h1>Payments</h1>
<table style="border-style: solid">
    <tr>
        <td>ID</td>
        <td>Amount</td>
        <td>Payer ID</td>
        <td>Recipient ID</td>
    </tr>
    <c:forEach var="payment" items="${payments}">
        <tr>
            <td><a href="/payments/${payment.id}">${payment.id}</a></td>
            <td>${payment.amount}</td>
            <td>${payment.payerId}</td>
            <td>${payment.recipientId}</td>
        </tr>
    </c:forEach>
</table>
<br/>
<a href="add-payment">New payment</a>
</body>
</html>