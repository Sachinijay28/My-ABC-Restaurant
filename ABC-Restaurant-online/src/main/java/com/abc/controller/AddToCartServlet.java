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

/**
 * Servlet implementation class AddToCartServlet
 */
@WebServlet("/addToCart")
public class AddToCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private CartService cartService;
    
    public AddToCartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
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
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int itemId = Integer.parseInt(request.getParameter("itemId"));
        String itemName = request.getParameter("itemName");
        double price = Double.parseDouble(request.getParameter("price"));
        int quantity = 1; // You can allow users to specify quantity if needed

        CartItem item = new CartItem(itemId, itemName, price, quantity);

        try {
            int userId = getUserIdFromSession(request);
            cartService.addToCart(userId, item);
            response.sendRedirect("cart.jsp");
        } catch (SQLException e) {
            throw new ServletException("Error adding item to cart", e);
        }
    }

    private int getUserIdFromSession(HttpServletRequest request) {
        // TODO: Implement proper user session management
        return 1; // Dummy user ID
    }
	

}
