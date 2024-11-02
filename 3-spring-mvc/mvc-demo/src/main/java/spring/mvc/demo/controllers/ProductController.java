package spring.mvc.demo.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import spring.mvc.demo.entities.Category;
import spring.mvc.demo.entities.Product;
import spring.mvc.demo.service.ProductService;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/product")
public class ProductController {

	private final ProductService productService;

	public ProductController(ProductService productService) {
		this.productService = productService;
	}

	@PostMapping
	public ResponseEntity<Product> saveProduct(@RequestBody Product product) {
		return ResponseEntity.ok(productService.save(product));
	}

	@GetMapping
	public ResponseEntity<List<Product>> getAllProducts() {
		return ResponseEntity.ok(productService.getAllProducts());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Product> getAllProducts(@PathVariable Long id) {
		return ResponseEntity.ok(productService.getById(id).get());
	}

	@GetMapping("/category")
	public ResponseEntity<List<Product>> getAllProducts(@RequestParam("id") Integer categoryId) {
		Category category = new Category();
		category.setId(categoryId);
		return ResponseEntity.ok(productService.getProductsByCategory(category));
	}

	@PutMapping
	public ResponseEntity<Product> updateProduct(@RequestBody Product product) {
		return ResponseEntity.ok(productService.update(product));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Boolean> deleteProduct(@PathVariable Long id) {
		System.out.println("Deletion request for product id: " + id);
		return ResponseEntity.ok(productService.deleteById(id));
	}

}
