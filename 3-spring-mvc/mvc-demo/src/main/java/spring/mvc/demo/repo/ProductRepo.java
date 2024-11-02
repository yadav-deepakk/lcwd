package spring.mvc.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import spring.mvc.demo.entities.Category;
import spring.mvc.demo.entities.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product, Long>{

	List<Product> findByProductCategory(Category category); 
}
