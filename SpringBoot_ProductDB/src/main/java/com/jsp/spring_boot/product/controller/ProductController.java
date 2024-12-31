package com.jsp.spring_boot.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.spring_boot.product.entity.Product;
import com.jsp.spring_boot.product.service.ProductService;

@RestController
public class ProductController {
	@Autowired
	private ProductService productService;
	
	//@PostMapping("/products")
	@RequestMapping(value = "/products" , method = RequestMethod.POST)
	public Product addProduct(@RequestBody Product product) {
		return productService.addProduct(product);
		
	}
	
	@GetMapping("/find-product")
	public Product findProductById(@RequestParam int productId) {
		return productService.findProductById(productId);
		
	}

}
