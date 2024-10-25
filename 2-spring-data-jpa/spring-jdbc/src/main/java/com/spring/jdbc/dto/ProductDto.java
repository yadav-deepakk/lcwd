package com.spring.jdbc.dto;

public class ProductDto {
	private int id;
	private String name;
	private String description;
	private float price;
	private String productCategory;

	// Constructor
	public ProductDto() {
		super();
	}
	public ProductDto(int id, String name, String description, float price, String productCategory) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.productCategory = productCategory;
	}

	// Getter/Setter
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getProductCategory() {
		return productCategory;
	}
	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}

	// ToStringFunction
	@Override
	public String toString() {
		return "ProductDto [id=" + id + ", name=" + name + ", price=" + price + ", productCategory=" + productCategory
				+ "]";
	}

}
