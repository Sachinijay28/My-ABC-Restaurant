<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Reservations</title>
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
        p{
            text-align: left;
        }
        form {
            max-width: 600px;
            margin: 0 auto;
            padding: 20px;
            border: 1px solid #ddd;
            border-radius: 8px;
            background-color: #f9f9f9;
        }
        label {
            display: block;
            margin: 10px 0 5px;
        }
        input, select {
            width: 100%;
            padding: 10px;
            margin-bottom: 10px;
            border: 1px solid #ddd;
            border-radius: 4px;
        }
        input[type="submit"] {
            background-color: #333;
            color: white;
            border: none;
            cursor: pointer;
        }
        input[type="submit"]:hover {
            background-color: #575757;
        }
    </style>
</head>
<body>
    <h1><i>Reservations</i></h1>
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
        <h1>Good Food, Greate Vibes</h1>
        <p>We are delighted to offer you a memorable Dining experience.Please use the form to select your preferred date and time,along with the number of guests.
        We look forward to hosting you and providing exceptional service.
        if you have any special requests or need assistance,feel free to contact us directly.</p>
       
       <form action="process-reservation" method="post">
            <label for="name">Name:</label>
            <input type="text" id="name" name="name" required>

            <label for="email">Email:</label>
            <input type="email" id="email" name="email" required>

            <label for="phone">Phone Number:</label>
            <input type="tel" id="phone" name="phone" required>

            <label for="date">Reservation Date:</label>
            <input type="date" id="date" name="date" required>

            <label for="time">Reservation Time:</label>
            <input type="time" id="time" name="time" required>

            <label for="guests">Number of Guests:</label>
            <input type="number" id="guests" name="guests" min="1" required>

            <input type="submit" value="Book Reservation">
        </form>
    </div>
</body>
</html>