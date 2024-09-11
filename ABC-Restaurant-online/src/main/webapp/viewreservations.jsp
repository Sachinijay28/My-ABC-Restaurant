<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>View Reservations</title>
    <style>
        table {
            width: 100%;
            border-collapse: collapse;
        }
        th, td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: left;
        }
        th {
            background-color: #f2f2f2;
        }
    </style>
</head>
<body>
   

    <div class="container">
        <h1>View Reservations</h1>
       
        
        <table>
            <tr>
                <th>Name</th>
                <th>Email</th>
                <th>Phone</th>
                <th>Date</th>
                <th>Time</th>
                <th>Guests</th>
                <th>Actions</th>
            </tr>
            <c:forEach var="reservation" items="${reservations}">
                <tr>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td>
                        <a href="ReservationsServlet?action=edit&id=${reservation.id}">Edit</a>
                        <a href="ReservationsServlet?action=delete&id=${reservation.id}" onclick="return confirm('Are you sure you want to delete this reservation?')">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
        
       
    </div>
</body>
</html>
    