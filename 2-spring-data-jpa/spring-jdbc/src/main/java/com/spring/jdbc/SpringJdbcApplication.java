package com.spring.jdbc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.spring.jdbc.dao.ProductDao;
import com.spring.jdbc.dto.ProductDto;
import com.spring.jdbc.model.Product;

@SpringBootApplication
public class SpringJdbcApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(SpringJdbcApplication.class, args);

		/*
		 * // product Product samsungM31 = new Product(101, "Samsung Galaxy M31",
		 * "Samsung Phone", 16_679); Product iPhone = new Product(102, "iPhone 13",
		 * "iPhone", 45_559);
		 * 
		 * // save it. ProductDao productDao = context.getBean(ProductDao.class);
		 * productDao.save(samsungM31); productDao.save(iPhone);
		 */

		ProductDao productDao = context.getBean(ProductDao.class);
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String choice = null;
		int ch = 0;

		do {

			// Add
			// Update
			// Delete
			// Display all
			// Display single
			// Search by name
			// exit

			int id;
			String name, desc;
			float price;
			Product product = null;
			java.util.List<Product> productList = null;

			System.out.println("================ MENU ===============");
			System.out.println("1. Add a product");
			System.out.println("2. Update a product");
			System.out.println("3. Delete a product");
			System.out.println("4. Display all products");
			System.out.println("5. Display product by id");
			System.out.println("6. Search product by name");
			System.out.println("7. Exit");
			System.out.println("Enter your choice (1 - 7) : ");

			try {

				try {
					choice = reader.readLine();
					ch = Integer.parseInt(choice);
				} catch (Exception ex) {
					ex.printStackTrace();
					throw new Exception("Bad Choice!");
				}

				switch (ch) {
				case 1:
					System.out.println("=========== Add a product ==========");
					System.out.println("Enter product name : ");
					name = reader.readLine();
					System.out.println("Enter product description : ");
					desc = reader.readLine();
					System.out.println("Enter product price : ");
					price = Float.parseFloat(reader.readLine());
					product = new Product(name, desc, price, 101);
					productDao.save(product);
					break;

				case 2:
					System.out.println("=========== Update a product ==========");
					System.out.println("Enter id (existing) : ");
					id = Integer.parseInt(reader.readLine());
					System.out.println("Enter product name : ");
					name = reader.readLine();
					System.out.println("Enter product description : ");
					desc = reader.readLine();
					System.out.println("Enter product price : ");
					price = Float.parseFloat(reader.readLine());
					product = new Product(id, name, desc, price, 101);
					productDao.update(product);
					break;

				case 3:
					System.out.println("=========== Delete a product ==========");
					System.out.println("Enter product id to be deleted : ");
					id = Integer.parseInt(reader.readLine());
					System.out.println("Are you sure you want to delete? (yes/y/n) : ");
					String c = reader.readLine();
					if (c.toLowerCase().equals("y") || c.toLowerCase().equals("yes"))
						productDao.delete(id);
					else
						System.out.println("Deletion Aborted!");
					break;

				case 4:
					System.out.println("=========== Display all products ==========");
					List<ProductDto> productDtoList = productDao.getAllProducts();
					if (productDtoList.size() > 0)
						productDtoList.forEach((fetchedProductDto) -> System.out.println(fetchedProductDto));
					else
						System.out.println("ProductDto List is Empty!");
					break;

				case 5:
					System.out.println("=========== Display a product ==========");
					System.out.println("Enter product id : ");
					id = Integer.parseInt(reader.readLine());
					product = productDao.getProductById(id);
					if (product != null)
						System.out.println(product);
					else
						System.out.println("Product not found with given id");
					break;

				case 6:
					System.out.println("=========== Search a product by name ==========");
					System.out.println("Search product by name : ");
					name = reader.readLine();
					productList = productDao.searchProductsByName(name);
					if (productList.size() > 0)
						for (Product fetchedProduct : productList)
							System.out.println(fetchedProduct);
					else
						System.out.println("Product List is Empty!");
					break;

				case 7:
					System.out.println("Thank you for using application.");
					System.out.println("Quiting...");
					break;

				default:
					System.out.println("No Choice Match!");
					break;
				}

			} catch (Exception e) {
				e.printStackTrace();
			}

		} while (ch != 7);

		context.close();
	}

}
