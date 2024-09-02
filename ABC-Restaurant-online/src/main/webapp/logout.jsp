<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Logout</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }
        .container {
            text-align: center;
            padding: 20px;
            background-color: white;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
        }
        .container h1 {
            margin-bottom: 20px;
        }
        .container p {
            margin-bottom: 20px;
        }
        .container a {
            text-decoration: none;
            color: #4CAF50;
            font-weight: bold;
        }
        .container a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>

<div class="container">
    <h1>Logout Successful</h1>
    <p>You have been logged out successfully.</p>
    <p>Redirecting to the home page...</p>
    <p>If you are not redirected automatically, <a href="home.jsp">click here</a>.</p>
</div>

<script>
    // Redirect to home.jsp after 3 seconds
    setTimeout(function() {
        window.location.href = 'home.jsp';
    }, 3000);
</script>

</body>
</html>