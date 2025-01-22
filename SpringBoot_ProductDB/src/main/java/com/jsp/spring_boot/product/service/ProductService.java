package com.jsp.spring_boot.product.service;

import java.util.List;

import com.jsp.spring_boot.product.entity.Product;

public interface ProductService {
	
	 public Product addProduct(Product product);
	 
	 public Product findProductById(int productId);
	 
	 public List<Product> findAllProducts();
	 
	 Product updateProductById(Product product);
	 
	 public Product deleteProductById(int productId);

	
}
