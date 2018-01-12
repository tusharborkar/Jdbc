package resultSetMetaDataExample5;

import java.lang.Thread.State;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class Test {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcassignment", "root",
				"root");

		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery("select * from employee");
		ResultSetMetaData data = resultSet.getMetaData();
		System.out.println("datatype......");
		System.out.println(data.getColumnTypeName(1));
		System.out.println(data.getColumnTypeName(2));
		System.out.println(data.getColumnTypeName(3));

		System.out.println("count.....");
		System.out.println(data.getColumnCount());
		System.out.println("name....");
		System.out.println(data.getColumnName(1));
		System.out.println(data.getColumnName(2));
		System.out.println(data.getColumnName(3));
	}
}
