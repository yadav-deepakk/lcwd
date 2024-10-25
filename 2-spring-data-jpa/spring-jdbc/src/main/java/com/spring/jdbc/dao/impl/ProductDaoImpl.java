package com.spring.jdbc.dao.impl;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.spring.jdbc.dao.ProductDao;
import com.spring.jdbc.dto.ProductDto;
import com.spring.jdbc.model.Product;

import jakarta.annotation.PostConstruct;

@Component
public class ProductDaoImpl implements ProductDao {

	private final JdbcTemplate jdbcTemplate;

	private RowMapper<Product> rowMapper = (rs, rowNum) -> {
		Product product = new Product();
		product.setId(rs.getInt("id"));
		product.setName(rs.getString("name"));
		product.setDescription(rs.getString("description"));
		product.setPrice(rs.getFloat("price"));
		product.setCategoryId(rs.getInt("category_id"));
		return product;
	};

	private RowMapper<ProductDto> productDtoRowMapper = (rs, rowNum) -> {
		ProductDto productDto = new ProductDto();
		productDto.setId(rs.getInt("pid"));
		productDto.setName(rs.getString("pname"));
		productDto.setDescription(rs.getString("pdescription"));
		productDto.setPrice(rs.getFloat("pprice"));
		productDto.setProductCategory(rs.getString("cname"));
		return productDto;
	};

	private ProductDaoImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@PostConstruct
	public void createTableProduct() {
		String query = "CREATE TABLE IF NOT EXISTS product(id INT AUTO_INCREMENT PRIMARY KEY, "
				+ "name VARCHAR(100) NOT NULL, description TEXT, price DECIMAL(10, 2) NOT NULL, "
				+ "category_id int, FOREIGN KEY (category_id) REFERENCES category(id));";
		jdbcTemplate.execute(query);
	}

	@Override
	public boolean save(Product product) {
		String query = "INSERT INTO product(name, description, price, category_id) VALUES(?,?,?,?);";
		int rowsAffected = jdbcTemplate.update(query, product.getName(), product.getDescription(), product.getPrice(),
				product.getCategoryId());
		return rowsAffected == 1;
	}

	@Override
	public List<ProductDto> getAllProducts() {
		String query = "SELECT p.id as pid, p.name as pname, p.description as pdescription, p.price as pprice, c.name as cname "
				+ "FROM product p INNER JOIN category c ON p.category_id = c.id";
		return jdbcTemplate.query(query, this.productDtoRowMapper);
	}

	@Override
	public Product getProductById(int id) {
		String sql = "SELECT * FROM product WHERE id = ?;";
		List<Product> products = jdbcTemplate.query(sql, this.rowMapper, id);
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
