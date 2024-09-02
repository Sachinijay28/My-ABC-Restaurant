<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>About Us</title>
    
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
            
             font-family: "Times New Roman", Times, serif;
             font-size: 40px;
             color: #333;
             text-align: center;
             color:#E9FB9F
        }
        .content {
            max-width: 800px;
            margin: 0 auto;
        }
        p {
            line-height: 1.6;
            text-align: left;
        }
        footer {
        background-color: orange;
        font-family:'Times New Roman',Times, Serif;
        text-align: center;
        font-size:10px;
        color: black;
        position:fixed;
        bottom:0;
        left:0;
        width:100%;
        padding: 3px;
        }
    </style>
</head>
<body>
    <h1><i>About Us</i></h1>
    <nav>
       <div class="navbar">
            <a href="home.jsp" class="nav-button">Home</a>
            <a href="about.jsp" class="nav-button">About</a>
            <a href="menu.jsp" class="nav-button">Menu</a>
            <a href="gallery.jsp" class="nav-button">Gallery</a>
            <a href="reservations.jsp" class="nav-button">Reservations</a>
            <a href="contact.jsp" class="nav-button">Contact</a>
            <a href="order-online.jsp" class="nav-button">Order Online</a>
            <a href="login.jsp" class="nav-button">Login</a>
        </div>    
    </nav>
    <div class="container">
        <h1>We are ABC Restaurant</h1>
        <p>At ABC Restaurant, we take great pleasure in offering a remarkable dining experience that combines warmth and enthusiasm. Since our establishment, we have been dedicated to providing high-quality food. Our varied menu features the best of both traditional and modern cuisine. Our chefs work hard to find the best ingredients so they can carefully and creatively prepare each meal. Every element of ABC Restaurant, from our friendly atmosphere to our dedicated service, is intended to make your visit unforgettable. Whether you're hosting a festive gathering, a romantic dinner, or a casual brunch, we work hard to create an environment where mouthwatering food and treasured memories mingle together. Join us for dinner to see the impact that commitment and a passion for food can have.</p>
    </div>
    <footer>
    <p>&copy; 2024 ABC Restaurant. All Rights Reserved.</p>
    </footer>
    </body>
</html>