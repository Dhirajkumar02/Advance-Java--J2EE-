package com.jsp.spring_boot.product.exception;

public class ProductsNotFoundException extends RuntimeException {
	private final String message;

	public ProductsNotFoundException(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

}
