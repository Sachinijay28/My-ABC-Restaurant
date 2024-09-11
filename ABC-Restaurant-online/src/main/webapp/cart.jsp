<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.abc.model.CartItem" %>
<%@ page import="com.abc.service.CartService" %>
<%@ page import="com.abc.util.DatabaseConnection" %>
<%@ page import="java.util.List" %>
<%@ page import="java.sql.Connection" %>

<html>
<head>
    <title>Shopping Cart</title>
    <style>
        table {
            width: 100%;
            border-collapse: collapse;
        }
        th, td {
            border: 1px solid black;
            padding: 8px;
            text-align: left;
        }
        th {
            background-color: #f2f2f2;
        }
    </style>
</head>
<body>
    <h1>Your Shopping Cart</h1>
    <table>
        <tr>
            <th>Item</th>
            <th>Price</th>
            <th>Quantity</th>
            <th>Total</th>
        </tr>
        <%
            Connection conn = DatabaseConnection.getConnection();
            CartService cartService = new CartService(conn);
            int userId = 1; // TODO: Get the actual user ID from the session
            List<CartItem> cartItems = cartService.getCartItems(userId);
            double total = 0;
            for (CartItem item : cartItems) {
                double itemTotal = item.getPrice() * item.getQuantity();
                total += itemTotal;
        %>
        <tr>
            <td><%= item.getName() %></td>
            <td>Rs. <%= item.getPrice() %></td>
            <td><%= item.getQuantity() %></td>
            <td>Rs. <%= itemTotal %></td>
        </tr>
        <% } %>
        <tr>
            <td colspan="3"><strong>Total</strong></td>
            <td><strong>Rs. <%= total %></strong></td>
        </tr>
    </table>
    <br>
    <a href="checkout.jsp">Proceed to Checkout</a>
</body>
</html>
    