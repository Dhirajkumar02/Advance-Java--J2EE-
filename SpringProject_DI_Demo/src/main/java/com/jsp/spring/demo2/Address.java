package com.jsp.spring.demo2;

public class Address {
	private String location;
	private String city;
	public Address() {

	}
	public Address(String location, String city) {
		super();
		this.location = location;
		this.city = city;
	}
	public String getLocation() {
		return location;
	}
	public String getCity() {
		return city;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public void setCity(String city) {
		this.city = city;
	}
	@Override
	public String toString() {
		return "Address [location=" + location + ", city=" + city + "]";
	}

}
