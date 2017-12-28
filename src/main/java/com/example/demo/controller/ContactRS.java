package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Contact;
import com.example.demo.entity.ErrorResponse;
import com.example.demo.exception.ContactException;
import com.example.demo.service.ContactService;

@RestController(value="/oraclesprdatarest")
public class ContactRS {

	@Autowired
	private ContactService contactService;
	
	@GetMapping("/findAllContacts")
	public ResponseEntity<List<Contact>> getAllContacts() throws ContactException {
		
		List<Contact> contacts = contactService.findAllContacts();
		if (contacts == null || contacts.size() > 1) {
			throw new ContactException("Don't want size of Contacts to be greater than 1 or be null");
		}
		
		return new ResponseEntity<List<Contact>>(contacts, HttpStatus.OK);
	}
	
	//Spring provides us with @ExceptionHandler annotation to specifically handle a particular 
	//or a common type of exceptions in the controller
	//Note the @ExceptionHandler method in our controller, which should handle only 
	//the EmployeeException thrown in any of the layers of our application
	//But what if a NullPointerException gets thrown from nowhere. To be on the safer side, 
	//we must have a generic exception handler in our application, which handles all other exception types, 
	//such as IOException, NullPointerException and so on. To do that, Spring introduced @ControllerAdvice in version 3.2, 
	//where can create a Controller Advice class in our application, which would be capable of handling 
	//all the global exception scenarios
	@ExceptionHandler(ContactException.class)
	public ResponseEntity<ErrorResponse> exceptionHandler(Exception ex) {
		ErrorResponse error = new ErrorResponse();
		error.setErrorCode(HttpStatus.PRECONDITION_FAILED.value());
		error.setMessage(ex.getMessage());
		
		return new ResponseEntity<ErrorResponse>(error, HttpStatus.OK);
	}
}
