package com.abc.dao;


import com.abc.model.MenuItem;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;


public class MenuDAO {
	
	private Connection conn;

    public MenuDAO(Connection conn) {
        this.conn = conn;
    }

    // Method to retrieve menu items from the database and organize them by category
    public Map<String, List<MenuItem>> getMenuItemsByCategory() throws SQLException {
        Map<String, List<MenuItem>> menuItems = new LinkedHashMap<>();
        String sql = "SELECT * FROM items ORDER BY category, name";

        try (PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                MenuItem item = new MenuItem(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getDouble("price"),
                    rs.getString("category")
                );

                menuItems.computeIfAbsent(item.getCategory(), k -> new ArrayList<>()).add(item);
            }
        }

        return menuItems;
    }
	
	

	
	
}
