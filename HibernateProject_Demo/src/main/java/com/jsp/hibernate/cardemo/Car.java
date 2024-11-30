package com.jsp.hibernate.cardemo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Car {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int carId;
	@Column
	private String carName;
	@Column
	private String carBrand;
	@Column
	private int carPrice;
	 
	
	public int getCarId() {
		return carId;
	}
	public void setCarId(int carId) {
		this.carId = carId;
	}
	public String getCarName() {
		return carName;
	}
	public void setCarName(String carName) {
		this.carName = carName;
	}
	public String getCarBrand() {
		return carBrand;
	}
	public void setCarBrand(String carBrand) {
		this.carBrand = carBrand;
	}
	public int getCarPrice() {
		return carPrice;
	}
	public void setCarPrice(int carPrice) {
		this.carPrice = carPrice;
	}
	@Override
	public String toString() {
		return "Car [carId=" + carId + ", carName=" + carName + ", carBrand=" + carBrand + ", carPrice=" + carPrice
				+ ", getCarId()=" + getCarId() + ", getCarName()=" + getCarName() + ", getCarBrand()=" + getCarBrand()
				+ ", getCarPrice()=" + getCarPrice() + "]";
	}
	
	
	

}
