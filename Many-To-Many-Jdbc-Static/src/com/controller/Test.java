package com.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.model.Certificate;
import com.model.Student;

public class Test {

	public void insert() throws ClassNotFoundException, SQLException {
		List<Student> slist = new ArrayList<>();
		List<Student> oneslist = new ArrayList<>();
		Student student1 = new Student();
		student1.setStudentName("Ram");
		Student student2 = new Student();
		student2.setStudentName("Sham");
		slist.add(student1);
		slist.add(student2);

		List<Certificate> clist = new ArrayList<>();
		List<Certificate> twoclist = new ArrayList<>();
		Certificate certificate1 = new Certificate();
		certificate1.setCertificateName("Linux");
		Certificate certificate2 = new Certificate();
		certificate2.setCertificateName("RedHat");
		Certificate certificate3 = new Certificate();
		certificate3.setCertificateName("Hadoop");
		clist.add(certificate1);
		clist.add(certificate2);
		clist.add(certificate3);
		twoclist.add(certificate1);
		twoclist.add(certificate2);

		student1.setCertificatelist(clist);
		student2.setCertificatelist(twoclist);
		oneslist.add(student2);
		certificate1.setStudentlist(slist);
		certificate2.setStudentlist(slist);
		certificate3.setStudentlist(oneslist);

		for (Student student : slist) {

			PreparedStatement preparedStatement = getJdbcConnection()
					.prepareStatement("insert into student(studentName) values(?)");
			preparedStatement.setString(1, student.getStudentName());
			preparedStatement.execute();
			System.out.println(" student inserted....");
			ResultSet resultSet = getJdbcConnection().prepareStatement("select max(studentId) from student")
					.executeQuery();
			while (resultSet.next()) {
				int maxid = resultSet.getInt(1);
				student.setStudentId(maxid);
			}

			for (Certificate certificate : clist) {

				PreparedStatement preparedStatement1 = getJdbcConnection()
						.prepareStatement("insert into certificate(certificateName)  values(?)");
				preparedStatement1.setString(1, certificate.getCertificateName());
				boolean result = preparedStatement1.execute();
				if (result == false) {
					ResultSet resultSet1 = getJdbcConnection()
							.prepareStatement("select max(certificateId) from certificate").executeQuery();
					if (resultSet1.next()) {

						certificate.setCertificateId(resultSet1.getInt(1));
					}
				} else {
					System.out.println("error");
				}
			}
		}
		for (Student student4 : slist) {

			List<Certificate> mainclist = student4.getCertificatelist();
			for (Certificate certificate4 : mainclist) {
				System.out.println("inseting student and certificate");
				PreparedStatement preparedStatement11 = getJdbcConnection()
						.prepareStatement("insert into studcert(studentId, certificateId) values(?,?)");
				preparedStatement11.setInt(1, student4.getStudentId());
				preparedStatement11.setInt(2, certificate4.getCertificateId());
				preparedStatement11.execute();
				System.out.println("3rd table inserted");
			}
		}

	}

	public void display() throws ClassNotFoundException, SQLException {
		List<Student> slist = new ArrayList<Student>();

		ResultSet resultSet = getJdbcConnection().prepareStatement("select * from student").executeQuery();

		while (resultSet.next()) {
			Student s = new Student();
			s.setStudentId(resultSet.getInt(1));
			s.setStudentName(resultSet.getString(2));

			slist.add(s);

		}

		List<Student> mainslist = new ArrayList();

		for (Student s : slist) {
			ResultSet resultSet2 = getJdbcConnection().prepareStatement(
					"select  c.certificateId, c.certificatename from student s, certificate c , studcert sc  where  s.studentid = sc.studentid and c.certificateId=sc.certificateId and sc.studentid='"
							+ s.getStudentId() + "'  ")
					.executeQuery();
			List<Certificate> clist = new ArrayList();

			while (resultSet2.next()) {
				Certificate c = new Certificate();
				c.setCertificateId(resultSet2.getInt(1));
				c.setCertificateName(resultSet2.getString(2));

				clist.add(c);

			}

			s.setCertificatelist(clist);
			mainslist.add(s);
		}
		for (Student student : mainslist) {
			System.out.println(student.getStudentId() + " " + student.getStudentName());

			List<Certificate> clist1 = student.getCertificatelist();

			for (Certificate certificate : clist1) {
				System.out.println(
						"             " + certificate.getCertificateId() + " " + certificate.getCertificateName());
			}

		}
	}

	public void delete() throws ClassNotFoundException, SQLException {
		System.out.println("which student you want to delete");
		Scanner scanner = new Scanner(System.in);
		int selection = scanner.nextInt();

		boolean result = getJdbcConnection()
				.prepareStatement("delete from student where studentid='" + selection + "' ").execute();
		if (result == false) {
			System.out.println("deleted.....");
		} else {
			System.out.println("error");
		}

	}

	public void update() throws ClassNotFoundException, SQLException {
		display();
		Scanner scanner = new Scanner(System.in);

		System.out.println("what do you want to update");

		int selectforupdate = scanner.nextInt();
		PreparedStatement preparedStatement = getJdbcConnection()
				.prepareStatement("update student set studentname=? where studentid='" + selectforupdate + "'");

		System.out.println("enter name that u want to update for selected id");
		String updatedname = scanner.next();
		preparedStatement.setString(1, updatedname);
		boolean result = preparedStatement.execute();
		if (result == false) {
			System.out.println("updated...");
		} else {
			System.out.println("error");
		}
	}

	public static Connection getJdbcConnection() throws ClassNotFoundException, SQLException {

		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/manytomany", "root", "root");
		return connection;
	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Test test = new Test();
		test.insert();
		test.display();
		test.delete();
		test.update();

	}
}
