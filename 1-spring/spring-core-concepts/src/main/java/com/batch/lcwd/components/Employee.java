package com.batch.lcwd.components;

import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

/* ===========================
 * Container Started
 * Bean instantiated 
 * Dependency Injected
 * Custom init() method
 * Custom Utility Method
 * Custom destroy() method
 * =========================== */
@Component
public class Employee {

	public Employee() {
		System.out.println("(1) Employee created.");
	}

	// other member methods

	@PostConstruct // init method -> called after bean initialization and dependency injection
	public void init() {
		System.out.println("(2) Employee init method called...");

	}

	@PreDestroy // destroy method -> called before bean(object) destruction.
	public void destroy() {
		System.out.println("(3) Employee pre-destroy method called...");
	}

}
