package com.model;

public class StudentInfo {

	private int studentnfoId;
	private String Address;
	public int getStudentnfoId() {
		return studentnfoId;
	}
	public void setStudentnfoId(int studentnfoId) {
		this.studentnfoId = studentnfoId;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	private Student student;

}
