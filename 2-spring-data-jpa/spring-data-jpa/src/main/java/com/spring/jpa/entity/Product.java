package com.spring.jpa.entity;

import java.util.List;

import jakarta.persistence.ManyToOne;
import org.hibernate.annotations.UuidGenerator;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Product {

	@Id
	@UuidGenerator
	private String id;
	private String title;
	private String description;
	private double price;
	private boolean isLive;

	@ManyToOne
	private Category productCategory;

	public Product() {
		super();
	}
	public Product(String title, String description, double price, boolean isLive) {
		super();
		this.title = title;
		this.description = description;
		this.price = price;
		this.isLive = isLive;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Category getProductCategory() {
		return productCategory;
	}
	public void setProductCategory(Category productCategory) {
		this.productCategory = productCategory;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public boolean isLive() {
		return isLive;
	}
	public void setLive(boolean isLive) {
		this.isLive = isLive;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", title=" + title + ", price=" + price + "]";
	}

}
