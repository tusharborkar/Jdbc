package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Test {

	public static void main(String[] args) {
		Connection connection = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcdemo", "root", "root");
			Statement statement = connection.createStatement();

			Student s = new Student();
			s.setName("akshay");
			s.setName("tushar");

			Boolean result = statement.execute("insert into student(name) values('" + s.getName() + "')");
			if (result == false) {
				System.out.println("success");
			} else {
				System.out.println("failed");
			}

			ResultSet rs = statement.executeQuery("select * from student");
			while (rs.next()) {
				System.out.println(rs.getInt(1));
				System.out.println(rs.getString(2));
			}

			/*
			 * 
			 * 
			 * System.err.println("+++++++++++++++++++++++++++++++++++++++++++++");
			 * statement.executeUpdate("update student set name='tushar'  where id=1");
			 * 
			 * 
			 * 
			 * ResultSet rs1 = statement.executeQuery("select * from student"); while
			 * (rs1.next()) { System.out.println(rs1.getInt(1));
			 * System.out.println(rs1.getString(2)); }
			 */
			rs.close();
			statement.close();
			connection.close();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
