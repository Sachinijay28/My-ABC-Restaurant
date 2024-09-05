package com.abc.controller;

import static org.mockito.Mockito.*;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Before;
import org.junit.Test;


public class ContactServletTest {
	
	private ContactServlet servlet;
    private HttpServletRequest request;
    private HttpServletResponse response;
    private RequestDispatcher dispatcher;

    @Before
    public void setUp() throws Exception {
       
        servlet = new ContactServlet();
        request = mock(HttpServletRequest.class);
        response = mock(HttpServletResponse.class);
        dispatcher = mock(RequestDispatcher.class);
        
        when(request.getRequestDispatcher(anyString())).thenReturn(dispatcher);
    }

    @Test
    public void testDoPostFail() throws ServletException, IOException {
        when(request.getParameter("name")).thenReturn("Amal");
        when(request.getParameter("email")).thenReturn("amal@gmail.com");
        when(request.getParameter("contactNumber")).thenReturn("userpass");
        when(request.getParameter("message")).thenReturn("Hello!");

        // Incorrect expected output to simulate test failure
        String expectedRedirect = "contact.jsp";

        servlet.doPost(request, response);

        verify(response).sendRedirect(expectedRedirect);
    }
}
