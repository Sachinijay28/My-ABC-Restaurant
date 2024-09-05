package com.abc.controller;

import static org.mockito.Mockito.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.junit.Before;
import org.junit.Test;


import java.io.IOException;

public class ReservationsServletTest {
	
	private ReservationsServlet servlet;
    private HttpServletRequest mockRequest;
    private HttpServletResponse mockResponse;
    private RequestDispatcher mockDispatcher;

    @Before
    public void setUp() {
        servlet = new ReservationsServlet();
        mockRequest = mock(HttpServletRequest.class);
        mockResponse = mock(HttpServletResponse.class);
        mockDispatcher = mock(RequestDispatcher.class);

        when(mockRequest.getRequestDispatcher(anyString())).thenReturn(mockDispatcher);
    }

    @Test
    public void testDoGetPass() throws ServletException, IOException {
        // Call the doGet method
        servlet.doGet(mockRequest, mockResponse);

        // Assert that the correct attributes were set
        verify(mockRequest).setAttribute("pageTitle", "Reservations");
        verify(mockRequest).setAttribute("reservationDescription", "Book a table for your next visit.");

        // Verify that the request was forwarded to the correct JSP
        verify(mockRequest).getRequestDispatcher("/WEB-INF/jsp/reservations.jsp");
        verify(mockDispatcher).forward(mockRequest, mockResponse);
    }

}
