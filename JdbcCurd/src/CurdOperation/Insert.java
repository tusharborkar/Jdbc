package CurdOperation;

import java.lang.Thread.State;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.text.html.HTMLDocument.HTMLReader.PreAction;

public class Insert {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		/* 1 */ Class.forName("com.mysql.jdbc.Driver");
		System.out.println("Class loaded");
		/* 2 */ String url = "jdbc:mysql://localhost:3306/jdbccurd";
		String username = "root";
		String password = "root";

		/* 3 */ Connection connection = DriverManager.getConnection(url, username, password);
		System.out.println("connection created");
		/* 4 */ PreparedStatement statement = connection
				.prepareStatement("insert into student(id,name, actor) values(?,?,?)");
		System.out.println("statement executed");
		statement.setInt(1, 1012);
		statement.setString(2, "tushar");
		statement.setString(3, "Akshay kumar");

		/* 5 */
		statement.executeUpdate();
		System.out.println("complete");

	}
}
