package com.example.demo;

import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.dao.pojo.Product;
import com.example.demo.service.ServiceCLI;

@SpringBootApplication
public class EcommApplication implements CommandLineRunner {

	private final ServiceCLI serviceCLI;

	EcommApplication(ServiceCLI serviceCLI) {
		this.serviceCLI = serviceCLI;
	}

	public static void main(String[] args) {
		SpringApplication.run(EcommApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Scanner scan = new Scanner(System.in);
		char choice;

		do {

			System.out.println("####### Welocme To Ecomm Application ########");
			System.out.println("1. Save a product");
			System.out.println("2. Get all products ");
			System.out.println("3. Get single product");
			System.out.println("4. Update a product");
			System.out.println("5. Search a product");
			System.out.println("6. Delete a product");
			System.out.println("7. Exit from application");
			System.out.println("Choose any option from above: ");

			choice = scan.next().charAt(0);

			System.out.println("You chosen : " + choice);

			switch (choice) {
				case '1' -> serviceCLI.saveProduct(scan);
				case '2' -> serviceCLI.getAllProduct();
				case '3' -> serviceCLI.getProduct(scan);
				case '4' -> serviceCLI.updateProduct(scan);
				case '5' -> serviceCLI.searchProduct(scan);
				case '6' -> serviceCLI.deleteProduct(scan);
				case '7' -> System.out.println("##### Thank you #######");
				default -> System.out.println("Enter a valid choice!");
			}

		} while (choice != '7');

		scan.close();

	}

}
