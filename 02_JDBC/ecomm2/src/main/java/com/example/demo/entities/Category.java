package com.example.demo.entities;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "category")
@Getter
@Setter
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String categoryId;

	@Column(nullable = false, length = 200, unique = true)
	private String title;

	@Column(length = 500)
	private String description;
	
	@OneToMany(mappedBy = "category")
	private Set<Product> productSet = new HashSet<>(); 

}
