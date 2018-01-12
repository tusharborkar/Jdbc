package addbatchANDexecutebatch;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class AddBatch {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/batchprocessing", "root",
				"root");

		Statement statement = connection.createStatement();
		statement.addBatch("insert into student values(123, 'bunty' , '123123123')");

		statement.executeBatch();
	}

}
