<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Menu</title>
    <style>
       body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #82D0AB;
            background-image: url('images/menu-back1.jpg');
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
             font-size: 40px;
        }
         h3 {
             font-size: 20px;
             text-align: center;
             color:#084675
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
            font-weight: bold
           
        }
        
         table, th, td {
           border:1px, solid black;
           width:100%;
           text-align:left;
           padding:8px
           color: #d4b428;
          
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
    <h1><i>Our Menu</i></h1>
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
   <h3><i>Main Course</i></h3>
   <table>
  <tr>
    <th>Item</th>
    <th>Price</th>
    <th>Add to Cart</th>
  </tr>
  <tr>
    <td>Butter Chicken Rice</td>
    <td>Rs.1500</td>
    <td><a href="mycart.jsp">Add to Cart</a></td>
  </tr>
  <tr>
    <td>Chicken Biriyani</td>
    <td>RS. 1300</td>
    <td><a href="mycart.jsp">Add to Cart</a></td>
  </tr>
  <tr>
    <td>Veg Biriyani</td>
    <td>Rs. 1000</td>
    <td><a href="mycart.jsp">Add to Cart</a></td>
  </tr>
  
  <tr>
    <td>Cheese Burger</td>
    <td>Rs. 1500</td>
    <td><a href="mycart.jsp">Add to Cart</a></td>
  </tr>
  <tr>
    <td>Chicken Burger</td>
    <td>Rs. 1300</td>
    <td><a href="mycart.jsp">Add to Cart</a></td>
  </tr>
  <tr>
    <td>Cheese Sandwich</td>
    <td>Rs. 800</td>
    <td><a href="mycart.jsp">Add to Cart</a></td>
  </tr>
  
</table>
 <h3><i>Appetizers</i></h3>
   <table>
  <tr>
    <th>Item</th>
    <th>Price</th>
    <th>Add to Cart</th>
  </tr>
  <tr>
    <td>Fruit Salad</td>
    <td>Rs. 450</td>
    <td><a href="mycart.jsp">Add to Cart</a></td>
  </tr>
  <tr>
    <td>Cocktails</td>
    <td>Rs. 500</td>
    <td><a href="mycart.jsp">Add to Cart</a></td>
  </tr>
  <tr>
    <td>Nuggets</td>
    <td>Rs. 400</td>
    <td><a href="mycart.jsp">Add to Cart</a></td>
  </tr>
  <tr>
    <td>French FRies</td>
    <td>Rs. 400</td>
    <td><a href="mycart.jsp">Add to Cart</a></td>
  </tr>
  
</table>

 <h3><i>Beverages</i></h3>
   <table>
  <tr>
    <th>Item</th>
    <th>Price</th>
    <th>Add to Cart</th>
  </tr>
  <tr>
    <td>Milk Shake</td>
    <td>Rs. 600</td>
    <td><a href="mycart.jsp">Add to Cart</a></td>
  </tr>
  <tr>
    <td>Iced Tea</td>
    <td>Rs. 500</td>
    <td><a href="mycart.jsp">Add to Cart</a></td>
  </tr>
  <tr>
    <td>Orange Juice</td>
    <td>Rs. 400</td>
    <td><a href="mycart.jsp">Add to Cart</a></td>
  </tr>
</table>
   </div>
   
   
   <footer>
    <p>&copy; 2024 ABC Restaurant. All Rights Reserved.</p>
    </footer>

    
</body>
</html>