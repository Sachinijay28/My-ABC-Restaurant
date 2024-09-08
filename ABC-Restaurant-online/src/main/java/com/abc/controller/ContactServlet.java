package com.abc.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.abc.dao.ContactDAO;
import com.abc.model.Contact;


@WebServlet("/contact")
public class ContactServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public ContactServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/jsp/contact.jsp").forward(request, response);
		
    }
	
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	// Retrieve form data
       String name = request.getParameter("name");
       String email = request.getParameter("email");
       String contactNumber = request.getParameter("contactNumber");
       String message = request.getParameter("message");

       // Create a Contact object
       Contact contact = new Contact(name, email, contactNumber, message);

       // Save the contact using ContactDAO
       ContactDAO contactDAO = new ContactDAO();
       boolean isSaved = contactDAO.saveContact(contact);

       // Redirect based on save success or failure
       if (isSaved) {
           response.sendRedirect("viewqueries.jsp");
       } else {
           response.sendRedirect("contact.jsp");
       }
   }
}


