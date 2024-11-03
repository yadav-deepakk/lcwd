package spring.mvc.demo.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import spring.mvc.demo.entities.Category;
import spring.mvc.demo.exceptions.ResourceNotFoundException;
import spring.mvc.demo.service.CategoryService;

@RestController
@RequestMapping("/category")
public class CategoryController {

	private final CategoryService categoryService;

	public CategoryController(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	@PostMapping
	public ResponseEntity<Category> saveCategory(@RequestBody Category category) {
		return ResponseEntity.ok(categoryService.save(category));
	}

	@PostMapping("/image")
	public ResponseEntity<Boolean> uploadImage(@RequestParam("file") MultipartFile imgFile) {
		System.out.println("Category image upload.");
		return ResponseEntity.ok(categoryService.uploadImage(imgFile));
	}

	@GetMapping
	public ResponseEntity<List<Category>> getAllCategories() {
		return ResponseEntity.ok(categoryService.getAllCategories());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Category> getCategoryById(@PathVariable Integer id) throws ResourceNotFoundException {
		return ResponseEntity.ok(categoryService.getById(id));
	}

	@PutMapping
	public ResponseEntity<Category> updateCategory(@RequestBody Category category) {
		return ResponseEntity.ok(categoryService.update(category));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Boolean> deleteCategory(@PathVariable Integer id) {
		return ResponseEntity.ok(categoryService.deleteById(id));
	}

//	@ExceptionHandler(RuntimeException.class)
//	public ResponseEntity<String> handleException(RuntimeException ex) {
//		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error occured : " + ex.getMessage());
//	}

}
