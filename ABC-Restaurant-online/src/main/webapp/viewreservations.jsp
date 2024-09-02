<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>View Reservations</title>
    <style>
        table {
            width: 100%;
            border-collapse: collapse;
        }
        table, th, td {
            border: 1px solid black;
        }
        th, td {
            padding: 8px;
            text-align: left;
        }
    </style>
</head>
<body>
    <h1>Reservations List</h1>
    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Email</th>
                <th>Phone Number</th>
                <th>Reservation Date</th>
                <th>Reservation Time</th>
                <th>Number of Guests</th>
            </tr>
        </thead>
        <tbody>
           
             <tr>
                    <td>${reservation.id}</td>
                    <td>${reservation.name}</td>
                    <td>${reservation.email}</td>
                    <td>${reservation.phoneNumber}</td>
                    <td>${reservation.reservationDate}</td>
                    <td>${reservation.reservationTime}</td>
                    <td>${reservation.numberOfGuests}</td>
                </tr>
           
        </tbody>
    </table>
    <a href="admin.jsp">Back to Admin Portal</a>
</body>
</html>