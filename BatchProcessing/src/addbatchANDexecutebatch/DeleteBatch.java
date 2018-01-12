package addbatchANDexecutebatch;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class DeleteBatch {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Scanner scanner = new Scanner(System.in);
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/batchprocessing", "root",
				"root");

		PreparedStatement preparedStatement = connection.prepareStatement("delete from student where idstudent=?");
		for (int i = 0; i < 5; i++) {
			// preparedStatement.setString(1, "ram");
			System.out.println("Enter id u want to delete");
			int id = scanner.nextInt();
			preparedStatement.setInt(1, id);
			System.out.println(i);
			preparedStatement.addBatch();
		}
		// preparedStatement.addBatch();
		preparedStatement.executeBatch();

	}
}
