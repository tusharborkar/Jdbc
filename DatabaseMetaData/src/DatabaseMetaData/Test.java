package DatabaseMetaData;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Test {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/databasemetadata", "root",
				"root");
		DatabaseMetaData data = connection.getMetaData();
		System.out.println(data.getIdentifierQuoteString());
		System.out.println(data.getDatabaseMajorVersion());
		System.out.println(data.getDriverMinorVersion());
		System.out.println(data.getUserName());
		System.out.println(data.getDriverName());

	}

}
