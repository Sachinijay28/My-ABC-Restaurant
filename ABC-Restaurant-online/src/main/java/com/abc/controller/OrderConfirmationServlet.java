package com.abc.controller;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class OrderConfirmationServlet
 */
@WebServlet("/orderconfirmation")
public class OrderConfirmationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public OrderConfirmationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// You can add any additional logic here if needed
        // For example, retrieving order details from the database

        request.getRequestDispatcher("orderConfirmation.jsp").forward(request, response);
    }
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
