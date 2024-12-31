package com.jsp.hibernate.employeedb.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Employee {
	@Id
	@Column(name = "Id" )
	private int id;
	
	@Column(name = "Name")
	private String name;
	
	@Column(name = "Email")
	private String email;
	
	@Column(name = "Age" )
	private int age;
	
	@Column(name = "Designation")
	private String desc;
	
	@Column(name = "Salary")
	private double sal;

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public double getSal() {
		return sal;
	}

	public void setSal(double sal) {
		this.sal = sal;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", email=" + email + ", age=" + age + ", desc=" + desc
				+ ", sal=" + sal + ", getId()=" + getId() + ", getName()=" + getName() + ", getEmail()=" + getEmail()
				+ ", getAge()=" + getAge() + ", getDesc()=" + getDesc() + ", getSal()=" + getSal() + "]";
	}
	
	

}
