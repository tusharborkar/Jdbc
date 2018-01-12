package curd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DynamicInput {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		Scanner scanner = new Scanner(System.in);
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
		Statement statement = connection.createStatement();

		System.out.println("how many student u want to add");
		int addStudent = scanner.nextInt();

		for (int i = 0; i < addStudent; i++) {
			Student student = new Student();
			System.out.println("enter student name");
			String name = scanner.next();
			student.setName(name);
			boolean resultSet = statement.execute("insert into student(name) values('" + student.getName() + "')");

			if (resultSet == false) {
				System.out.println("success");
			} else {
				System.out.println("failed");
			}

		}

		connection.close();
	}
}