package com.abc.dao;

import java.sql.Connection;

public class DBConnectionFactory1 {
	 public static Connection getConnection() {
	        return DBConnection1.getInstance().getConnection();
	    }

}
