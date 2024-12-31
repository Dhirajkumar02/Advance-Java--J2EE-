package com.jsp.spring_boot.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.spring_boot.product.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
	// save()
	// update()
	// findById()
	// findAll()
	// deleteById()
}
