package ResultSetMetaData;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class Test {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/resultsetmetadata", "root",
				"root");
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery("select * from student");
		ResultSetMetaData data = resultSet.getMetaData();
		System.out.println(" count  " + data.getColumnCount());
		System.out.println(" display size  " + data.getColumnDisplaySize(2));
		System.out.println("column name  " + data.getColumnName(1));
		System.out.println(data.isAutoIncrement(1));

	}

}
