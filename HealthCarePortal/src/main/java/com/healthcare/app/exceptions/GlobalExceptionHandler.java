package com.healthcare.app.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.healthcare.app.util.AppResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<AppResponse> resourceNotFoundException(ResourceNotFoundException ex) {

		String message = ex.getMessage();
		AppResponse response = new AppResponse(message, false);
		return new ResponseEntity<AppResponse>(response, HttpStatus.NOT_FOUND);
	}

//	@ExceptionHandler(ConstraintViolationException.class)
//	public ResponseEntity<Map<String, String>> methodArgsNotValidException(ConstraintViolationException ex) {
//		Map<String, String> resp = new HashMap<>();
//
//		String fieldName = ex.
//		String message = ex.getMessage();
//		resp.put(fieldName, message);
//
//		return new ResponseEntity<Map<String, String>>(resp, HttpStatus.BAD_REQUEST);
//	}

}
