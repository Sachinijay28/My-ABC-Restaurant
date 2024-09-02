package com.abc.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SearchServlet
 */
@WebServlet("/search")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	// Database connection details
    private static final String DB_URL = "jdbc:mysql://localhost:3306/your_database";
    private static final String DB_USER = "your_username";
    private static final String DB_PASSWORD = "your_password";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String query = request.getParameter("query");

	        // Setup for response
	        response.setContentType("text/html;charset=UTF-8");
	        PrintWriter out = response.getWriter();

	        // Database connection and query
	        Connection connection = null;
	        PreparedStatement preparedStatement = null;
	        ResultSet resultSet = null;

	        try {
	            // Establish database connection
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

	            // Prepare SQL statement
	            String sql = "SELECT * FROM items WHERE name LIKE ?";
	            preparedStatement = connection.prepareStatement(sql);
	            preparedStatement.setString(1, "%" + query + "%");

	            // Execute the query
	            resultSet = preparedStatement.executeQuery();

	            // Generate HTML response
	            out.println("<html><body>");
	            out.println("<h1>Search Results</h1>");
	            out.println("<table border='1'>");
	            out.println("<tr><th>ID</th><th>Name</th><th>Description</th></tr>");

	            while (resultSet.next()) {
	                int id = resultSet.getInt("id");
	                String name = resultSet.getString("name");
	                String description = resultSet.getString("description");

	                out.println("<tr>");
	                out.println("<td>" + id + "</td>");
	                out.println("<td>" + name + "</td>");
	                out.println("<td>" + description + "</td>");
	                out.println("</tr>");
	            }

	            out.println("</table>");
	            out.println("</body></html>");

	        } catch (ClassNotFoundException | SQLException e) {
	            e.printStackTrace();
	            out.println("<html><body>");
	            out.println("<h1>An error occurred</h1>");
	            out.println("<p>" + e.getMessage() + "</p>");
	            out.println("</body></html>");
	        } finally {
	            // Close resources
	            try {
	                if (resultSet != null) resultSet.close();
	                if (preparedStatement != null) preparedStatement.close();
	                if (connection != null) connection.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	    }
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
