package com.spring.jpa.service;

import java.util.List;
import java.util.Optional;

import com.spring.jpa.entity.Product;

public interface ProductService {
	// CRUD Operation
	// C - Create
	Product save(Product product);

	// R - Read
	Optional<Product> getById(String id);
	List<Product> getAllProduct();

	// U - Update
	Product update(Product product);

	// D - Delete
	boolean delete(Product product);
	boolean deleteById(String id);

	void transactCategoryWithProduct();
}
