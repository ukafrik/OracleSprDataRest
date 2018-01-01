package com.example.demo.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.fasterxml.jackson.core.JsonParseException;

@ControllerAdvice
public class GlobalExceptionHandler {
//public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({Exception.class})
    public ResponseEntity<Map<String, String>> otherExceptionHandler(Exception e) {
        Map<String, String> response = new HashMap<String, String>();
        response.put("exceptionType", "Exception");
        response.put("message", e.getMessage());
        return new ResponseEntity<Map<String, String>>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({JsonParseException.class})
    public ResponseEntity<Map<String, String>> yourExceptionHandler(JsonParseException e) {
        Map<String, String> response = new HashMap<String, String>();
        response.put("exceptionType", "JsonParseException");
        response.put("message", e.getMessage());
        return new ResponseEntity<Map<String, String>>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({NumberFormatException.class})
    public ResponseEntity<Map<String, String>> numFormatExceptionHandler(NumberFormatException e) {
        Map<String, String> response = new HashMap<String, String>();
        response.put("exceptionType", "NumberFormatException");
        response.put("message", e.getMessage());
        return new ResponseEntity<Map<String, String>>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({MissingPathVariableException.class})
    public ResponseEntity<Map<String, String>> methodArgumentNotValidExceptionHandler(MissingPathVariableException e) {
        Map<String, String> response = new HashMap<String, String>();
        response.put("exceptionType", "MissingPathVariableException");
        response.put("message", e.getMessage());
        response.put("field", e.getVariableName());
        return new ResponseEntity<Map<String, String>>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({InvalidDataAccessApiUsageException.class})
    public ResponseEntity<Map<String, String>> invalidDataAccessExcption(InvalidDataAccessApiUsageException e) {
        Map<String, String> response = new HashMap<String, String>();
        response.put("exceptionType", "InvalidDataAccessApiUsageException");
        response.put("message", "Invalid data Request");
        return new ResponseEntity<Map<String, String>>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({ContactException.class})
    public ResponseEntity<Map<String, String>> contactExceptionHandler(ContactException e) {
        Map<String, String> response = new HashMap<String, String>();
        response.put("exceptionType", "ContactException");
        response.put("message", "Contact: Bad Request");
        return new ResponseEntity<Map<String, String>>(response, HttpStatus.BAD_REQUEST);
    }

//	@Override
//	protected ResponseEntity<Object> handleMethodArgumentNotValid(
//			MethodArgumentNotValidException ex,
//			HttpHeaders headers, 
//			HttpStatus status, 
//			WebRequest request
//	) {
//		BindingResult bindingResult = ex.getBindingResult();
//		
////        Map<String, String> response = new HashMap<String, String>();
////        response.put("message", bindingResult.getFieldError().toString());
////        return new ResponseEntity<Object>(response, HttpStatus.BAD_REQUEST);
//		
//		
//		List<ApiFieldError> apiFieldErrors = bindingResult
//                .getFieldErrors()
//                .stream()
//                .map(fieldError -> new ApiFieldError(
//                        fieldError.getField(),
//                        fieldError.getCode(),
//                        fieldError.getRejectedValue())
//                )
//                .collect(toList());
//
//        List<ApiGlobalError> apiGlobalErrors = bindingResult
//                .getGlobalErrors()
//                .stream()
//                .map(globalError -> new ApiGlobalError(
//                        globalError.getCode())
//                )
//                .collect(toList());
//
//        ApiErrorsView apiErrorsView = new ApiErrorsView(apiFieldErrors, apiGlobalErrors);
//
//        System.out.println(apiGlobalErrors.toString());
//        System.out.println(apiFieldErrors.toString());
//        return new ResponseEntity<>(apiErrorsView, HttpStatus.UNPROCESSABLE_ENTITY);
////		return super.handleMethodArgumentNotValid(ex, headers, status, request);
//	}
    
    
}