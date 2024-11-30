package com.jsp.hibernate.demo.car;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Car {
	@Id
	private int carId;
	private String carName;
	private String carBrand;
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
