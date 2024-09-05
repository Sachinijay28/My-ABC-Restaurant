package com.abc.dao;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;

public class RegisterDAOTest {
	
	private RegisterDAO registerDAO;
    private Connection mockConnection;
    private PreparedStatement mockPreparedStatement;

    @Before
    public void setUp() throws SQLException {
        registerDAO = new RegisterDAO();
        mockConnection = mock(Connection.class);
        mockPreparedStatement = mock(PreparedStatement.class);

        // Mock the connection to return a prepared statement
        when(mockConnection.prepareStatement(anyString())).thenReturn(mockPreparedStatement);

        // Mock the static method DriverManager.getConnection to return the mockConnection
        mockStatic(DriverManager.class);
        when(DriverManager.getConnection(anyString(), anyString(), anyString())).thenReturn(mockConnection);
    }

    @Test
    public void testRegisterUserPass() throws SQLException {
        // Simulate a successful registration (e.g., one row affected)
        when(mockPreparedStatement.executeUpdate()).thenReturn(1);

        // Call the registerUser method with test data
        boolean isRegistered = registerDAO.registerUser("Amal", "amal@gmail.com", "1234567890", "amal123");

        // Assert that the registration was successful
        assertTrue(isRegistered);

        // Verify that the SQL query was executed
        verify(mockPreparedStatement).setString(1, "Amal");
        verify(mockPreparedStatement).setString(2, "amal@gmail.com");
        verify(mockPreparedStatement).setString(3, "1234567890");
        verify(mockPreparedStatement).setString(4, "amal123");
    }

}
