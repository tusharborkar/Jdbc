package JdbcDemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Delete {

	public static void main(String[] args) {
		
		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","root");
			Statement statement = connection.createStatement();
			statement.executeUpdate("delete from student where name='tushar' ");
			System.out.println("delete");
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
