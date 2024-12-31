package com.jsp.spring.demo2;

public class Student {
	
	private int studentId;
	private String studentName;
	private int studentAge;
	
	private Address address;

	public Student() {
		System.out.println("Default Contructor used");
	}

	public Student(int studentId, String studentName, int studentAge, Address address) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.studentAge = studentAge;
		this.address = address;
	}

	public int getStudentId() {
		return studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public int getStudentAge() {
		return studentAge;
	}

	public Address getAddress() {
		return address;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public void setStudentAge(int studentAge) {
		this.studentAge = studentAge;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", studentName=" + studentName + ", studentAge=" + studentAge
				+ ", address=" + address + "]";
	}
	
	
	
	

}
