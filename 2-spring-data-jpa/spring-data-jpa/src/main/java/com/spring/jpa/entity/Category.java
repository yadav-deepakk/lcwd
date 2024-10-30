package com.spring.jpa.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;

@Entity
public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String title;
	private String description;

	@OneToMany(mappedBy = "productCategory")
	private List<Product> productList = new ArrayList<>();

	// Constructor
	public Category() {
		super();
	}
	public Category(String title, String description) {
		super();
		this.title = title;
		this.description = description;
	}

	// Getter, Setter
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<Product> getProductList() {
		return productList;
	}
	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}

	// toString
	@Override
	public String toString() {
		return "Category [id=" + id + ", title=" + title + ", description=" + description + "]";
	}
}
