package com.abc.controller;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class OrderOnlineServlet
 */
@WebServlet("/order-online")
public class OrderOnlineServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderOnlineServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 request.setAttribute("pageTitle", "Order Online");
	        request.setAttribute("orderDescription", "Select your items and place your order online.");

	        // Example items (could be fetched from a database in a real application)
	        String[] items = {
	            "Classic Burger - $5.99",
	            "Chicken Caesar Salad - $6.99",
	            "Veggie Pizza - $7.99",
	            "Spaghetti Bolognese - $8.99",
	            "Cheesecake - $4.99"
	        };
	        request.setAttribute("items", items);

	        // Forward the request to the orderonline.jsp page
	        request.getRequestDispatcher("/WEB-INF/jsp/orderonline.jsp").forward(request, response);
	    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
