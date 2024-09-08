<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@page import="java.util.List" %>
<%@page import="com.abc.dao.ContactDAO" %>
<%@page import="com.abc.model.Contact" %>    
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>View Contact Queries</title>
    <style>
        table {
            width: 100%;
            border-collapse: collapse;
        }
        table, th, td {
            border: 1px solid black;
        }
        th, td {
            padding: 10px;
            text-align: left;
        }
        th {
            background-color: #f2f2f2;
        }
    </style>
</head>
<body>
    <h1>Contact Queries</h1>

    <table>
        <thead>
            <tr>
                <th>Name</th>
                <th>Email</th>
                <th>Contact Number</th>
                <th>Message</th>
            </tr>
        </thead>
        <tbody>
            <%
                ContactDAO contactDAO = new ContactDAO();
                List<Contact> contacts = contactDAO.getAllContacts();
                for (Contact contact : contacts) {
            %>
            <tr>
                <td><%= contact.getName() %></td>
                <td><%= contact.getEmail() %></td>
                <td><%= contact.getContactNumber() %></td>
                <td><%= contact.getMessage() %></td>
            </tr>
            <% } %>
        </tbody>
    </table>
</body>
</html>