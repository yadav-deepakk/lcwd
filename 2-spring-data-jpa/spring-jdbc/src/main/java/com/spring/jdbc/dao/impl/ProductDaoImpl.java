package com.spring.jdbc.dao.impl;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.spring.jdbc.dao.ProductDao;
import com.spring.jdbc.model.Product;

import jakarta.annotation.PostConstruct;

@Component
public class ProductDaoImpl implements ProductDao {

	private final JdbcTemplate jdbcTemplate;

	private ProductDaoImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@PostConstruct
	public void createTableProduct() {
		String query = "CREATE TABLE IF NOT EXISTS Product(id INT AUTO_INCREMENT PRIMARY KEY, name VARCHAR(100) NOT NULL, description TEXT, price DECIMAL(10, 2) NOT NULL);";
		jdbcTemplate.execute(query);
	}

	@Override
	public boolean save(Product product) {
		String query = "insert into product(id, name, description, price) values(?,?,?,?);";
		int rowsAffected = jdbcTemplate.update(query, product.getId(), product.getName(), product.getDescription(),
				product.getPrice());
		return rowsAffected == 1;
	}

	@Override
	public List<Product> getAllProducts() {
		String query = "SELECT * FROM product;";
		RowMapper<Product> rowMapper = (rs, rowNum) -> {
			Product product = new Product();
			product.setId(rs.getInt("id"));
			product.setName(rs.getString("name"));
			product.setDescription(rs.getString("description"));
			product.setPrice(rs.getFloat("price"));
			return product;
		};
		return jdbcTemplate.query(query, rowMapper);
	}

	@Override
	public Product getProductById(int id) {
		String sql = "SELECT * FROM product WHERE id = ?;";
		RowMapper<Product> rowMapper = (rs, rowNum) -> {
			Product product = new Product();
			product.setId(rs.getInt("id"));
			product.setName(rs.getString("name"));
			product.setDescription(rs.getString("description"));
			product.setPrice(rs.getFloat("price"));
			return product;
		};
		List<Product> products = jdbcTemplate.query(sql, rowMapper, id);
		return products.isEmpty() ? null : products.get(0);
	}

	@Override
	public List<Product> searchProductsByName(String keyword) {
		return null;
	}

	@Override
	public List<Product> searchProductsByDescription(String keyword) {
		return null;
	}

	@Override
	public List<Product> searchProductsByPriceRange(int low, int high) {
		return null;
	}

	@Override
	public int update(Product product) {
		String sql = "UPDATE product SET name = ?, description = ?, price = ? WHERE id = ?";
		return jdbcTemplate.update(sql, product.getName(), product.getDescription(), product.getPrice(),
				product.getId());
	}

	@Override
	public int delete(Product product) {
		return this.delete(product.getId());
	}

	@Override
	public int delete(int id) {
		String sql = "DELETE FROM product WHERE id = ?;";
		return jdbcTemplate.update(sql, id);
	}

}
