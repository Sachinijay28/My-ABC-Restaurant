package com.abc.controller;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;




/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	// Database connection details
    private static final String DB_URL = "jdbc:mysql://localhost:3306/abc_restaurant_database";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "MKS@jay123";
    
   
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Retrieve form parameters
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String mobile = request.getParameter("mobile");
        String password = request.getParameter("password");

        // Database connection and query
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            // Establish database connection
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            // Prepare SQL statement
            String sql = "INSERT INTO register (name, email, mobile, password) VALUES (?, ?, ?, ?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, email);
            preparedStatement.setString(3, mobile);
            preparedStatement.setString(4, password);

            // Execute the query
            int rowsInserted = preparedStatement.executeUpdate();
            
            if (rowsInserted > 0) {
                // Registration successful
                HttpSession session = request.getSession();
                session.setAttribute("message", "Registration successful!");
                response.sendRedirect("success.jsp"); // Redirect to a success page
            } else {
                // Registration failed
                HttpSession session = request.getSession();
                session.setAttribute("message", "Registration failed. Please try again.");
                response.sendRedirect("register.jsp"); // Redirect to the registration page
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            // Handle errors
            HttpSession session = request.getSession();
            session.setAttribute("message", "An error occurred: " + e.getMessage());
            response.sendRedirect("register.jsp");
        } finally {
            // Close resources
            try {
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}


