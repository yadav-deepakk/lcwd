package com.elearn.apis.entities;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

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
  private Long id;

  private String title;

  @Column(length = 3000)
  private String description;

  private BigDecimal price;

  @ManyToMany(mappedBy = "purchasedCourses")
  @Builder.Default
  private Set<User> users = new HashSet<>();

  @ManyToMany(mappedBy = "courseSet")
  @Builder.Default
  private Set<Category> categorySet = new HashSet<>();

}
