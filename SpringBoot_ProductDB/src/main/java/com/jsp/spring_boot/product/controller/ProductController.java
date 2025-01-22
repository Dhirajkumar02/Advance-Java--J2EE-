package com.jsp.spring_boot.product.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.jsp.spring_boot.product.entity.Product;
import com.jsp.spring_boot.product.service.ProductService;
import com.jsp.spring_boot.product.utility.ResponseStructure;

@RestController
@RequestMapping("/products")
public class ProductController {
	@Autowired
	private ProductService productService;
	
	@PostMapping()
	public ResponseStructure<Product> addProduct(@RequestBody Product product) {
		product = productService.addProduct(product);
		return ResponseStructure.create(HttpStatus.CREATED.value(), "Product Object Created Successfully!!", product);
		
	}
	
	@GetMapping("/find")
	public ResponseEntity<ResponseStructure<Product>> findProductById(@RequestParam int productId) {
		Product product = productService.findProductById(productId);
		return ResponseEntity.status(HttpStatus.FOUND).body(ResponseStructure.create(HttpStatus.FOUND.value(), "Product Found", product));
		
	}

	@GetMapping()
	public ResponseEntity<ResponseStructure<List<Product>>> findAllProducts() {
		List<Product> products = productService.findAllProducts();
		return ResponseEntity.status(HttpStatus.FOUND).body(ResponseStructure.create(HttpStatus.FOUND.value(), "Products Found", products));
	}
	
	@PutMapping("/update")
	public ResponseStructure<Product> updateProductById(@RequestBody Product product) {
		product = productService.updateProductById(product);
		return ResponseStructure.create(HttpStatus.FOUND.value(), "Product Updated", product);
	}

	@DeleteMapping()
	public ResponseStructure<Product> deleteProductById(int productId) {
		Product product = productService.deleteProductById(productId);
		return ResponseStructure.create(HttpStatus.OK.value(), "Product is Deleted", product);
	}
}
