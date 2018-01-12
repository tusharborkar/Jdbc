package CurdOperation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class Create {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("loaded class");
		Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/movie","root","root");
		System.out.println("connection created");
		String sql="CREATE TABLE `emp` ( `id` INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,`name` VARCHAR(45) NOT NULL,PRIMARY KEY (`id`))";
		PreparedStatement statement=connection.prepareStatement(sql);
		System.out.println("executed statement");
	
		statement.executeUpdate();
		System.out.println("complete");
		
	}
}
