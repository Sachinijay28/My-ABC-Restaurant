package com.abc.service;

import com.abc.dao.CartDAO;
import com.abc.model.CartItem;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class CartService {
	
	private CartDAO cartDAO;

    public CartService(Connection conn) {
        this.cartDAO = new CartDAO(conn);
    }

    public void addToCart(int userId, CartItem item) throws SQLException {
        cartDAO.addToCart(userId, item);
    }

    public List<CartItem> getCartItems(int userId) throws SQLException {
        return cartDAO.getCartItems(userId);
    }

    public void clearCart(int userId) throws SQLException {
        cartDAO.clearCart(userId);
    }
}


