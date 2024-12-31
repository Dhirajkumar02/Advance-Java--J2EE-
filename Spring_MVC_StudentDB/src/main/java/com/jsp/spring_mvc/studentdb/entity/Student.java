package com.jsp.spring_mvc.studentdb.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Student {
	@Id
	private int studentId;
	private String studentName;
	private String studentEmail;
	private int studentAge;
	private String studentCourse;
	
	
	public int getStudentId() {
		return studentId;
	}
	public String getStudentName() {
		return studentName;
	}
	public String getStudentEmail() {
		return studentEmail;
	}
	public int getStudentAge() {
		return studentAge;
	}
	public String getStudentCourse() {
		return studentCourse;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public void setStudentEmail(String studentEmail) {
		this.studentEmail = studentEmail;
	}
	public void setStudentAge(int studentAge) {
		this.studentAge = studentAge;
	}
	public void setStudentCourse(String studentCourse) {
		this.studentCourse = studentCourse;
	}
	
	

}
