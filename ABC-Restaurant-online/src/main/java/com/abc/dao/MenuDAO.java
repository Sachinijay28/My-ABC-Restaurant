package com.abc.dao;

import java.awt.Menu;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.abc.model.Menu.MenuItem;


public class MenuDAO {
	
	private static final String DB_URL = "jdbc:mysql://localhost:3306/abc_restaurant_database";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "MKS@jay123";

    public MenuDAO() {
        // Load the MySQL driver
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
    }

    public List<MenuItem> getAllMenuItems(String item) {
        List<MenuItem> menuItems = new ArrayList<>();

        String sql = "SELECT item, price FROM menu_items";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                String item= rs.getString("item");
                double price = rs.getDouble("price");
                menuItems.add(new MenuItem(item, price));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return menuItems;
    }

    public MenuItem getMenuItemByName(String item) {
        MenuItem menuItem = null;

        String sql = "SELECT item, price FROM menu_items WHERE name = ?";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, item);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    double price = rs.getDouble("price");
                    menuItem = new MenuItem(item, price);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return menuItem;
    }

	
	
}
