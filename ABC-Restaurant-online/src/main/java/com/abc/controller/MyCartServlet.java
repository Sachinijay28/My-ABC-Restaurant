package com.abc.controller;


import java.io.IOException;
import java.io.PrintWriter;
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
    public CartItem(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getTotal() {
        return price * quantity;
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
        List<CartItem> cart = (List<CartItem>) session.getAttribute("cart");
        
        if (cart == null) {
            cart = new ArrayList<>();
            session.setAttribute("cart", cart);
        }

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        // Generate HTML response
        out.println("<html><body>");
        out.println("<h1>My Cart</h1>");
        out.println("<table border='1'>");
        out.println("<tr><th>Name</th><th>Price</th><th>Quantity</th><th>Total</th><th>Action</th></tr>");

        double grandTotal = 0.0;
        for (int i = 0; i < cart.size(); i++) {
            CartItem item = cart.get(i);
            out.println("<tr>");
            out.println("<td>" + item.getName() + "</td>");
            out.println("<td>$" + item.getPrice() + "</td>");
            out.println("<td>" + item.getQuantity() + "</td>");
            out.println("<td>$" + item.getTotal() + "</td>");
            out.println("<td><a href='remove?index=" + i + "'>Remove</a></td>");
            out.println("</tr>");
            grandTotal += item.getTotal();
        }

        out.println("</table>");
        out.println("<h2>Grand Total: $" + grandTotal + "</h2>");
        out.println("<a href='index.jsp'>Back to Home</a>");
        out.println("</body></html>");
    }

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
        double price = Double.parseDouble(request.getParameter("price"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));

        HttpSession session = request.getSession();
        List<CartItem> cart = (List<CartItem>) session.getAttribute("cart");
        
        if (cart == null) {
            cart = new ArrayList<>();
            session.setAttribute("cart", cart);
        }

        // Check if the item already exists in the cart
        boolean itemExists = false;
        for (CartItem item : cart) {
            if (item.getName().equals(name)) {
                itemExists = true;
                item.quantity += quantity; // Update quantity
                break;
            }
        }

        if (!itemExists) {
            // Add new item to the cart
            cart.add(new CartItem(name, price, quantity));
        }

        // Redirect to cart page
        response.sendRedirect("cart");
    }

}
