package com.elearn.app.entities;

import java.util.Set;
import java.util.LinkedHashSet;

import org.hibernate.annotations.UuidGenerator;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Category {

	@Id
	@UuidGenerator
	private String id;
	private String title;
	private String descr;

	@ManyToMany
	@Builder.Default
	@JoinTable(name = "category_course_map", joinColumns = @JoinColumn(name = "category_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "course_id", referencedColumnName = "id"))
	private Set<Course> courseSet = new LinkedHashSet<>();

}
