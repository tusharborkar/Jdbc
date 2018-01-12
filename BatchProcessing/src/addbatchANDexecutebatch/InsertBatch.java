package addbatchANDexecutebatch;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertBatch {

	public void insert() throws ClassNotFoundException, SQLException {

		PreparedStatement preparedStatement = getConnection()
				.prepareStatement("insert into student(name, mobile) values(?,?)");
		preparedStatement.setString(1, "ram");
		preparedStatement.setString(2, "78946513");

		for (int i = 0; i < 10; i++) {

			preparedStatement.addBatch();
		}
		preparedStatement.executeBatch();
	}

	public void delete() throws ClassNotFoundException, SQLException {
		Statement statement = getConnection().createStatement();
		String sql = "delete from student where idstudent> 10";
		statement.executeUpdate(sql);

	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		InsertBatch insertBatch = new InsertBatch();
		System.out.println("inserting......");
		insertBatch.insert();
		/*
		 * System.out.println("deleting....."); test.delete();
		 */
	}

	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/batchprocessing", "root",
				"root");

		return connection;
	}

}
