package com.jsp.spring_boot.product.serviceimpl;

import java.util.List;
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
			throw new RuntimeException("Failed to find Product");
		}
	}

	@Override
	public List<Product> findAllProducts() {
		List<Product> products = productRepository.findAll();

		if (products.isEmpty()) {
			return null;
		} else {
			return products;
		}
	}

	@Override
	public Product updateProductById(Product product) {
		Optional<Product> optional = productRepository.findById(product.getProductId());
		if(optional.isPresent()) {
			Product existingProduct = optional.get();
			existingProduct.setName(product.getName());
			existingProduct.setBrand(product.getBrand());
			existingProduct.setPrice(product.getPrice());
			
			return productRepository.save(existingProduct);
		}else {
			throw new RuntimeException("Failed to update Product");
		}
	}

	@Override
	public Product deleteProductById(int productId) {
		Optional<Product> optional = productRepository.findById(productId);
		if(optional.isPresent()) {
			Product product = optional.get();
			productRepository.delete(product);
			
			return product;
		}else {
			throw new RuntimeException("Product not found with ID: " + productId);
		}
	}

}
