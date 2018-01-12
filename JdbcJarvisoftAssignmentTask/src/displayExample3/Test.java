package displayExample3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Test {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcassignment", "root",
				"root");

		Statement statement = connection.createStatement();
		String sql = "select * from employee";
		ResultSet resultSet = statement.executeQuery(sql);
		System.out.println("the given data is");
		while (resultSet.next()) {
			System.out.println(resultSet.getInt(1) + "  " + resultSet.getString(2) + "   " + resultSet.getDouble(3));

		}
		System.out.println("end");
		connection.close();

	}
}
