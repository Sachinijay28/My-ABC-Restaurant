package com.abc.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.abc.model.Reservation;


public class ReservationsDAO {
	
	 private String jdbcURL = "jdbc:mysql://localhost:3306/abc_restaurant_database";
	    private String jdbcUsername = "root";
	    private String jdbcPassword = "MKS@jay123";

	    private static final String INSERT_RESERVATION = "INSERT INTO reservations (name, email, phone, date, time, guests) VALUES (?, ?, ?, ?, ?, ?)";
	    private static final String SELECT_RESERVATION = "SELECT * FROM reservations WHERE id = ?";
	    private static final String SELECT_ALL_RESERVATIONS = "SELECT * FROM reservations";
	    private static final String DELETE_RESERVATION = "DELETE FROM reservations WHERE id = ?";
	    private static final String UPDATE_RESERVATION = "UPDATE reservations SET name = ?, email = ?, phone = ?, date = ?, time = ?, guests = ? WHERE id = ?";

	    protected Connection getConnection() {
	        Connection connection = null;
	        try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } catch (ClassNotFoundException e) {
	            e.printStackTrace();
	        }
	        return connection;
	    }

	    public void addReservation(Reservation reservation) {
	        try (Connection connection = getConnection();
	             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_RESERVATION)) {
	            preparedStatement.setString(1, reservation.getName());
	            preparedStatement.setString(2, reservation.getEmail());
	            preparedStatement.setString(3, reservation.getPhone());
	            preparedStatement.setString(4, reservation.getDate());
	            preparedStatement.setString(5, reservation.getTime());
	            preparedStatement.setInt(6, reservation.getGuests());
	            preparedStatement.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    public Reservation getReservation(int id) {
	        Reservation reservation = null;
	        try (Connection connection = getConnection();
	             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_RESERVATION)) {
	            preparedStatement.setInt(1, id);
	            ResultSet rs = preparedStatement.executeQuery();

	            while (rs.next()) {
	                String name = rs.getString("name");
	                String email = rs.getString("email");
	                String phone = rs.getString("phone");
	                String date = rs.getString("date");
	                String time = rs.getString("time");
	                int guests = rs.getInt("guests");
	                reservation = new Reservation(id, name, email, phone, date, time, guests);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return reservation;
	    }

	    public List<Reservation> getAllReservations() {
	        List<Reservation> reservations = new ArrayList<>();
	        try (Connection connection = getConnection();
	             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_RESERVATIONS)) {
	            ResultSet rs = preparedStatement.executeQuery();

	            while (rs.next()) {
	                int id = rs.getInt("id");
	                String name = rs.getString("name");
	                String email = rs.getString("email");
	                String phone = rs.getString("phone");
	                String date = rs.getString("date");
	                String time = rs.getString("time");
	                int guests = rs.getInt("guests");
	                reservations.add(new Reservation(id, name, email, phone, date, time, guests));
	                System.out.println("Retrieved reservation: " + reservations); 
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        System.out.println("Total reservations retrieved: " + reservations.size());
	        return reservations;
	    }

	    public boolean deleteReservation(int id) {
	        boolean rowDeleted = false;
	        try (Connection connection = getConnection();
	             PreparedStatement statement = connection.prepareStatement(DELETE_RESERVATION)) {
	            statement.setInt(1, id);
	            rowDeleted = statement.executeUpdate() > 0;
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return rowDeleted;
	    }

	    public boolean updateReservation(Reservation reservation) {
	        boolean rowUpdated = false;
	        try (Connection connection = getConnection();
	             PreparedStatement statement = connection.prepareStatement(UPDATE_RESERVATION)) {
	            statement.setString(1, reservation.getName());
	            statement.setString(2, reservation.getEmail());
	            statement.setString(3, reservation.getPhone());
	            statement.setString(4, reservation.getDate());
	            statement.setString(5, reservation.getTime());
	            statement.setInt(6, reservation.getGuests());
	            statement.setInt(7, reservation.getId());

	            rowUpdated = statement.executeUpdate() > 0;
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return rowUpdated;
	    }
	}

	
	

	    


