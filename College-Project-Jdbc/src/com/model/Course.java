package com.model;

import java.util.List;

public class Course {
	
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public List<Faculty> getFacultylist() {
		return facultylist;
	}
	public void setFacultylist(List<Faculty> facultylist) {
		this.facultylist = facultylist;
	}
	private int cid;
	private String cname;
	private List<Faculty>facultylist;

}
