<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Admin</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f4f4f4;
        }
        .container {
            width: 80%;
            margin: 0 auto;
        }
        .header {
            background-color: #4CAF50;
            color: white;
            padding: 15px 0;
            text-align: center;
        }
        .nav {
            display: flex;
            justify-content: center;
            background-color: #333;
        }
        .nav a {
            color: white;
            padding: 14px 20px;
            text-decoration: none;
            text-align: center;
        }
        .nav a:hover {
            background-color: #575757;
        }
        .main-content {
            margin: 20px 0;
            padding: 20px;
            background-color: white;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
        }
        .main-content h2 {
            margin-top: 0;
        }
        .main-content ul {
            list-style-type: none;
            padding: 0;
        }
        .main-content ul li {
            margin: 10px 0;
        }
        .main-content ul li a {
            text-decoration: none;
            color: #4CAF50;
            font-size: 18px;
        }
        .main-content ul li a:hover {
            text-decoration: underline;
        }
        .footer {
            text-align: center;
            padding: 10px;
            background-color: #333;
            color: white;
        }
    </style>
</head>
<body>

<div class="header">
    <h1>Admin Dashboard</h1>
</div>

<div class="nav">
    <a href="admin.jsp"></a>
    <a href="logout">Logout</a>
    <a href="home.jsp">Home</a>
</div>

<div class="container">
    <div class="main-content">
        <h2>Welcome, Admin!</h2>
        <p>Select an option below to manage the system:</p>
        <ul>
            <li><a href="viewReservations.jsp">View Reservations</a></li>
            <li><a href="manageUsers.jsp">Manage Users</a></li>
            <li><a href="updateMenu.jsp">Update Menu</a></li>
        </ul>
    </div>
</div>

<div class="footer">
    <p>&copy; 2024 ABC Restaurant. All Rights Reserved.</p>
</div>
</body>
</html>