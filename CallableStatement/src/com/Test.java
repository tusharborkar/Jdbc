package com;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Test {

	public static Connection display() throws ClassNotFoundException, SQLException {

		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/callable", "root", "root");
		CallableStatement callableStatement = connection.prepareCall("CALL callable.display()");
		ResultSet resultSet = callableStatement.executeQuery();
		System.out.println("data from student table is......");
		while (resultSet.next()) {
			System.out.println(resultSet.getInt(1) + "  " + resultSet.getString(2));
		}

		return connection;
	}

	public static Connection insert() throws ClassNotFoundException, SQLException {

		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/callable", "root", "root");
		CallableStatement callableStatement = connection.prepareCall("CALL callable.`insert`(?)");

		callableStatement.setString(1, "akshay");

		int result = callableStatement.executeUpdate();
		if (result > 0) {
			System.out.println("success");
		} else {
			System.out.println("errror");
		}

		return connection;
	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Test test = new Test();
		test.insert();
		System.out.println("********************");
		test.display();
	}
}
