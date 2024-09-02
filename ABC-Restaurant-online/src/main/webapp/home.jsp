<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Home</title>
    
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #205B4F;
            background-image: url('images/home3-c.jpg');
       
       
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
        h1{
         
             font-family: "Times New Roman", Times, serif;
             font-size: 60px;
             color: #333;
             text-align: center;
             color:#E9FB9F
         }
        
        h2 {
             font-family: "Times New Roman", Times, serif;
             font-size: 30px;
             color: #333;
             text-align: center;
             color:#E9FB9F
        }
         h3 {
             font-family: "Times New Roman", Times, serif;
             text-align: left;
             color:#E9FB9F
        }
        .content {
            max-width: 800px;
            margin: 0 auto;
        }
       
        p {
            line-height: 1.6;
             color: white;
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
    <img src="images/images1-logo-c.jpg" alt="logo image">
    <h1>ABC Restaurant</h1>
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
        <h2><i>Welcome to Our Restaurant</i></h2>
        <h3>The Taste That Make You Feel Awesome</h3>
        <p>Welcome to ABC Restaurant, where comfort and fine dining collide. We provide a great eating experience with a varied cuisine made with the freshest ingredients, all while being tucked away in the center of the city.
         Every meal, including our seasonal specials and signature dishes, is lovingly and carefully prepared.
         Come enjoy a wonderful meal with us in a cozy and welcoming setting. 
        Find out what flavors make ABC Restaurant a beloved establishment in the area! </p>
       
    </div>
     <p>&copy; 2024 ABC Restaurant. All Rights Reserved.</p>
    </body>
</html>