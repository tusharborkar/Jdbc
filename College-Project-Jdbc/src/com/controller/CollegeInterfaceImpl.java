
package com.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Comparator;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.model.Batch;
import com.model.Course;
import com.model.Faculty;
import com.model.Student;

public class CollegeInterfaceImpl implements CollegeInterface {
	Scanner scanner = new Scanner(System.in);
	ArrayList clist = new ArrayList();
	// flist = new ArrayList();
	// ArrayList blist = new ArrayList();
	// ArrayList slist = new ArrayList();
	/*
	 * Course course = new Course(); Faculty faculty = new Faculty(); Batch batch =
	 * new Batch(); Student student = new Student();
	 */

	public static Connection getJdbcConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/collegeproject", "root",
				"root");
		return connection;

	}

	@Override
	public void addcourse() {

		System.out.println("how many course you want to add");
		int courseSelection = scanner.nextInt();
		for (int i = 0; i < courseSelection; i++) {
			System.out.println("enter course Name");
			Course course = new Course();
			String coursename = scanner.next();
			course.setCname(coursename);
			clist.add(course);

			try {
				boolean result = getJdbcConnection()
						.prepareStatement("insert into course(cname) values( '" + course.getCname() + "')").execute();
				if (result == false) {
					System.out.println("success");
				} else {
					System.out.println("error");
				}
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void addfaculty() throws ClassNotFoundException, SQLException {

		List<Faculty> flist = new ArrayList<Faculty>();
		Scanner scanner = new Scanner(System.in);

		System.out.println("How many faculty you want to add");
		int facultySelection = scanner.nextInt();

		for (int i = 1; i <= facultySelection; i++) {
			Faculty faculty = new Faculty();
			System.out.println("Enter Faculty Name");
			faculty.setFname(scanner.next());

			flist.add(faculty);

		}

		PreparedStatement ps = getJdbcConnection().prepareStatement("select * from course");

		ResultSet rs = ps.executeQuery();
		List<Course> courseList = new ArrayList<Course>();
		while (rs.next()) {
			Course course = new Course();
			course.setCid(rs.getInt(1));
			course.setCname(rs.getString(2));
			courseList.add(course);

		}

		for (Course clist : courseList) {
			System.out.println(clist.getCid() + "   " + clist.getCname());
		}

		for (Faculty f : flist) {

			System.out.println("Which Course you want to allocate Enter ID");
			int allocateCourse = scanner.nextInt();
			for (Course course : courseList) {
				if (course.getCid() == allocateCourse) {
					boolean result1 = getJdbcConnection().prepareStatement(
							"insert into faculty (fname,cid) values('" + f.getFname() + "'," + course.getCid() + ")")
							.execute();

				}

			}
			System.out.println("Success");
		}
	}

	@Override
	public void addbatch() throws ClassNotFoundException, SQLException {
		List<Batch> blist = new ArrayList<Batch>();
		Scanner scanner = new Scanner(System.in);

		System.out.println("How many Batch you want to add");
		int batchSelection = scanner.nextInt();

		for (int i = 1; i <= batchSelection; i++) {
			Batch batch = new Batch();
			System.out.println("Enter Batch Name");
			batch.setBname(scanner.next());

			blist.add(batch);

		}

		PreparedStatement ps = getJdbcConnection().prepareStatement("select * from faculty");

		ResultSet rs = ps.executeQuery();
		List<Faculty> facultyList = new ArrayList<Faculty>();
		while (rs.next()) {
			Faculty faculty = new Faculty();
			faculty.setFid(rs.getInt(1));
			faculty.setFname(rs.getString(2));

			facultyList.add(faculty);

		}
		for (Faculty faculty : facultyList) {
			System.out.println(faculty.getFid() + "  " + faculty.getFname());
		}

		for (Batch b : blist) {

			System.out.println("Which faculty you want to allocate Enter ID");
			int allocateFaculty = scanner.nextInt();
			for (Faculty faculty : facultyList) {

				if (faculty.getFid() == allocateFaculty) {
					boolean result1 = getJdbcConnection().prepareStatement(
							"insert into batch (bname,fid) values('" + b.getBname() + "'," + faculty.getFid() + ")")
							.execute();

				}

			}
			System.out.println("Success");
		}
	}

	@Override
	public void addstudent() throws ClassNotFoundException, SQLException {
		List<Student> slist = new ArrayList<Student>();
		Scanner scanner = new Scanner(System.in);

		System.out.println("How many Student you want to add");
		int studentSelection = scanner.nextInt();

		for (int i = 1; i <= studentSelection; i++) {
			Student student = new Student();
			System.out.println("Enter Student Name");

			student.setSname(scanner.next());
			slist.add(student);

		}

		PreparedStatement ps = getJdbcConnection().prepareStatement("select * from batch");

		ResultSet rs = ps.executeQuery();
		List<Batch> batchList = new ArrayList<Batch>();
		while (rs.next()) {
			Batch batch = new Batch();
			batch.setBid(rs.getInt(1));
			batch.setBname(rs.getString(2));
			batchList.add(batch);

		}

		for (Batch batch : batchList) {
			System.out.println(batch.getBid() + "  " + batch.getBname());
		}

		for (Student s : slist) {

			System.out.println("Which batch you want to allocate Enter ID");
			int allocatebatch = scanner.nextInt();
			for (Batch batch : batchList) {

				if (batch.getBid() == allocatebatch) {
					boolean result1 = getJdbcConnection().prepareStatement(
							"insert into student (sname,bid) values('" + s.getSname() + "'," + batch.getBid() + ")")
							.execute();

				}

			}
			System.out.println("Success");
		}
	}

	@Override
	public void displayCourse() throws ClassNotFoundException, SQLException {
		ResultSet resultSet = getJdbcConnection().prepareStatement("select  * from course").executeQuery();
		while (resultSet.next()) {
			int id = resultSet.getInt(1);
			String CourseName = resultSet.getString(2);
			System.out.println(id + "  " + CourseName);

			/*
			 * List<Course> DisplayCourseList = new ArrayList<>(); Course course = new
			 * Course(); course.setCid(resultSet.getInt(1));
			 * course.setCname(resultSet.getString(2)); DisplayCourseList.add(course);
			 * System.out.println(course.getCid() + "  " + course.getCname());
			 */
		}
	}

	@Override
	public void displayFaculty() throws ClassNotFoundException, SQLException {

		ResultSet resultSet = getJdbcConnection()
				.prepareStatement("select f.* , c.*   from faculty f , course c where c.cid = f.cid").executeQuery();
		while (resultSet.next()) {
			int id = resultSet.getInt(1);
			String facultyName = resultSet.getString(2);
			System.out.println(id + "  " + facultyName + "  " + resultSet.getString("cname")    +"  "+resultSet.getInt("cid"));
			System.out.println();
			/*
			 * List<Faculty> DisplayFaculty = new ArrayList<>(); Faculty faculty = new
			 * Faculty(); faculty.setFid(resultSet.getInt(1));
			 * faculty.setFname(resultSet.getString(2)); Course course = new Course();
			 * course.setCid(resultSet.getInt(3));
			 * 
			 * faculty.setCourse(course); System.out.println(faculty.getFid() + "  " +
			 * faculty.getFname() + "  " + faculty.getCourse().getCid());
			 */
		}
	}

	@Override
	public void displayBatch() throws ClassNotFoundException, SQLException {
		System.out.println("I am not able to handle this problem");
		ResultSet resultSet = getJdbcConnection()
				.prepareStatement("select b.* , f.*   from  batch b , faculty f  where b.bid=f.fid").executeQuery();
		while (resultSet.next()) {
			Batch batch = new Batch();
			batch.setBid(resultSet.getInt(1));
			batch.setBname(resultSet.getString(2));
			/*
			 * int id = resultSet.getInt(1); String batchName = resultSet.getString(2);
			 */ System.out.println(batch.getBid() + "  " + batch.getBname() + "  " + resultSet.getString("fname"));
			System.out.println();

		}
	}

	@Override
	public void displayStudent() throws ClassNotFoundException, SQLException {
		ResultSet resultSet = getJdbcConnection()
				.prepareStatement("select s.* , b.*   from student s , batch b  where s.sid=b.bid").executeQuery();
		while (resultSet.next()) {

			int sid = resultSet.getInt(1);
			String studentName = resultSet.getString(2);
			System.out.println(sid + "  " + studentName + "  " + resultSet.getString("bname"));
			System.out.println();

		}

	}

}
