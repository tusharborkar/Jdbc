package CurdOperation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Example1 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		Class.forName("com.mysql.jdbc.Driver");

		Connection connection =DriverManager.getConnection("jdbc:mysql://localhost:3306/movie", "root", "root");
		
	PreparedStatement  preparedStatement=connection.prepareStatement("select * from movie");

	ResultSet resultSet=preparedStatement.executeQuery();
	
	while (resultSet.next()) {
System.out.println(		resultSet.getInt(1)+"  "+resultSet.getString("name") +"  "+resultSet.getString("actor"));
	}
	}

}
