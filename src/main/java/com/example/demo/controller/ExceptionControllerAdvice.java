package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.demo.entity.ErrorResponse;

//A class which annotated with @ControllerAdvice will be registered as the global exception handler
//This means that if we ever get an unexpected exception in our application other than the custom exception, 
//a generic error object will be prepared, with a generic error code and error message, which will be returned 
//as error JSON response
@ControllerAdvice
public class ExceptionControllerAdvice {

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponse> exceptionHandler(Exception ex) {
		ErrorResponse error = new ErrorResponse();
		error.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
		error.setMessage("Please contact your admin");
		
		return new ResponseEntity<ErrorResponse>(error, HttpStatus.OK);
	}
}
