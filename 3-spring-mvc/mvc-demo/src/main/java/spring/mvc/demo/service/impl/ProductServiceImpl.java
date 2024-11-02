package spring.mvc.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import spring.mvc.demo.entities.Category;
import spring.mvc.demo.entities.Product;
import spring.mvc.demo.repo.ProductRepo;
import spring.mvc.demo.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	private final ProductRepo productRepo;

	public ProductServiceImpl(ProductRepo productRepo) {
		this.productRepo = productRepo;
	}

	@Override
	public Product save(Product product) {
		return productRepo.save(product);
	}

	@Override
	public List<Product> getAllProducts() {
		return productRepo.findAll();
	}

	@Override
	public List<Product> getProductsByCategory(Category category) {
		return productRepo.findByProductCategory(category);
	}

	@Override
	public Optional<Product> getById(Long id) {
		return productRepo.findById(id);
	}

	@Override
	public Product update(Product product) {
		return productRepo.save(product);
	}

	@Override
	public boolean deleteById(Long id) {
		productRepo.deleteById(id);
		return this.getById(id).isEmpty();
	}

	@Override
	public boolean delete(Product product) {
		productRepo.delete(product);
		return this.getById(product.getId()).isEmpty();
	}

}
