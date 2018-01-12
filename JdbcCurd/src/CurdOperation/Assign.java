package CurdOperation;

import java.lang.Thread.State;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Assign {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/emp","root","root");
		PreparedStatement preparedStatement =connection.prepareStatement("insert into user(id,name) values(5,'abhi')");
		preparedStatement.executeUpdate();
	
		String sql1="select MAX(id) AS maxID from user";
		
		Statement statement= connection.createStatement();
		ResultSet resultSet=statement.executeQuery(sql1);
		while(resultSet.next()){
			int maxId=resultSet.getInt(1);
		
			PreparedStatement preparedStatement1 =connection.prepareStatement("insert into address(id,address) values(?,?)");
			preparedStatement1.setInt(1, maxId);
			preparedStatement1.setString(2, "shivane");
			preparedStatement1.executeUpdate();
			
			
			
		}
		
		
		
		
	}
}
