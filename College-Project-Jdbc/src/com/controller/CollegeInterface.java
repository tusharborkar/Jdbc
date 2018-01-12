package com.controller;

import java.sql.SQLException;

public interface CollegeInterface {

	void 
	addcourse();

	void addfaculty() throws ClassNotFoundException, SQLException;

	void addbatch() throws ClassNotFoundException, SQLException;

	void addstudent() throws ClassNotFoundException, SQLException;

	void displayCourse() throws ClassNotFoundException, SQLException;

	
	void displayFaculty() throws ClassNotFoundException, SQLException;

	
	void displayBatch() throws ClassNotFoundException, SQLException;

	
	void displayStudent() throws ClassNotFoundException, SQLException;
	

}
