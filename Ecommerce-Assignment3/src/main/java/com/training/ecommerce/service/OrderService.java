package com.training.ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.training.ecommerce.entities.Cart;
import com.training.ecommerce.entities.Order;
import com.training.ecommerce.repository.OrderRepository;

@Service
@Transactional
public class OrderService {

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private CartService cartService;

	public void placeOrder(Long cartId) {
		Cart cart = cartService.getCartById(cartId);
		if (cart != null && !cart.getProducts().isEmpty()) {
			Order order = new Order();
			order.setProducts(cart.getProducts());
			orderRepository.save(order);
		}
	}

	public List<Order> showOrderHistory() {
		return orderRepository.findAll();
	}

}
