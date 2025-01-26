package com.jsp.spring_boot.product.utility;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.jsp.spring_boot.product.exception.ProductNotFoundByIdException;
import com.jsp.spring_boot.product.exception.ProductsNotFoundException;

@RestControllerAdvice
public class ApplicationExceptionHandler {

	@ExceptionHandler
	public ErrorStructure handleActorNotFoundById(ProductNotFoundByIdException ex) {
		return ErrorStructure.create(HttpStatus.NOT_FOUND.value(), ex.getMessage(), "Product with the requested Id is not available in the Database!!");
	}

	@ExceptionHandler
	public ErrorStructure handleActorNotFound(ProductsNotFoundException ex) {
		return ErrorStructure.create(HttpStatus.NOT_FOUND.value(), ex.getMessage(), "Products is not Present in the Database!!");
	}

}
