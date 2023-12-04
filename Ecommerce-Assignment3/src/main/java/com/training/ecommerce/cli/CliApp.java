package com.training.ecommerce.cli;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.training.ecommerce.entities.Product;
import com.training.ecommerce.service.CartService;
import com.training.ecommerce.service.OrderService;
import com.training.ecommerce.service.ProductService;

@Component
public class CliApp {

	@Autowired
	private ProductService productService;

	@Autowired
	private CartService cartService;

	@Autowired
	private OrderService orderService;

	Scanner scanner = new Scanner(System.in);
	public void run() {
		
		int choice;

		do {
			System.out.println("Choose an option:");
			System.out.println("1. List all products");
			System.out.println("2. Add a product to the cart");
			System.out.println("3. View cart");
			System.out.println("4. Place an order");
			System.out.println("5. View order history");
			System.out.println("6. Exit");

			choice = scanner.nextInt();

			switch (choice) {
			case 1:
				listAllProducts();
				break;
			case 2:
				addProductToCart();
				break;
			case 3:
				viewCart();
				break;
			case 4:
				placeOrder();
				break;
			case 5:
				viewOrderHistory();
				break;
			case 6:
				System.out.println("Exiting.. Thanks for visting ecommerce application!");
				break;
			default:
				System.out.println("Please choose a valid option from 1 to 6");
			}

		} while (choice != 6);
		
	}

	private void listAllProducts() {
		List<Product> products = productService.listAllProducts();
		System.out.println("List of all products:");
		for (Product product : products) {
			System.out.println("<<<<<<<<Product Details>>>>>>>>");
			System.out.println(
					"ID: " + product.getId() + ", Name: " + product.getName() + ", Price: " + product.getPrice());
		}
	}

	private void addProductToCart() {
		System.out.println("Kindly provide your cart id");
		Long cartId = scanner.nextLong();
		
		System.out.println("Kindly provide the product id to be added to your cart");
		Long productId = scanner.nextLong();
		
		System.out.println("Adding product to cart : ");
		cartService.addProductToCart(cartId, productId);
	}

	private void viewCart() {
		System.out.println("Kindly provide your cart id");
		Long cartId = scanner.nextLong();
		cartService.viewCart(cartId);
	}

	private void placeOrder() {
		System.out.println("Placing order : ");
		System.out.println(productService.listAllProducts());
	}

	private void viewOrderHistory() {
		System.out.println("Displaying order History : ");
		System.out.println(orderService.showOrderHistory());

	}

}
