package com.jsp.spring_boot.product.service;

import com.jsp.spring_boot.product.entity.Product;

public interface ProductService {
	 public Product addProduct(Product product);
	 
	 public Product findProductById(int productId);

}
