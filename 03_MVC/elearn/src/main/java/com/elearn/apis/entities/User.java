package com.elearn.apis.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String fName;
	private String lName;
	private String mName;

	@Column(unique = true, nullable = false)
	private String email;

	private String password;

	@ManyToMany
	@JoinTable(name = "user_courses", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "course_id"))
	@Builder.Default
	private Set<Course> purchasedCourses = new HashSet<>();
}
