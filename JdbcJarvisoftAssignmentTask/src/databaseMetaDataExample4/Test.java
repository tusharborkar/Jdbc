package databaseMetaDataExample4;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Test {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcassignment", "root",
				"root");

		DatabaseMetaData data = connection.getMetaData();
		System.out.println(data.getDatabaseProductName());
		System.out.println(data.getDatabaseProductVersion());
		System.out.println(data.getTables("jdbcassignment", "null", "null", null));
		connection.close();

	}
}
