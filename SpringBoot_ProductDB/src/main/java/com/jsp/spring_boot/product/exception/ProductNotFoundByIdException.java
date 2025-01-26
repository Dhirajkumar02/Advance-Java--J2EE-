package com.jsp.spring_boot.product.exception;

public class ProductNotFoundByIdException extends RuntimeException {
	private final String message;

	public ProductNotFoundByIdException(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
	
	

}
