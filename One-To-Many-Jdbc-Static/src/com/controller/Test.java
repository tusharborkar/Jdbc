package com.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.model.Student;
import com.model.StudentInfo;

public class Test {

	public static Connection getJdbcConnection() throws ClassNotFoundException, SQLException {

		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/onetomamyrelation", "root",
				"root");
		return connection;
	}

	public void insert() throws ClassNotFoundException, SQLException {
		Student student = new Student();
		student.setStudentName("Acchyut");

		List<StudentInfo> address = new ArrayList<>();
		StudentInfo studentInfo1 = new StudentInfo();
		studentInfo1.setAddress("Latur");
		StudentInfo studentInfo2 = new StudentInfo();
		studentInfo2.setAddress("Pune");

		address.add(studentInfo1);
		address.add(studentInfo2);
		student.setStudentInfoList(address);

		boolean result = getJdbcConnection()
				.prepareStatement("insert into student(studentname) values('" + student.getStudentName() + "' )")
				.execute();
		if (result == false) {
			System.out.println("inserted....");
			ResultSet resultSet = getJdbcConnection().prepareStatement("select max(studentid)from student")
					.executeQuery();
			while (resultSet.next()) {

				int maxid = resultSet.getInt(1);
				student.setStudentid(maxid);

				List<StudentInfo> list = student.getStudentInfoList();
				for (StudentInfo studentInfo : list) {

					boolean result2 = getJdbcConnection()
							.prepareStatement("insert into studentinfo(address, sid) values('"
									+ studentInfo.getAddress() + "'  ,   '" + student.getStudentid() + "')")
							.execute();
					if (result2 == false) {
						System.out.println("insertde");
					} else {
						System.out.println("error");
					}

				}
			}

		} else {
			System.out.println("error");
		}
	}

	public void display() throws ClassNotFoundException, SQLException {
		ResultSet resultSet = getJdbcConnection().prepareStatement("select * from student").executeQuery();
		List<Student> slist = new ArrayList();
		while (resultSet.next()) {
			Student student = new Student();
			student.setStudentid(resultSet.getInt(1));
			student.setStudentName(resultSet.getString(2));
			slist.add(student);
		}
		List<Student> studentlist = new ArrayList<>();

		for (Student student : slist) {

			List<StudentInfo> infolist = new ArrayList();
			ResultSet resultSet2 = getJdbcConnection()
					.prepareStatement("select * from studentinfo where sid='" + student.getStudentid() + "'")
					.executeQuery();

			while (resultSet2.next()) {

				StudentInfo studentInfo = new StudentInfo();
				studentInfo.setStudentnfoId(resultSet2.getInt(1));
				studentInfo.setAddress(resultSet2.getString(2));
				studentInfo.setStudent(student);
				infolist.add(studentInfo);

			}
			student.setStudentInfoList(infolist);
			studentlist.add(student);

		}
		for (Student student : studentlist) {

			System.out.println(student.getStudentid() + "   " + student.getStudentName());
			List<StudentInfo> infolist = student.getStudentInfoList();
			for (StudentInfo studentInfo : infolist) {
				System.out.println(
						"                     " + studentInfo.getStudentnfoId() + "  " + studentInfo.getAddress());
			}
		}

	}

	public void delete() throws ClassNotFoundException, SQLException {
		display();
		System.out.println("which record do you want to delete");
		Scanner scanner = new Scanner(System.in);
		int selectfordelete = scanner.nextInt();

		boolean result3 = getJdbcConnection()
				.prepareStatement("delete from student where studentid='" + selectfordelete + "'").execute();

		if (result3 == false) {
			System.out.println("sucess    record id deleted");
		} else {
			System.out.println("error");
		}

	}

	public void update() throws ClassNotFoundException, SQLException {
		display();
		Scanner scanner = new Scanner(System.in);

		System.out.println("what do you want to update");

		int selectforupdate = scanner.nextInt();
		PreparedStatement preparedStatement = getJdbcConnection()
				.prepareStatement("update student set studentname=? where studentid='" + selectforupdate + "'");
		System.out.println("enter name that u want to update for selected id");
		String updatedname = scanner.next();
		preparedStatement.setString(1, updatedname);
		boolean result = preparedStatement.execute();
		if (result == false) {
			System.out.println("updated...");
		} else {
			System.out.println("error");
		}
		System.out.println();
		System.out.println("*************");
		System.out.println();

		PreparedStatement preparedStatement1 = getJdbcConnection()
				.prepareStatement("update studentinfo set address=?  where studentnfoId=?");
		System.out.println("how many address u want to update");
		int noofcity = scanner.nextInt();
		for (int i = 1; i <= noofcity; i++) {
			System.out.println("enter ID of the city");
			preparedStatement1.setInt(2, scanner.nextInt());
			System.out.println("enter new address for selected ID");
			preparedStatement1.setString(1, scanner.next());

			int result2 = preparedStatement1.executeUpdate();
			if (result2> 0) {
				System.out.println("Updated....");
			} else {
				System.out.println("error");
			}
		}
	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Test test = new Test();
		/*
		 * test.display(); test.insert();
		 * 
		 * test.delete();
		 */

		test.update();
	}
}
