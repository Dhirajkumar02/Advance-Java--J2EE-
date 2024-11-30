package com.jsp.hibernate.shopping_cart.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.jsp.hibernate.shopping_cart.entity.Cart;
import com.jsp.hibernate.shopping_cart.entity.Product;
import com.jsp.hibernate.shopping_cart.entity.User;


public class ShoppingCartDao {
	public static Session getSession() {
		Configuration cfg = new Configuration();
		cfg.configure();
		cfg.addAnnotatedClass(User.class);
		cfg.addAnnotatedClass(Cart.class);
		cfg.addAnnotatedClass(Product.class);
		SessionFactory sf = cfg.buildSessionFactory();
		return sf.openSession();
	}

	public void addProduct() {
		Product product = new Product();
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter Product Id: ");
		product.setProductId(sc.nextInt());
		sc.nextLine(); // Consume leftover newline
		System.out.print("Enter Product Name: ");
		product.setProductName(sc.nextLine());
		System.out.print("Enter Product Brand: ");
		product.setProductBrand(sc.nextLine());
		System.out.print("Enter Product Price: ");
		product.setProductPrice(sc.nextInt());

		Session session = getSession();
		Transaction tran = session.beginTransaction();
		session.save(product);
		tran.commit();
		session.close();
		sc.close();

	}

	public void addUserWithCart() {
		User user = new User();
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter User Id: ");
		user.setUserId(sc.nextInt());
		sc.nextLine(); // Consume leftover newline
		System.out.print("Enter User Name: ");
		user.setUserName(sc.nextLine());
		System.out.print("Enter User Email: ");
		user.setUserEmail(sc.nextLine());
		System.out.print("Enter User Age: ");
		user.setUserAge(sc.nextInt());
		sc.nextLine();
		System.out.print("Enter User City: ");
		user.setUserCity(sc.nextLine());

		Cart cart = new Cart();
		Scanner sc1 = new Scanner(System.in);
		System.out.print("Enter Cart Id: ");
		cart.setCartId(sc1.nextInt());

		// Adding User with cart
		user.setCart(cart);

		Session session = getSession();
		Transaction tran = session.beginTransaction();
		session.save(user);
		session.save(cart);
		tran.commit();
		session.close();
		sc.close();
		sc1.close();

	}

	public void addProductToCart() {

		Scanner sc = new Scanner(System.in);
		Session session = getSession();
		Transaction tran = session.beginTransaction();
		// Find the product based on the Id
		System.out.println("Enter Product Id: ");
		Product product =  session.get(Product.class, sc.nextInt());
		// Write one condition to check if the Product exists
		if (product != null) {
			System.out.println("Enter User Id: ");
			// Find the User based on Id
			User existingUser = session.get(User.class, sc.nextInt()); 
			// Write one condition to check if the User exists
			if(existingUser != null) {
				Cart cart = existingUser.getCart();
				if(cart == null) {
					System.out.println("Cart not found for user. Creating a new cart.");
					cart = new Cart();
					cart.setCartId(sc.nextInt());
					existingUser.setCart(cart);
				}

				// Get the existing product list or initialize it
				List<Product> pList = cart.getProducts();
				if(pList == null) {
					pList = new ArrayList<Product>();
				}
				// Add the product to the cart
				pList.add(product);
				cart.setProducts(pList);

				// Save or Update the cart
				session.update(cart);

				System.out.println("Product added to cart successfully.");
			}else {
				System.out.println("User Not Found");
			}
		}else {
			System.err.println("Product is not Found");
		}

		tran.commit();
		sc.close();

	}
	public void removeProductFromCart() {
		Scanner sc = new Scanner(System.in); 
		Session session = getSession();
		Transaction tran = session.beginTransaction();

		System.out.println("Enter User Id: ");
		User user = session.get(User.class, sc.nextInt());

		if (user != null) {
			Cart cart = user.getCart();

			if (cart != null) {
				System.out.println("Enter Product Id to remove: ");
				int productId =sc.nextInt();

				// Fetch the product list from the cart
				List<Product> products = cart.getProducts();

				if(products != null && !products.isEmpty()) {
					Product productToRemove = null;

					// Find the product to remove
					for(Product product : products) {
						if(product.getProductId() == productId) {
							productToRemove = product;
							break;
						}
					}


					if (productToRemove != null) {
						//Remove the product from the carts product list
						products.remove(productToRemove);
						cart.setProducts(products);
						session.update(cart);
						System.out.println("Product removed from cart successfully.");
					} else {
						System.err.println("Product not found in the cart.");
					}
				} else {
					System.err.println("The cart is empty.");
				}
			} else {
				System.err.println("Cart not found for this user.");
			}
		}else {
			System.err.println("User not found.");
		}

		tran.commit();
		sc.close();

	}


	public void findAllProductFromCart() {
		Scanner sc = new Scanner(System.in); 
		Session session = getSession();
		System.out.print("Enter User Id: ");
		int userId = sc.nextInt();
		User user = session.get(User.class, userId);

		if (user != null) {
			Cart cart = user.getCart();
			if (cart != null) {
				List<Product> products = cart.getProducts();

				if (products != null && !products.isEmpty()) {
					System.out.println("Products in the cart:");
					for (Product product : products) {
						System.out.println("Product ID: " + product.getProductId() +
								", Name: " + product.getProductName() +
								", Brand: " + product.getProductBrand() +
								", Price: " + product.getProductPrice());
					}
				} else {
					System.out.println("No products found in the cart.");
				}
			} else {
				System.out.println("Cart is empty or not found.");
			}
		} else {
			System.err.println("User not found.");
		}

		sc.close();
	}


}
