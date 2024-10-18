package com.batch.lcwd.controller;

import org.springframework.stereotype.Component;

import com.batch.lcwd.service.AuthService;

@Component
public class WebPageController {

	private final AuthService authService;

	public WebPageController(AuthService authService) {
		super();
		this.authService = authService;
	}

	public void login() throws Exception {
		authService.loginUser();
	}

	public void logout() throws Exception {
		authService.logoutUser();
	}
}
