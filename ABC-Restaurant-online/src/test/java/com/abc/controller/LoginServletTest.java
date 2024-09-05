package com.abc.controller;

import static org.mockito.Mockito.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.junit.Before;
import org.junit.Test;

public class LoginServletTest {
	
	 private LoginServlet servlet;
	    private HttpServletRequest request;
	    private HttpServletResponse response;
	    private HttpSession session;

	    @Before
	    public void setUp() throws Exception {
	       
	        servlet = new LoginServlet();
	        request = mock(HttpServletRequest.class);
	        response = mock(HttpServletResponse.class);
	        session = mock(HttpSession.class);

	        when(request.getSession()).thenReturn(session);
	    }

	    @Test
	    public void testDoPostPass() throws ServletException, IOException {
	        // Mock request parameters for a successful user login
	        when(request.getParameter("username")).thenReturn("user");
	        when(request.getParameter("password")).thenReturn("userpass");
	        when(request.getParameter("usertype")).thenReturn("user");

	        // Call the doPost method
	        servlet.doPost(request, response);

	        // Verify that the session attributes are set correctly
	        verify(session).setAttribute("username", "user");
	        verify(session).setAttribute("usertype", "user");

	        // Verify that it redirects to the correct page
	        verify(response).sendRedirect("home.jsp");
	    }

}
