package com.spring.jpa.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.spring.jpa.entity.Product;
import com.spring.jpa.repository.ProductRepo;
import com.spring.jpa.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	private final ProductRepo productRepo;

	public ProductServiceImpl(ProductRepo productRepo) {
		super();
		this.productRepo = productRepo;
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
}
