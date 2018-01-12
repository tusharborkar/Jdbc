package curd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class delete {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
		Statement statement = connection.createStatement();
		String sql = "delete from student where id=19";
		statement.execute(sql);
		System.out.println("deleted");

	}

}
