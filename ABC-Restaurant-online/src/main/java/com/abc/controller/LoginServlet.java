package com.abc.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    
   public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
    }
	
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Retrieve form parameters
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String usertype = request.getParameter("usertype");

        // Simple user authentication
        if (authenticate(username, password,usertype)) {
            HttpSession session = request.getSession();
            session.setAttribute("username", username);
            session.setAttribute("usertype", usertype);
            
            // Set success message
            request.setAttribute("message", "Login successful!");


            // Redirect based on user type
            switch (usertype) {
                case "user":
                    response.sendRedirect("home.jsp");
                    break;
                case "admin":
                    response.sendRedirect("admin.jsp");
                    break;
                case "staff":
                    response.sendRedirect("staff.jsp");
                    break;
                default:
                    response.sendRedirect("login.jsp");
                    break;
            }
        } else {
            // Authentication failed
            request.setAttribute("error", "Invalid username, password, or usertype.");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }

    // A simple method to simulate user authentication
    private boolean authenticate(String username, String password, String usertype) {
    
        return ("user".equals(username) && "userpass".equals(password) && "user".equals(usertype))
        	||	("admin".equals(username) && "adminpass".equals(password) && "admin".equals(usertype))
            || ("staff".equals(username) && "staffpass".equals(password) && "staff".equals(usertype))
            ;
    }

}
