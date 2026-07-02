package com.elearn.apis.exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.elearn.apis.respones.ErrorResponse;

import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {
	

	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorResponse handleRuntimeExceptions(MethodArgumentNotValidException e, HttpServletRequest request) {
		return new ErrorResponse(HttpStatus.BAD_REQUEST, e.getMessage(), request.getRequestURI(),
				LocalDateTime.now());
	}
	
	@ExceptionHandler(ResourceNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ErrorResponse handleRuntimeExceptions(ResourceNotFoundException e, HttpServletRequest request) {
		return new ErrorResponse(HttpStatus.NOT_FOUND, e.getMessage(), request.getRequestURI(),
				LocalDateTime.now());
	}

	@ExceptionHandler(RuntimeException.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public ErrorResponse handleRuntimeExceptions(RuntimeException e, HttpServletRequest request) {
		return new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), request.getRequestURI(),
				LocalDateTime.now());
	}

}
