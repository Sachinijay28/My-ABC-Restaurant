<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Gallery</title>
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
        div.gallery {
             margin: 5px;
             border: 1px solid #ccc;
             float: left;
             width: 180px;
        }
      

        div.gallery:hover {
             border: 1px solid #777;
        }

        div.gallery img {
             width: 600px;
             height: 800px;
       }

        div.desc {
        padding: 15px;
        text-align: center;
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
    <h1><i>Gallery</i></h1>
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
        <h1>Discover the ambiance and flavors of ABC Restaurant through our gallery. Enjoy a visual taste of our dishes and dining experience!</h1>
        
           
           

            <div class="gallery">
            <a target="_blank" href="images/Restaurant1.jpg">
            <img src="images/Restaurant1.jpg" alt="Restaurant image" width="800" height="600">
            </a>
            <div class= "image-description">Click Here to See</div>
           </div>

            <div class="gallery">
            <a target="_blank" href="images/food 2.jpg">
            <img src="images/food 2.jpg" alt="Food image" width="800" height="600">
            </a>
            <div class= "image-description">Click Here to See</div>
            </div>

            <div class="gallery">
            <a target="_blank" href="images/Restaurant 2.jpg">
            <img src="images/Restaurant 2.jpg" alt="Restaurant image" width="800" height="600">
            </a>
            <div class= "image-description">Click Here to See</div>
            </div>
          
          <div class="gallery">
            <a target="_blank" href="images/restaurant 3.jpg">
            <img src="images/restaurant 3.jpg" alt="Restaurant image" width="800" height="600">
            </a>
             </div>
            <div class="gallery">
            <a target="_blank" href="images/home1.jpg">
            <img src="images/home1.jpg" alt="Restaurant image" width="800" height="600">
            </a>
             </div>
           
        
            </div>
             <footer><p>&copy; 2024 ABC Restaurant. All Rights Reserved.</footer>
    
</body>
</html>