package com.training.ecommerce.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.training.ecommerce.entities.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

	List<Order> findByOrderDateBetween(LocalDateTime startDate, LocalDateTime endDate);

	List<Order> findByProducts_Name(String productName);
}
