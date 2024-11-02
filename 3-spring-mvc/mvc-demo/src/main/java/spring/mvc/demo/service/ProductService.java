package spring.mvc.demo.service;

import java.util.List;
import java.util.Optional;

import spring.mvc.demo.entities.Category;
import spring.mvc.demo.entities.Product;

public interface ProductService {
	// C - Create
	Product save(Product product);
	
	// R - Read
	List<Product> getAllProducts();
	List<Product> getProductsByCategory(Category category); 
	Optional<Product> getById(Long id);
	
	// U - Update
	Product update(Product product); 
	
	// D - Delete
	boolean deleteById(Long id); 
	boolean delete(Product product);
	
}
