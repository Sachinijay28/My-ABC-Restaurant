package com.abc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.abc.model.Contact;


public class ContactDAO {
	
	private String jdbcURL = "jdbc:mysql://localhost:3306/abc_restaurant_database"; //  DB details
    private String jdbcUsername = "root";
    private String jdbcPassword = "MKS@jay123";

    private static final String INSERT_CONTACT_SQL = "INSERT INTO queries (name, email, contactNumber, message) VALUES (?, ?, ?, ?)";
    private static final String SELECT_ALL_CONTACTS_SQL = "SELECT * FROM queries";

    public ContactDAO() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

 // Method to establish a database connection
    protected Connection getConnection() throws SQLException {
        return DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
    }

    // Method to save contact details to the database
    public boolean saveContact(Contact contact) {
        boolean isSaved = false;

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CONTACT_SQL)) {

            // Setting the parameters in the query
            preparedStatement.setString(1, contact.getName());
            preparedStatement.setString(2, contact.getEmail());
            preparedStatement.setString(3, contact.getContactNumber());
            preparedStatement.setString(4, contact.getMessage());

            // Execute the query
            isSaved = preparedStatement.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isSaved;
    }

    // Method to retrieve all contact queries from the database
    public List<Contact> getAllContacts() {
        List<Contact> queries = new ArrayList<>();

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CONTACTS_SQL)) {

            ResultSet rs = preparedStatement.executeQuery();

            // Process the result set and add each contact to the list
            while (rs.next()) {
                String name = rs.getString("name");
                String email = rs.getString("email");
                String contactNumber = rs.getString("contact_number");
                String message = rs.getString("message");

                queries.add(new Contact(name, email, contactNumber, message));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return queries;
    }


}
