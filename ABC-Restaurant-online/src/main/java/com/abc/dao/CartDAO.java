package com.abc.dao;

import com.abc.model.CartItem;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CartDAO {
	
	private Connection conn;

    public CartDAO(Connection conn) {
        this.conn = conn;
    }

    public void addToCart(int userId, CartItem item) throws SQLException {
        String sql = "INSERT INTO cart (user_id, item_id, quantity) VALUES (?, ?, ?) " +
                     "ON DUPLICATE KEY UPDATE quantity = quantity + ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, userId);
            pstmt.setInt(2, item.getId());
            pstmt.setInt(3, item.getQuantity());
            pstmt.setInt(4, item.getQuantity());
            pstmt.executeUpdate();
        }
    }

    public List<CartItem> getCartItems(int userId) throws SQLException {
        List<CartItem> items = new ArrayList<>();
        String sql = "SELECT i.id, i.name, i.price, c.quantity FROM cart c " +
                     "JOIN items i ON c.item_id = i.id WHERE c.user_id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, userId);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    CartItem item = new CartItem(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getDouble("price"),
                        rs.getInt("quantity")
                    );
                    items.add(item);
                }
            }
        }
        return items;
    }

    public void clearCart(int userId) throws SQLException {
        String sql = "DELETE FROM cart WHERE user_id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, userId);
            pstmt.executeUpdate();
        }
    }
}


