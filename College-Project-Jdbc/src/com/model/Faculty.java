package com.model;

import java.util.List;

public class Faculty {
	
	private int fid;
	private String fname;
	private Course course;
	public int getFid() {
		return fid;
	}
	public void setFid(int fid) {
		this.fid = fid;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	public List<Batch> getBatchlist() {
		return batchlist;
	}
	public void setBatchlist(List<Batch> batchlist) {
		this.batchlist = batchlist;
	}
	private List<Batch>batchlist;

}
