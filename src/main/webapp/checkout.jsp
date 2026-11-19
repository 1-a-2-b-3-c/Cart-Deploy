<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!doctype html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Shopping Cart</title>
    <link rel="stylesheet" type="text/css" href="style/index.css">
</head>
<body>
    <p>Cart Information</p>
    <table>
        <tr>
            <th>Description</th>
            <th>Price</th>
            <th>Quantity</th>
            <th>Total</th>
        </tr>
        <c:forEach var="item" items="${cart.items}">
            <tr>
                <td><c:out value="${item.description}"/></td>
                <td><c:out value="$${item.price}"/></td>
                <td><c:out value="${item.quantity}"/></td>
                <td><c:out value="$${item.quantity * item.price}"/></td>
            </tr>
        </c:forEach>
    </table>

    <c:set var="total" value="${0}"/>
    <c:forEach var="item" items="${cart.items}">
        <c:set var="total" value="${total + item.quantity * item.price}"/>
    </c:forEach>
    <h2>Total: <c:out value="${total}"/></h2>

    <form action="cart" method="post">
        <input type="hidden" name="action" value="back">
        <button type="submit" id="back">Back to CD List</button>
    </form>
</body>