package CurdOperation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class Update {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("class loaded");
		String url = "jdbc:mysql://localhost:3306/movie";

		String username = "root";
		String password = "root";

		Connection connection = DriverManager.getConnection(url, username,password);
		System.out.println("connection created");
		String sql="update movie set actor='imran' where id=105";
		PreparedStatement statement = connection.prepareStatement(sql);
		System.out.println("statement executed");
		statement.executeUpdate();
		System.out.println("complete");
	}
}
