package JdbcDemo;

import java.net.ConnectException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Retrive{

	public static void main(String[] args) {

		try {

			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/student", "root", "root");
			Statement smt = con.createStatement();
			ResultSet rs = smt.executeQuery("select * from student");
			
			
			while (rs.next()) {
				System.out.println(rs.getInt("id") + " "
						+ rs.getString("name"));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
