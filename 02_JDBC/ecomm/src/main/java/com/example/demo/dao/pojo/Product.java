package com.example.demo.dao.pojo;

public class Product {

	private int productId;
	private String productTitle;
	private String productDescription;
	private int productPrice;

	public Product() {
	}

	public Product(int productId, String productTitle, String productDescription, int productPrice) {
		super();
		this.productId = productId;
		this.productTitle = productTitle;
		this.productDescription = productDescription;
		this.productPrice = productPrice;
	}

	public String getProductTitle() {
		return productTitle;
	}

	public void setProductTitle(String productTitle) {
		this.productTitle = productTitle;
	}

	public int getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productTitle=" + productTitle + ", productDescription="
				+ productDescription + ", productPrice=" + productPrice + "]";
	}

}
