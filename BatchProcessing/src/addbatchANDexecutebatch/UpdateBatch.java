package addbatchANDexecutebatch;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateBatch {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/batchprocessing", "root",
				"root");
		PreparedStatement preparedStatement = connection
				.prepareStatement("update student set name='tushar' where name=?");

		for (int i = 0; i < 5; i++) {

			preparedStatement.setString(1, "ram");
			preparedStatement.addBatch();
		}

		preparedStatement.executeBatch();

	}

}
