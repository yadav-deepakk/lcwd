package com.spring.jpa;

import com.spring.jpa.entity.Product;
import com.spring.jpa.repository.ProductRepo;
import com.spring.jpa.service.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SpringDataJpaApplicationTests {

//	@Autowired
//	private ProductRepo productRepo;

	@Autowired
	private ProductService productService;

	@Test
	void contextLoads() {

//		List<Product> productsWithProKeyword = productRepo.findByTitleContaining("pro");
//		List<Product> productsWithProKeyword = productRepo.findByTitleNotContainingIgnoreCase("samsung");
//		List<Product> productsWithProKeyword = productRepo.searchByKeywordInTitle("Samsung M31");
//		List<Product> productsWithProKeyword = productRepo.getProductByKeywordInCategoryTitle("Smart Phones");
//		productsWithProKeyword.forEach(System.out::println);

		productService.transactCategoryWithProduct();

	}
}
