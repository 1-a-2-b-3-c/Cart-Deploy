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
    <p>Your cart</p>
    <table>
        <tr>
            <th>Quantity</th>
            <th>Description</th>
            <th>Price</th>
            <th>Amount</th>
            <th></th>
        </tr>
        <c:forEach var="item" items="${cart.items}">
            <tr>
                <td>
                    <form action="cart" method="post">
                        <input type="hidden" name="action" value="u${item.id}">
                        <input type="number" name="u${item.id}" value="${item.quantity}" min="1" required>
                        <input type="submit" value="Update" id="u${item.id}">
                    </form>
                </td>
                <td><c:out value="${item.description}"/></td>
                <td><c:out value="$${item.price}"/></td>
                <td><c:out value="$${item.price * item.quantity}"/></td>
                <td>
                    <form action="cart" method="post">
                        <input type="hidden" name="action" value="r${item.id}">
                        <input type="submit" value="remove" id="r${item.id}">
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>

    <h2>To change the quantity, enter the new quantity and click on the Update button</h2>

    <a href="index.html"><button type="button">Continue Shopping</button></a>
    
    <form action="cart" method="post">
        <input type="hidden" name="action" value="check">
        <button type="submit" id="check">Checkout</button>
    </form>
</body>
</html>