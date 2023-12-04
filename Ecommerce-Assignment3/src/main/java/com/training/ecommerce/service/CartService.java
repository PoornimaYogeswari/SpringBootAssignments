package com.training.ecommerce.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.training.ecommerce.entities.Cart;
import com.training.ecommerce.entities.Product;
import com.training.ecommerce.repository.CartRepository;

@Service
@Transactional
public class CartService {

	@Autowired
	private CartRepository cartRepository;

	@Autowired
	private ProductService productService;

	public void addProductToCart(Long cartId, Long productId) {
		Optional<Cart> optionalCart = cartRepository.findById(cartId);
		if (optionalCart.isPresent()) {
			Optional<Product> optionalProduct = productService.getProductById(productId);
			optionalProduct.ifPresent(product -> {
				Cart cart = optionalCart.get();
				cart.getProducts().add(product);
				cartRepository.save(cart);
			});
		}
	}

	public void removeProductFromCart(Long cartId, Long productId) {
		Optional<Cart> optionalCart = cartRepository.findById(cartId);
		if (optionalCart.isPresent()) {
			Cart cart = optionalCart.get();
			cart.getProducts().removeIf(product -> product.getId().equals(productId));
			cartRepository.save(cart);
		}
	}

	public void viewCart(Long cartId) {
		Optional<Cart> optionalCart = cartRepository.findById(cartId);
		if (optionalCart.isPresent()) {
			Cart cart = optionalCart.get();
			System.out.println("Products in Cart:");
			for (Product product : cart.getProducts()) {
				System.out.println("Product Details for your cart : " + cartId);
				System.out.println(" ID: " + product.getId() + ", " + "Name: " + product.getName()
						+ ", Price: " + product.getPrice());
			}
		}
	}

	@SuppressWarnings("deprecation")
	public Cart getCartById(Long cartId) {
		// TODO Auto-generated method stub
		return cartRepository.getById(cartId);
	}
}
