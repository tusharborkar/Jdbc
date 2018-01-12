package com.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DisplayTest {

	public static Connection JdbcConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/onetoone", "root", "root");
		return connection;
	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		ResultSet resultSet = JdbcConnection().prepareStatement("select * from person").executeQuery();
		List<Person> PersonList = new ArrayList();

		while (resultSet.next()) {
			Person person = new Person();
			person.setPersonId(resultSet.getInt(1));
			person.setPersonName(resultSet.getString(2));
			PersonList.add(person);
		}

		List<Person> list = new ArrayList();
		for (Person person : PersonList) {
			ResultSet resultSet2 = JdbcConnection()
					.prepareStatement("select * from pan where panid= " + person.getPersonId()).executeQuery();

			while (resultSet2.next()) {

				Pan pan = new Pan();
				pan.setPanId(resultSet2.getInt(1));
				pan.setPanNumber(resultSet2.getString(2));
				person.setPan(pan);
				pan.setPerson(person);
				list.add(person);

			}
		}

		for (Person person2 : list) {
			System.out.println(
					person2.getPersonId() + "   " + person2.getPersonName() + "   " + person2.getPan().getPanNumber());
		}

	}
}
