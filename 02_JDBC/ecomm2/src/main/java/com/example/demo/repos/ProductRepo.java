package com.example.demo.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entities.Product;


public interface ProductRepo extends JpaRepository<Product, String> {
	
	// CRUD already present
	
	// custom finder method
	List<Product> findByName(String name); 
	
	List<Product> findByDescriptionContaining(String name); 
	
	@Query("""
			select p 
			from Product p 
			where lower(concat(p.name, ' ', p.description)) 
			like(concat('%', :keyword, '%'))
			""")
	List<Product> searchByTheKeyword(@Param("keyword") String keyword); 

}
