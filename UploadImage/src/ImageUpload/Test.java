package ImageUpload;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class Test {

	public static void main(String[] args) throws ClassNotFoundException, SQLException, FileNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/image", "root", "root");
		Statement statement = connection.createStatement();
		File imgfile = new File("D:\\car.jpg");
		FileInputStream fileInputStream = new FileInputStream(imgfile);
		PreparedStatement preparedStatement = connection.prepareStatement("insert into image values(?,?,?)");
		preparedStatement.setString(1, "test");
		preparedStatement.setInt(2, 3);
		preparedStatement.setBinaryStream(3, (InputStream) fileInputStream, (int) imgfile.length());
		preparedStatement.executeUpdate();
		System.out.println("sucessfully inserted into database");
		connection.close();

	}
}
