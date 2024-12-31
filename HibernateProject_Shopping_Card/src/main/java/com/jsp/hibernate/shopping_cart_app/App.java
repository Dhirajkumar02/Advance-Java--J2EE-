package com.jsp.hibernate.shopping_cart_app;

import java.util.Scanner;

import com.jsp.hibernate.shopping_cart.dao.ShoppingCartDao;


public class App {
	public static void main(String[] args) {

		ShoppingCartDao dao = new ShoppingCartDao();
		Scanner sc = new Scanner(System.in);

		System.out.println("Choose an operation:");
		System.out.println("1. Add Product");
		System.out.println("2. Add User With Cart");
		System.out.println("3. Add Product to Cart");
		System.out.println("4. Remove Product from the Cart");
		System.out.println("5. Find all product from the cart");
		System.out.println("6. Exit");

		int choice = sc.nextInt();
		switch (choice) {
		case 1:
			dao.addProduct();
			break;

		case 2:
			dao.addUserWithCart();
			break;
			
		case 3:
			dao.addProductToCart();
			break;
			
		case 4:
			dao.removeProductFromCart();
			break;
			
		case 5:
			dao.findAllProductFromCart();
			break;

		case 6:
			System.out.println("Exiting...");
			break;

		default:
			System.out.println("Invalid choice.");
			break;
		}

		sc.close();
	}

}

