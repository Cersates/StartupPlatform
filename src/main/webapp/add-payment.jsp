<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Add payment</title>
</head>
<body>
<h1>New payment</h1>
<f:form method="POST" commandName="payment" action="payments">
    <table>
        <tr>
            <td>
                <i>Amount:</i>
            </td>
            <td>
                <f:input path="amount"/>
            </td>
        </tr>
        <tr>
            <td>
                <i>Payer ID:</i>
            </td>
            <td>
                <f:input path="payerId"/>
            </td>
        </tr>
        <tr>
            <td>
                <i>Recipient ID:</i>
            </td>
            <td>
                <f:input path="recipientId"/>
            </td>
        </tr>
        <tr>
            <td><input type="submit"/></td>
        </tr>
    </table>
</f:form>
</body>
</html>