package com.spring.jdbc.model;

public class Category {
	private int id; 
	private String name;
	
	// Constructor
	public Category() {
		super();
	}
	public Category(int id, String name) {
		super();
		this.id = id;
		this.name = name;
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
	
	// toString method
	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + "]";
	} 
	
	
}
