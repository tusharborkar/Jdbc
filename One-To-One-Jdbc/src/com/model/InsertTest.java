package com.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class InsertTest {

	public static Connection JdbcConnection() throws ClassNotFoundException, SQLException {

		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/onetoone", "root", "root");
		return connection;

	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Scanner scanner = new Scanner(System.in);

		System.out.println("enter the Person Name");
		Person person = new Person();
		String name = scanner.next();
		person.setPersonName(name);

		System.out.println("enter your Pan number");
		String panno = scanner.next();
		Pan pan = new Pan();
		pan.setPanNumber(panno);
		boolean result = JdbcConnection().prepareStatement("insert into person values('" + person.getPersonName() + "')").execute();
		if (result == false) {
			ResultSet resultSet = JdbcConnection().prepareStatement("select max(pid) from person").executeQuery();
			if (resultSet.next()) {
				pan.setPanId(resultSet.getInt(1));
				boolean result2 = JdbcConnection().prepareStatement("insert into pan(panid, panname) values("
						+ pan.getPanId() + "       ,       '" + pan.getPanNumber() + "')").execute();
				if (result2 == false) {
					System.out.println("success");

				} else {
					System.out.println("error");
				}
			}

		} else {

			System.out.println("error");
		}

	}

}
