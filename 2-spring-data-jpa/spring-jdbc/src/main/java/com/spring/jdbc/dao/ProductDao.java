package com.spring.jdbc.dao;

import java.util.List;

import com.spring.jdbc.dto.ProductDto;
import com.spring.jdbc.model.Product;

public interface ProductDao {
	// C - Create
	boolean save(Product product); 
	
	// R - Read
	List<ProductDto> getAllProducts(); 
	Product getProductById(int id); 
	List<Product> searchProductsByName(String keyword); 
	List<Product> searchProductsByDescription(String keyword); 
	List<Product> searchProductsByPriceRange(int low, int high); 
	
	// U - Update
	int update(Product product); 
	
	// D - Delete
	int delete(Product product); 
	int delete(int id); 
}
