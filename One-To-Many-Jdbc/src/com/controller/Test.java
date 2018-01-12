package com.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.model.Student;
import com.model.StudentInfo;

public class Test {


	Scanner scanner = new Scanner(System.in);

	public static Connection getJdbcConnection() throws ClassNotFoundException, SQLException {

		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/onetomamyrelation", "root",
				"root");
		return connection;
	}

	public void insert() throws ClassNotFoundException, SQLException {
		System.out.println("enter student ID");
		int id = scanner.nextInt();
		System.out.println("Enter Student Name");
		String name = scanner.next();
		Student student = new Student();
		StudentInfo studentInfo = new StudentInfo();
		student.setStudentid(id);
		student.setStudentName(name);

		System.out.println("how many address u want add");
		int selectadd = scanner.nextInt();
		List<StudentInfo> studentinfoaddress = new ArrayList<>();
		for (int i = 0; i < selectadd; i++) {

			studentInfo.setStudentnfoId(id);
			System.out.println("enter student Aaddress");
			String studentadd = scanner.next();
			studentInfo.setAddress(studentadd);
			studentinfoaddress.add(studentInfo);
			student.setStudentInfoList(studentinfoaddress);
			studentInfo.setStudent(student);

		}
		boolean resultSet = getJdbcConnection().prepareStatement("insert into student values('" + student.getStudentid()
				+ "'      ,   '" + student.getStudentName() + "')").execute();
		System.out.println("Student name inserted");

		boolean resultSet2 = getJdbcConnection()
				.prepareStatement("insert into studentinfo values('" + studentInfo.getStudentnfoId() + "'  ,   '"
						+ studentInfo.getAddress() + "'  ,  '" + student.getStudentid() + "' )")
				.execute();
		if (resultSet2 == false) {
			System.out.println("success");
		} else {
			System.out.println("error");
		}

	}

	public void update() {

	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		Test test = new Test();
		test.insert();
		test.update();

	}

}
