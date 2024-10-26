package com.spring.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.spring.jpa.entity.Category;
import com.spring.jpa.entity.Product;
import com.spring.jpa.service.CategoryService;
import com.spring.jpa.service.ProductService;

@SpringBootApplication
public class SpringDataJpaApplication implements CommandLineRunner {

	@Autowired
	private ProductService productService;

	@Autowired
	private CategoryService categoryService;

	public static void main(String[] args) {
		SpringApplication.run(SpringDataJpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//
//		Category smartPhones = new Category("Smart Phones", "This category will have smart phones.");
//		categoryService.save(smartPhones);
//
//		Product p1 = new Product("Samsung M31", "Samsung Product", 30_000, true, smartPhones);
//		Product p2 = new Product("Google Pixel", "Apple Product", 100_000, true, smartPhones);
//		Product p3 = new Product("iPhone 13 Pro", "Apple Product", 113_000, true, smartPhones);
//		productService.save(p1);
//		productService.save(p2);
//		productService.save(p3);

	}

}
