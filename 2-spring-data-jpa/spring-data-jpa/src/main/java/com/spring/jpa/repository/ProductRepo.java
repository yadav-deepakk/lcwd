package com.spring.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.spring.jpa.entity.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product, String> {
	List<Product> findByTitleContaining(String keyword);
	List<Product> findByTitleContainingIgnoreCase(String keyword);
	List<Product> findByTitleNotContainingIgnoreCase(String keyword);
	List<Product> findByTitleStartsWith(String prefix);
	List<Product> findByTitleEndsWith(String suffix);

	List<Product> findByDescriptionContainingIgnoreCase(String keyword);
	List<Product> findByDescriptionStartsWithIgnoreCase(String prefix);
	List<Product> findByDescriptionEndsWithIgnoreCase(String suffix);

	List<Product> findByPriceLessThan(double high);
	List<Product> findByPriceGreaterThan(double low);
	List<Product> findByPriceBetween(double high, double low);

	@Query("select p from Product p where p.title like %:keyword%")
	List<Product> searchByKeywordInTitle(@Param("keyword") String keyword);

	@Query("select p from Product as p join p.productCategory as c where c.title = :title")
	List<Product> getProductByKeywordInCategoryTitle(@Param("title") String title);
}
