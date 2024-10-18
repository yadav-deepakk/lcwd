package com.batch.lcwd.service.impl;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import com.batch.lcwd.service.AuthService;

@Component
@Primary
public class OracleAuthService implements AuthService {

	@Override
	public boolean loginUser() throws Exception {
		System.out.println("wait...");
		Thread.sleep(2000);
		System.out.println("Login successful in oracle db.");
		return true;
	}

	@Override
	public boolean logoutUser() throws Exception {
		System.out.println("wait...");
		Thread.sleep(2000);
		System.out.println("Logout successful in oracle db.");
		return true;
	}
	
}
