<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Payment</title>
</head>
<body>
<h1>Payment ${payment.id}</h1>
<table>
    <tr>
        <td><i>Amount: </i></td>
        <td>${payment.amount}</td>
    </tr>
    <tr>
        <td><i>Payer ID: </i></td>
        <td>${payment.payerId}</td>
    </tr>
    <tr>
        <td><i>Recipient ID: </i></td>
        <td>${payment.recipientId}</td>
    </tr>
</table>
<a href="/payments">Back</a>
</body>
</html>