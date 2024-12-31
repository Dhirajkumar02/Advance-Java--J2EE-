package com.jsp.spring_boot.product.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int productId;
	private String name;
	private String brand;
	private int price;
	
	
	public int getProductId() {
		return productId;
	}
	public String getName() {
		return name;
	}
	public String getBrand() {
		return brand;
	}
	public int getPrice() {
		return price;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	

}
