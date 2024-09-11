<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Order Online</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #82D0AB;
            
           
        }
        nav {
            background-color: #333;
            color: #fff;
            padding: 10px;
        }
        nav a {
            color: #fff;
            text-decoration: none;
            padding: 10px;
        }
        nav a:hover {
            background-color: #575757;
        }
        .container {
            padding: 20px;
        }
        h1 {
            color: #333;
            text-align: center;
        }
        .menu {
            list-style-type: none;
            padding: 0;
        }
        .menu-item {
            border-bottom: 1px solid #ddd;
            padding: 10px 0;
        }
        .menu-item:last-child {
            border-bottom: none;
        }
        .price {
            float: right;
            font-weight: bold;
        }
    </style>
</head>
<body>
    <h1>Order Online</h1>
    
    
    <nav>
        <a href="order-online.jsp" class="nav-button">Order Online</a>
        <a href="home.jsp" class="nav-button">Home</a>
        <a href="cart.jsp" class="nav-button">My Cart</a>
        <a href="search.jsp" class="nav-button">Search</a>
        <a href="login.jsp" class="nav-button">Login</a>
        
    </nav>
    </body>
</html>