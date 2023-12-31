package com.training.ecommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.training.ecommerce.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
	List<Product> findByName(String name);

	List<Product> findByPriceLessThan(Double price);

	List<Product> findByStockGreaterThan(Integer stock);
}