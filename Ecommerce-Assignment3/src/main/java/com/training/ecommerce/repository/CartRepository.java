package com.training.ecommerce.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.training.ecommerce.entities.Cart;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {

	Optional<Cart> findByIdAndFetchProducts(Long id);

	Optional<Cart> findByProducts_Id(Long productId);
}
