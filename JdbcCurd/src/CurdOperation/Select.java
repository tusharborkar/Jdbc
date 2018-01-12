package CurdOperation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Select {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("loaded driver");
		String URL = "jdbc:mysql://localhost:3306/jdbccurd";

		String username = "root";

		String password = "root";

		Connection connection = DriverManager.getConnection(URL, username, password);
		System.out.println("connection created");
		// Statement statement = connection.createStatement();
		PreparedStatement statement = connection.prepareStatement("select * from student");
		System.out.println("statement created");

		ResultSet resultSet = statement.executeQuery();
		System.out.println("stored in resultset");
		while (resultSet.next()) {
			System.out.println(
					resultSet.getInt(1) + "  " + resultSet.getString("name") + "  " + resultSet.getString("actor"));
		}
		System.out.println("complete");
	}
}
