package com.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Insert {

	public static Connection JdbcConnection() throws ClassNotFoundException, SQLException {

		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/onetoone", "root", "root");
		return connection;

	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Scanner scanner = new Scanner(System.in);

		System.out.println("enter the person id");
		int personid = scanner.nextInt();
		System.out.println("enter the Person Name");
		Person person = new Person();
		String name = scanner.next();
		person.setPersonId(personid);
		person.setPersonName(name);

		System.out.println("enter your Pan number");
		String panno = scanner.next();
		Pan pan = new Pan();
		pan.setPanNumber(panno);
		pan.setPanId(personid);
		JdbcConnection().prepareStatement("insert into person values(      "+person.getPersonId()+"   , '" + person.getPersonName() + "')")
				.execute();
		boolean result2 = JdbcConnection().prepareStatement("insert into pan(panid, panname) values(" + pan.getPanId()
				+ "       ,       '" + pan.getPanNumber() + "')").execute();
		if (result2 == false) {
			System.out.println("success");

		} else {
			System.out.println("error");
		}

	}

}
