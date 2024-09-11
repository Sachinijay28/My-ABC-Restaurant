package com.abc.controller;


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
 * Servlet implementation class ProcessPaymentServlet
 */
@WebServlet("/processPayment")
public class ProcessPaymentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CartService cartService;
   
    public ProcessPaymentServlet() {
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
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO: Implement actual payment processing logic
       
        
        try {
            int userId = getUserIdFromSession(request);
            cartService.clearCart(userId);
            response.sendRedirect("orderConfirmation.jsp");
        } catch (SQLException e) {
            throw new ServletException("Error processing payment", e);
        }
    }

    private int getUserIdFromSession(HttpServletRequest request) {
        // TODO: Implement proper user session management
        return 1; // Dummy user ID
    }

	}


