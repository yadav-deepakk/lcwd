package com.example.demo.dao;

import java.util.List;

import com.example.demo.dao.pojo.Product;

public interface ProductDao {

	// save a product
	void save(Product product);

	// update product
	void update(int id, Product product);

	// delete product
	void delete(int id);

	// get a single product
	Product getProductById(int id);

	// get all product
	List<Product> getProductList();

	// search in the product
	List<Product> search(String keyword);
}
