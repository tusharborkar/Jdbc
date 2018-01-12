package Commit;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Test {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");

		connection.setAutoCommit(false);
		Statement statement = connection.createStatement();
		statement.executeUpdate("insert into student values(1,'Tushar')");
		statement.executeUpdate("insert into student values(4,'Dhiraj')");
		connection.commit();
		connection.close();

	}

}
