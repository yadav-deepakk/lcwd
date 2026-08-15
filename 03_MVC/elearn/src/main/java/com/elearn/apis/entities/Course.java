package com.elearn.apis.entities;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private UUID id;

	private String title;

	@Column(length = 500)
	private String shortDescription;

	@Column(length = 3000)
	private String longDescription;

	private BigDecimal price;

	private String banner;

	private boolean live;

	@CreationTimestamp
	private LocalDateTime createdAt;

	@UpdateTimestamp
	private LocalDateTime updatedAt;

	@ManyToMany(mappedBy = "courseSet")
	@Builder.Default
	private Set<Category> categorySet = new HashSet<>();

	public void addCategory(Category category) {
		this.categorySet.add(category);
		category.getCourseSet().add(this);
	}

	public void removeCategory(Category category) {
		this.categorySet.remove(category);
		
		category.getCourseSet().remove(this);
	}

}
