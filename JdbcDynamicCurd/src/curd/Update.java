package curd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Update {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
		Statement statement = connection.createStatement();

		String sql = "update student set address='pune' where name='a'";
		statement.executeUpdate(sql);
		System.out.println("updated");
		connection.close();

	}

}
