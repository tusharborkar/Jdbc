package InsertIntoTableExample1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Test {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcassignment", "root",
				"root");
		String sql = "insert into student values(?,?,?)";

		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1, 101);
		preparedStatement.setString(2, "tushar");
		preparedStatement.setDouble(3, 66.66);
		preparedStatement.executeUpdate();
		connection.close();

	}

}
