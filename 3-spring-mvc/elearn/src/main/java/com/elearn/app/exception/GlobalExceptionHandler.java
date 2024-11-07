package com.elearn.app.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.elearn.app.dto.CustomMessage;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	public CustomMessage handleNotFoundException(ResourceNotFoundException ex) {
		return CustomMessage.builder().message("Not Found").details(ex.getMessage()).build();
	}

	@ExceptionHandler(Exception.class)
	@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
	public CustomMessage handleException(Exception ex) {
		return CustomMessage.builder().message("Internal Server Error").details(ex.getMessage()).build();
	}
}
