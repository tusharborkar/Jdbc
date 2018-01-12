package com.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Test {
	Scanner scanner = new Scanner(System.in);

	public static Connection JdbcConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/onetoone", "root", "root");
		return connection;
	}

	public void insert() throws ClassNotFoundException, SQLException {

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
		JdbcConnection().prepareStatement(
				"insert into person values(      " + person.getPersonId() + "   , '" + person.getPersonName() + "')")
				.execute();
		boolean result2 = JdbcConnection().prepareStatement("insert into pan(panid, panname) values(" + pan.getPanId()
				+ "       ,       '" + pan.getPanNumber() + "')").execute();
		if (result2 == false) {
			System.out.println("success");

		} else {
			System.out.println("error");
		}

	}

	public void display() throws ClassNotFoundException, SQLException {

		ResultSet resultSet = JdbcConnection().prepareStatement("select * from person").executeQuery();
		List<Person> personList = new ArrayList();

		while (resultSet.next()) {
			Person person = new Person();
			person.setPersonId(resultSet.getInt(1));
			person.setPersonName(resultSet.getString(2));
			personList.add(person);
		}

		List<Person> list = new ArrayList();

		for (Person person : personList) {

			ResultSet resultSet2 = JdbcConnection()
					.prepareStatement("select * from pan where panid=" + person.getPersonId()).executeQuery();
			while (resultSet2.next()) {
				Pan pan = new Pan();
				pan.setPanId(resultSet2.getInt(1));
				pan.setPanNumber(resultSet2.getString(2));

				person.setPan(pan);
				pan.setPerson(person);
				list.add(person);
			}
		}
		Iterator<Person> itr = list.iterator();
		while (itr.hasNext()) {
			Person person2 = (Person) itr.next();
			System.out.println(person2.getPersonId() + "\t" + person2.getPersonName() + "\t     "
					+ person2.getPan().getPanNumber());

		}

	}

	public void update() throws ClassNotFoundException, SQLException {

		display();
		
	

			String sql = " update person set pname=? where pid=?";
			   PreparedStatement preparedStatement = JdbcConnection().prepareStatement(sql);
			   System.out.println("enter how many pid you want to update"); 
			   int updateId =scanner.nextInt();
			   for (int i = 0; i < updateId; i++) {
			   
			   System.out.println("enter pid that you want to update"); 
			   int id =scanner.nextInt(); 
			   preparedStatement.setInt(2, id);
			   System.out.println("enter new pname for that ID"); 
			   String name =scanner.next();
			   preparedStatement.setString(1, name);
			   
			
			   preparedStatement.executeUpdate(); 
			   System.out.println("updated,....."); 
			
			
		}

	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		Test test = new Test();
		test.insert();

		test.display();
		test.update();

	}
}
