package com.jsp.spring_boot.product.serviceimpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jsp.spring_boot.product.entity.Product;
import com.jsp.spring_boot.product.repository.ProductRepository;
import com.jsp.spring_boot.product.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductRepository productRepository;

	@Override
	public Product addProduct(Product product) {
		return productRepository.save(product);
	}

	@Override
	public Product findProductById(int productId) {
		//		System.err.println("Finding actor by Id "+productId);
		//		return productRepository.findById(productId).orElseThrow( () -> new RuntimeException("Failed to find Product"));

		Optional<Product> optional = productRepository.findById(productId);

		if (optional.isPresent()) {
			Product product = optional.get();
			return product;
		} else {
			throw new RuntimeException("Failed to find User");
		}
	}

}
