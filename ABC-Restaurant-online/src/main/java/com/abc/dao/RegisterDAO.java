package com.abc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegisterDAO {
	
	 // Database URL, username, and password
    private static final String DB_URL = "jdbc:mysql://localhost:3306/abc_restaurant_database"; //  database URL
    private static final String DB_USER = "root"; //  database username
    private static final String DB_PASSWORD = "MKS@jay123"; //  database password

    // SQL query to insert a new user
    private static final String INSERT_USER_QUERY = "INSERT INTO register (name, email, mobile, password) VALUES (?, ?, ?, ?)";

    // Method to register a new user
    public boolean registerUser(String name, String email, String mobile, String password) throws SQLException {
        boolean isRegistered = false;
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            // Establish connection
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            // Prepare statement
            stmt = conn.prepareStatement(INSERT_USER_QUERY);
            stmt.setString(1, name);
            stmt.setString(2, email);
            stmt.setString(3, mobile);
            stmt.setString(4, password);

            // Execute update
            int rowsAffected = stmt.executeUpdate();
            isRegistered = (rowsAffected > 0); // if rowsAffected is greater than 0, registration was successful
        } finally {
            // Clean up
            if (stmt != null) stmt.close();
            if (conn != null) conn.close();
        }

        return isRegistered;
    }

}
