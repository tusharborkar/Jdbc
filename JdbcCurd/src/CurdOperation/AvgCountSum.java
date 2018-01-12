package CurdOperation;

import java.lang.Thread.State;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AvgCountSum {

	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/emp","root","root");
     	PreparedStatement preparedStatement= connection.prepareStatement("select AVG(id) from user");
	   ResultSet resultSet=preparedStatement.executeQuery();
	   while(resultSet.next()){
		   System.out.println(resultSet.getInt(1));
	   }
	   
	Statement statement= connection.createStatement();
	String sql1="select count(id) from user";
		 ResultSet resultSet2= statement.executeQuery(sql1);
		   while(resultSet2.next()){
			   System.out.println(resultSet2.getInt(1));
		   }
	
			Statement statement1= connection.createStatement();
			String sql2="select SUM(id) from user";
				 ResultSet resultSet3= statement.executeQuery(sql2);
				   while(resultSet3.next()){
					   System.out.println(resultSet3.getInt(1));
				   }
				
	
		
		
		
		
		
		
	}
}
