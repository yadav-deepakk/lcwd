package com.spring.jpa;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.spring.jpa.entity.Product;
import com.spring.jpa.repository.ProductRepo;

@SpringBootApplication
public class SpringDataJpaApplication implements CommandLineRunner {

	private final ProductRepo productRepo;

	SpringDataJpaApplication(ProductRepo productRepo){
		this.productRepo = productRepo;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringDataJpaApplication.class, args);
	}

	@Override
	public void run(String... args) {
//		List<Product> allProds =  productRepo.findAll();
//		allProds.forEach(System.out::println);
//
//		List<Product> ps =  productRepo.findByDescriptionContainingIgnoreCase("PHONE");
//		ps.forEach(System.out::println);
	}

}
