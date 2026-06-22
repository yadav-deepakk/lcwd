package com.example.demo.service;

import java.util.List;
import java.util.Scanner;

import org.springframework.stereotype.Service;

import com.example.demo.dao.ProductDao;
import com.example.demo.dao.pojo.Product;

@Service
public class ServiceCLI {

	private final ProductDao dao;

	public ServiceCLI(ProductDao dao) {
		super();
		this.dao = dao;
	}

	public void saveProduct(Scanner scan) {
		

		// consume leftover newline character \n
		scan.nextLine();

		// take details and call dao layer to save data
		System.out.println("Enter product title: ");
		String title = scan.nextLine();

		System.out.println("Enter product description: ");
		String description = scan.nextLine();

		System.out.println("Enter product price: ");
		int price = scan.nextInt();

		Product newProduct = new Product();
		newProduct.setProductTitle(title);
		newProduct.setProductDescription(description);
		newProduct.setProductPrice(price);

		dao.save(newProduct);

	}

	public void updateProduct(Scanner scan) {
		
		// consume leftover newline character \n
		scan.nextLine();

		// take new input and update at the end.
		System.out.println("Enter id of product you want to update: ");
		int id = scan.nextInt();

		System.out.println("Enter new product title: ");
		String title = scan.nextLine();

		System.out.println("Enter new product description: ");
		String description = scan.nextLine();

		System.out.println("Enter new product price: ");
		int price = scan.nextInt();

		Product product = new Product();
		product.setProductTitle(title);
		product.setProductDescription(description);
		product.setProductPrice(price);

		// update
		dao.update(id, product);

	}

	public void deleteProduct(Scanner scan) {
		System.out.println("Eneter the id of product to delete: ");
		int id = scan.nextInt();
		dao.delete(id);

	}

	public void getProduct(Scanner scan) {
		System.out.println("Enter the id of product: ");
		int id = scan.nextInt();
		Product product = dao.getProductById(id);
		System.out.println(product);
	}

	public void getAllProduct() {
		List<Product> productList = dao.getProductList();
		productList.stream().forEach(System.out::println);
	}

	public void searchProduct(Scanner scan) {
		System.out.println("Enter keyword: ");
		String keyword = scan.nextLine();
		List<Product> productList = dao.getProductList();
		productList.stream().forEach(System.out::println);

	}

}
