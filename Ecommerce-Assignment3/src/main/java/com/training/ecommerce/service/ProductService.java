package com.training.ecommerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.training.ecommerce.entities.Product;
import com.training.ecommerce.repository.ProductRepository;

@Service
@Transactional
public class ProductService {

	@Autowired
	private ProductRepository productRepository;

	public List<Product> listAllProducts() {
		return productRepository.findAll();
	}

	public Optional<Product> getProductById(Long productId) {
		return productRepository.findById(productId);
	}

	public Product saveProduct(Product product) {
		return productRepository.save(product);
	}

	public void deleteProduct(Long productId) {
		productRepository.deleteById(productId);
	}

}
