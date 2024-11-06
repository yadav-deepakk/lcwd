package com.elearn.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.elearn.app.entities.User;

public interface UserRepo extends JpaRepository<User, String> {
	
	// Custom finder methods
	Optional<User> findByEmail(String email);
	
	// JPQL and Native queries.
}
