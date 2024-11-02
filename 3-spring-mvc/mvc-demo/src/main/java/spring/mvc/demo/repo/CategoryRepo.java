package spring.mvc.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import spring.mvc.demo.entities.Category;

public interface CategoryRepo extends JpaRepository<Category, Integer>{

}
