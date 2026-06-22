package com.example.demo.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.example.demo.dao.pojo.Product;
import java.util.Collections;

@Component
public class ProductDaoImpl implements ProductDao {

	private final JdbcTemplate template;

	public ProductDaoImpl(JdbcTemplate template) {
		super();
		this.template = template;

		String query = """
				create table if not exists product(
				    id serial primary key,
				    title varchar(255),
				    description varchar(555),
				    price int not null
				)
				""";

		try {
			template.execute(query);
		} catch (Exception ex) {
			System.out.println("error in creating the product table.");
		}
	}

	@Override
	public void save(Product product) {

		try {

			String query = "insert into product(title, description, price) values (?,?,?)";

			template.update(query, product.getProductTitle(), product.getProductDescription(),
					product.getProductPrice());

		} catch (Exception ex) {
			System.out.println("error in inserting in the product table.");
			System.out.println(ex);
		}

	}

	@Override
	public void update(int id, Product product) {
		try {
			String query = "update product set title=?, description=?, price=? where id=?";
			template.update(query, product.getProductTitle(), product.getProductDescription(),
					product.getProductPrice(), id);
		} catch (Exception ex) {
			System.out.println("error in updating product table.");
			System.out.println(ex);
		}

	}

	@Override
	public void delete(int id) {
		try {
			String query = "delete from product where id=?";
			template.update(query, id);
		} catch (Exception ex) {
			System.out.println("error while deleting in product table.");
			System.out.println(ex);
		}
	}

	@Override
	public Product getProductById(int id) {

		try {
			String query = "select * from product where id=?";
			return template.queryForObject(query, productRowMapper, id);
		} catch (Exception ex) {
			System.out.println("error in inserting in the product table.");
			System.out.println(ex);
		}

		return null;
	}

	@Override
	public List<Product> getProductList() {
		try {

			String query = "select * from product";
			return template.query(query, productRowMapper);

		} catch (Exception ex) {
			System.out.println("error in inserting in the product table.");
			System.out.println(ex);
			return Collections.emptyList();
		}

	}

	@Override
	public List<Product> search(String keyword) {

		try {

			String query = """
					select * from product where lower(title) like(?) or lower(description) like lower(?)
					""";
			String pattern = "%" + keyword + "%";
			template.query(query, productRowMapper, pattern, pattern);

		} catch (Exception ex) {
			System.out.println("error in inserting in the product table.");
			System.out.println(ex);
		}
		return null;
	}

	private final RowMapper<Product> productRowMapper = (rs, rowNum) -> {
		Product product = new Product();
		product.setProductId(rs.getInt("id"));
		product.setProductTitle(rs.getString("title"));
		product.setProductDescription(rs.getString("description"));
		product.setProductPrice(rs.getInt("price"));
		return product;
	};

}
