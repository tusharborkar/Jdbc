package com.model;

import java.util.List;

public class Student {

	private int studentId;
	private String studentName;
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public List<Certificate> getCertificatelist() {
		return certificatelist;
	}
	public void setCertificatelist(List<Certificate> certificatelist) {
		this.certificatelist = certificatelist;
	}
	private List<Certificate> certificatelist;

}
