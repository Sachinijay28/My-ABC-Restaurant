package com.abc.controller;


import com.abc.model.CartItem;
import com.abc.service.CartService;
import com.abc.util.DatabaseConnection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * Servlet implementation class CheckoutServlet
 */
@WebServlet("/checkout")
public class CheckoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private CartService cartService;
   
    public CheckoutServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    @Override
    public void init() throws ServletException {
        super.init();
        try {
            Connection conn = DatabaseConnection.getConnection();
            cartService = new CartService(conn);
        } catch (SQLException e) {
            throw new ServletException("Error initializing CartService", e);
        }
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
            int userId = getUserIdFromSession(request);
            List<CartItem> cartItems = cartService.getCartItems(userId);
            double total = calculateTotal(cartItems);

            request.setAttribute("cartItems", cartItems);
            request.setAttribute("total", total);
            request.getRequestDispatcher("checkout.jsp").forward(request, response);
        } catch (SQLException e) {
            throw new ServletException("Error retrieving cart items", e);
        }
    }

    private double calculateTotal(List<CartItem> cartItems) {
        return cartItems.stream()
                .mapToDouble(item -> item.getPrice() * item.getQuantity())
                .sum();
    }

    private int getUserIdFromSession(HttpServletRequest request) {
        // TODO: Implement proper user session management
        return 1; // Dummy user ID
    }
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
