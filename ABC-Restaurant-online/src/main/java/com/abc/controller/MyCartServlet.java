package com.abc.controller;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Servlet implementation class MyCartServlet
 */
@WebServlet("/mycart")
public class MyCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	


       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyCartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 // Get the item and price from the request
        String item = request.getParameter("item");
        int price = Integer.parseInt(request.getParameter("price"));

        // Get the current session
        HttpSession session = request.getSession();

        // Retrieve the current cart from the session
        List<String> cartItems = (List<String>) session.getAttribute("cartItems");
        List<Integer> cartPrices = (List<Integer>) session.getAttribute("cartPrices");

        // Initialize the cart if it's null
        if (cartItems == null) {
            cartItems = new ArrayList<>();
            cartPrices = new ArrayList<>();
        }

        // Add the new item and price to the cart
        cartItems.add(item);
        cartPrices.add(price);

        // Save the updated cart in the session
        session.setAttribute("cartItems", cartItems);
        session.setAttribute("cartPrices", cartPrices);

        // Redirect the user back to the menu page
        response.sendRedirect("menu.jsp");
    }
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 doGet(request, response);
	}
}
