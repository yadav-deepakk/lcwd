package com.batch.lcwd.service.impl;

import org.springframework.stereotype.Component;

import com.batch.lcwd.service.AuthService;

@Component
public class MySqlAuthService implements  AuthService{

	@Override
	public boolean loginUser() throws Exception {
		System.out.println("wait...");
		Thread.sleep(3000);
		System.out.println("login success in mysql!");
		return true;
	}

	@Override
	public boolean logoutUser() throws Exception {
		System.out.println("trying logout user...");
		Thread.sleep(4000);
		System.out.println("logout success!");
		return true;
	}
	
	

}
