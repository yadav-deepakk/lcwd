package com.spring.jpa.service.impl;

import java.util.List;
import java.util.Optional;

import com.spring.jpa.entity.Category;
import com.spring.jpa.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import com.spring.jpa.entity.Product;
import com.spring.jpa.repository.ProductRepo;
import com.spring.jpa.service.ProductService;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductServiceImpl implements ProductService {

	private final ProductRepo productRepo;
	private final CategoryRepository categoryRepo;

	public ProductServiceImpl(ProductRepo productRepo, CategoryRepository categoryRepo) {
		super();
		this.productRepo = productRepo;
		this.categoryRepo = categoryRepo;
	}

	@Override
	public Product save(Product product) {
		return productRepo.save(product);
	}

	@Override
	public Optional<Product> getById(String id) {
		return productRepo.findById(id);
	}

	@Override
	public List<Product> getAllProduct() {
		return productRepo.findAll();
	}

	@Override
	public Product update(Product product) {
		return this.save(product);
	}

	@Override
	public boolean delete(Product product) {
		productRepo.delete(product);
		return this.getById(product.getId()).isEmpty();
	}

	@Override
	public boolean deleteById(String id) {
		productRepo.deleteById(id);
		return this.getById(id).isEmpty();
	}

	@Transactional
	public void transactCategoryWithProduct() {

		Category category = new Category("TV","This category will have television and smart tvs.");
		categoryRepo.save(category);

		Product product = new Product("Samsung Smart TV","A samsung tv product",15000,true);
		productRepo.save(product);
	}
}
