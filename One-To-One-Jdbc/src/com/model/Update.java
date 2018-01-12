package com.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Update {

	public static Connection JdbcConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/onetoone", "root", "root");
		return connection;
	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

	
		JdbcConnection().prepareStatement("update").executeQuery();

		
		
	}
}
