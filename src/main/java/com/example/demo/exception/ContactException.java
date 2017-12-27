package com.example.demo.exception;

public class ContactException extends Exception {

	private static final long serialVersionUID = 1L;
	private String errorMessage;
	
	public ContactException() {
		super();
	}
	
	public ContactException (String errorMessage) {
		super(errorMessage);
		this.errorMessage = errorMessage;
	}
	
	public String getErrorMessage() {
		return errorMessage;
	}
}
