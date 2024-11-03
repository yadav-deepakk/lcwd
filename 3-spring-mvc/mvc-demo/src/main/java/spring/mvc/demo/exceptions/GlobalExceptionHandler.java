package spring.mvc.demo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public ErrorResponse handleAllExceptions(Exception ex) {
		return new ErrorResponse("Internal Server Error", ex.getMessage());
	}

	@ExceptionHandler(ResourceNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ErrorResponse handleNotFoundExceptions(ResourceNotFoundException ex) {
		return new ErrorResponse("Resource Not Found", ex.getMessage());
	}

	static class ErrorResponse {
		private String message;
		private String details;

		public ErrorResponse(String message, String details) {
			this.message = message;
			this.details = details;

		}

		public String getMessage() {
			return message;
		}
		public void setMessage(String message) {
			this.message = message;
		}
		public String getDetails() {
			return details;
		}
		public void setDetails(String details) {
			this.details = details;
		}

		@Override
		public String toString() {
			return "ErrorResponse [message=" + message + ", details=" + details + "]";
		}
	}
}