package CurdOperation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Relation {

	public static void main(String[] args) throws ClassNotFoundException,
			SQLException {

		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/emp", "root", "root");
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Name");
		String name=sc.next();
		String sql = "insert into user(name) values(name) ";
		String sql1 = "select MAX(id) AS maxid from user";

		Statement statement = connection.createStatement();
		boolean result = statement.execute(sql);
		if (result == false) {
			System.out.println("done");

			Statement statement2 = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql1);
			while (resultSet.next()) {
				int maxid = resultSet.getInt(1);
				PreparedStatement statement3 = connection
						.prepareStatement("insert into address(id,address) values(?,?)");
				statement3.setInt(1, maxid);
				statement3.setString(2, "nagpur");
				int result1 = statement3.executeUpdate();
				if (result1 >0) {
					System.out.println("sucess");
				}
			}

		}

	}
}
