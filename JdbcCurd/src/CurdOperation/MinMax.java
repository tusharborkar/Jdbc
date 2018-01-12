package CurdOperation;

import java.lang.Thread.State;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MinMax {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("loaded driver");
		Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/movie","root","root");
		System.out.println("created connection");
		PreparedStatement  preparedStatement = connection.prepareStatement("select MIN(id) AS samllestid from movie");
		PreparedStatement  preparedStatement1 = connection.prepareStatement("select MAX(id) AS Largestid from movie");
		System.out.println("executed statement");
		ResultSet resultSet=preparedStatement.executeQuery();
		ResultSet resultSet1=preparedStatement1.executeQuery();
		while(resultSet.next()){
			System.out.println(resultSet.getInt(1));
		}
		while(resultSet1.next()){
			System.out.println(resultSet1.getInt(1));
		}
		System.out.println("completed");
	}
}
