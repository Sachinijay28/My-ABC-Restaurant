<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Checkout</title>
    <style>
        form {
            width: 300px;
            margin: 0 auto;
        }
        label {
            display: inline-block;
            width: 100px;
            margin-bottom: 10px;
        }
        input[type="text"] {
            width: 180px;
        }
        input[type="submit"] {
            margin-top: 10px;
        }
    </style>
</head>
<body>
    <h1>Checkout</h1>
    <form action="processPayment" method="post">
        <h2>Payment Information</h2>
        <label for="cardNumber">Card Number:</label>
        <input type="text" id="cardNumber" name="cardNumber" required><br>

        <label for="expiryDate">Expiry Date:</label>
        <input type="text" id="expiryDate" name="expiryDate" placeholder="MM/YY" required><br>

        <label for="cvv">CVV:</label>
        <input type="text" id="cvv" name="cvv" required><br>

        <input type="submit" value="Pay Now">
    </form>
</body>
</html>