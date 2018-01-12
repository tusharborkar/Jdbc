package InsertAndDeleteExample2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Test {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcassignment", "root",
				"root");
		String sql = "insert into employee values(?,?,?)";

		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1, 003);
		preparedStatement.setString(2, "Mr.Nilpwar");
		preparedStatement.setDouble(3, 30000);
		preparedStatement.executeUpdate();
		System.out.println("insert");
		System.out.println("*******");
		String sql1 = "delete from employee where id=001";
		PreparedStatement preparedStatement1 = connection.prepareStatement(sql1);
		preparedStatement1.executeUpdate();
		System.out.println("deletded");
		connection.close();

	}

}
