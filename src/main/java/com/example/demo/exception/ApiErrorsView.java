package com.example.demo.exception;

import java.util.List;

public class ApiErrorsView {

	private List<ApiFieldError> fieldErrors;
	private List<ApiGlobalError> globalErrors;
	
	public ApiErrorsView(List<ApiFieldError> fieldErrors, List<ApiGlobalError> globalErrors) {
		this.setFieldErrors(fieldErrors);
		this.setGlobalErrors(globalErrors);
	}
	
	public List<ApiFieldError> getFieldErrors() {
		return fieldErrors;
	}
	public void setFieldErrors(List<ApiFieldError> fieldErrors) {
		this.fieldErrors = fieldErrors;
	}
	public List<ApiGlobalError> getGlobalErrors() {
		return globalErrors;
	}
	public void setGlobalErrors(List<ApiGlobalError> globalErrors) {
		this.globalErrors = globalErrors;
	}
	
	
}
