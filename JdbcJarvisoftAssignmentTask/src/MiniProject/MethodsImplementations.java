package MiniProject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class MethodsImplementations implements Methods {
	Scanner scanner = new Scanner(System.in);

	public static Connection jdbcConnection() throws ClassNotFoundException, SQLException {

		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcminiproject", "root",
				"root");
		return connection;
	}

	@Override
	public void insert() {

		try {
			Statement statement = jdbcConnection().createStatement();
			System.out.println("how many student u want to store in database");
			int insertStudent = scanner.nextInt();
			for (int i = 0; i < insertStudent; i++) {
				Student student = new Student();

				System.out.println("enter the id");
				int id = scanner.nextInt();
				student.setId(id);

				System.out.println("enter the name");
				String name = scanner.next();
				student.setName(name);

				System.out.println("enter the mobile");
				String mobile = scanner.next();
				student.setMobile(mobile);
				String sql = "insert into student values('" + student.getId() + "'           ,        '"
						+ student.getName() + "'        ,              '" + student.getMobile() + "'        )";
				statement.executeUpdate(sql);
				System.out.println("inserted");
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void modify() {

		 viewAll();
		   
		   try { String sql = " update student set name=?,mobile=? where id=?";
		   PreparedStatement preparedStatement = jdbcConnection().prepareStatement(sql);
		   System.out.println("enter how many id you want to update"); int updateId =
		   scanner.nextInt(); for (int i = 0; i < updateId; i++) {
		   
		   System.out.println("enter id that you want to update"); int id =
		   scanner.nextInt(); preparedStatement.setInt(3, id);
		   System.out.println("enter new name for that ID"); String name =
		   scanner.next(); preparedStatement.setString(1, name);
		   
		   System.out.println("enter mobile number that u want to update"); String
		   mobile = scanner.next(); preparedStatement.setString(2, mobile);
		   preparedStatement.executeUpdate(); System.out.println("updated,....."); }
		   
		   } catch (ClassNotFoundException e) { e.printStackTrace(); } catch
		   (SQLException e) { e.printStackTrace(); }
		 
	}

	@Override
	public void delete() {

		try {
			String sql = "delete from student where id=?";
			PreparedStatement preparedStatement = jdbcConnection().prepareStatement(sql);
			System.out.println("how many entry you want to delete");
			int deletedentry = scanner.nextInt();
			for (int i = 0; i < deletedentry; i++) {
				System.out.println("enter id u want to delete");
				int id = scanner.nextInt();
				preparedStatement.setInt(1, id);
				preparedStatement.addBatch();

			}

			preparedStatement.executeBatch();
			System.out.println("deleted....");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void search() {

		try {
			String sql = "select * from student where id=?";
			PreparedStatement preparedStatement = jdbcConnection().prepareStatement(sql);
			System.out.println("enter id you want search");
			int id = scanner.nextInt();
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				System.out.println(resultSet.getInt(1));
				System.out.println(resultSet.getString(2));
				System.out.println(resultSet.getString(3));
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void viewAll() {
		String sql = "select * from student";
		try {
			PreparedStatement preparedStatement = jdbcConnection().prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				System.out.println(resultSet.getInt(1));
				System.out.println(resultSet.getString(2));
				System.out.println(resultSet.getString(3));
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void exit() {
		System.exit(0);

	}

}
