package com.abc.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection1 {
	private static final String DB_URL = "jdbc:mysql://localhost:3306/abc_restaurant_database";
	private static final String DB_USER = "root";
	private static final String DB_PASSWORD = "MKS@jay123";

	private static DBConnection1 instance;
	private Connection connection;

	private DBConnection1() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			this.connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	public static DBConnection1 getInstance() {
		if (instance == null) {
			synchronized (DBConnection1.class) {
				if (instance == null) {
					instance = new DBConnection1();
				}
			}
		}
		return instance;
	}

	public Connection getConnection() {
		return connection;
	}

}
