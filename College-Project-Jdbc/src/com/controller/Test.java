package com.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class Test {

	public static Connection getJdbcConnection() throws ClassNotFoundException, SQLException {

		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/collegeproject", "root",
				"root");
		return connection;

	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Scanner scanner = new Scanner(System.in);
		do {
			System.out.println("1. Add Course");
			System.out.println("2. Add Faculty");
			System.out.println("3. Add Batch");
			System.out.println("4. Add Student");
			System.out.println("5. Display Course ");
			System.out.println("6. Display Faculty ");
			System.out.println("7. Display Batch ");
			System.out.println("8. Display Student ");
			
			System.out.println();
			System.out.println("select one option from above");
			int selection = scanner.nextInt();

			CollegeInterface collegeInterface = new CollegeInterfaceImpl();

			switch (selection) {
			case 1:
				collegeInterface.addcourse();

				break;
			case 2:
				collegeInterface.addfaculty();
				

				break;
			case 3:
				collegeInterface.addbatch();

				break;
			case 4:
				collegeInterface.addstudent();

				break;
			case 5:
				collegeInterface.displayCourse();

				break;
			case 6:
				collegeInterface.displayFaculty();

				break;
			case 7:
				collegeInterface.displayBatch();

				break;
			case 8:
				collegeInterface.displayStudent();

				break;
			default:
				System.out.println("enter valid number");
				break;
			}

		} while (true);
	}
}
