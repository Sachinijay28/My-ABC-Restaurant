package com.abc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDAO {

    // Database connection parameters
    private static final String URL = "jdbc:mysql://localhost:3306/abc_restaurant_database"; //  DB URL
    private static final String USER = "root"; //  DB username
    private static final String PASSWORD = "MKS@jay123"; //  DB password
    
    

    public String authenticate(String username, String password) {
        String userType = null;
        String query = "SELECT usertype FROM login WHERE username = ? AND password = ?";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setString(1, username);
            ps.setString(2, password);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    userType = rs.getString("usertype");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return userType;
    }
}
