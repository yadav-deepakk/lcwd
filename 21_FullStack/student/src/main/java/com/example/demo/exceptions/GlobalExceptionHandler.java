package com.example.demo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.demo.dtos.ErrorResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(exception = ResourceNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ErrorResponse resourceNotFound(ResourceNotFoundException e) {
		return ErrorResponse.builder()
				.message(e.getMessage())
				.status(HttpStatus.NOT_FOUND)
				.success(false).build();
	}
	
	@ExceptionHandler(exception = Exception.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ErrorResponse serverError(Exception e) {
		return ErrorResponse.builder()
				.message(e.getMessage())
				.status(HttpStatus.INTERNAL_SERVER_ERROR)
				.success(false).build();
	}

}
