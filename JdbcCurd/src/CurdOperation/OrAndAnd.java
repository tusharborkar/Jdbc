package CurdOperation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class OrAndAnd {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("class loaded");
		Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/movie","root","root");
		System.out.println("connection created");
		String sql="select * from movie where name = 'badsshaho'  OR actor = 'arjun' ";

		PreparedStatement preparedStatement =connection.prepareStatement(sql);
		System.out.println("executed query");
		ResultSet resultSet=preparedStatement.executeQuery();
		while(resultSet.next()){
			System.out.println(resultSet.getInt("id") + "  "+ resultSet.getString("name")+"  "+resultSet.getString("actor"));
		}
		System.out.println("completed");
		
	}
}
