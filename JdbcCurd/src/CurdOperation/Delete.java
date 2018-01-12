package CurdOperation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class Delete {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("clsss loaded");
		String url = "jdbc:mysql://localhost:3306/jdbccurd";
		String username = "root";
		String password = "root";
		Connection connection = DriverManager.getConnection(url, username, password);
		System.out.println("connection created");
		String sql = "delete from student where id=1011";
		PreparedStatement statement = connection.prepareStatement(sql);
		System.out.println("statement executed");
		// statement.executeUpdate();
		// statement.execute();
		System.out.println("complete");

	}
}
