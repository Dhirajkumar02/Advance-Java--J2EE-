package com.jsp.spring.injection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Car {
	// Field Injection
	@Autowired
	private Engine engine;

	// Constructor Injection
	@Autowired
	public Car(Engine engine) {
		super();
		this.engine = engine;
	}

	// @Autowired
	public Engine getEngine() {
		return engine;
	}

	// Setter Injection
	// @Autowired
	public void setEngine(Engine engine) {
		this.engine = engine;
	}
	
	

}
