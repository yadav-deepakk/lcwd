package com.batch.lcwd.components;

import java.util.Date;

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
		System.out.println("(1) Employee created. time: " + (new Date()).getTime());
	}

	// other member methods
	public void markIn() {
		System.out.println("markIn time : " + (new Date()).getTime());
	}

	public void doWork() {
		System.out.println("Employee is Working...");
	}

	public void markOut() {
		System.out.println("markOut time: " + (new Date()).getTime());
	}

	@PostConstruct // init method -> called after bean initialization and dependency injection
	public void init() {
		System.out.println("(2) Employee init method called. time: " + (new Date()).getTime());
	}

	@PreDestroy // destroy method -> called before bean(object) destruction.
	public void destroy() {
		System.out.println("(3) Employee pre-destroy method called. time: " + (new Date()).getTime());
	}

}
