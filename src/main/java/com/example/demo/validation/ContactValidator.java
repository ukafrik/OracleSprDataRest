package com.example.demo.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.example.demo.entity.Contact;
import com.example.demo.repository.ContactRepository;

@Component
public class ContactValidator implements Validator {

	private ContactRepository contactRepo;
	
	@Autowired
	public ContactValidator(ContactRepository contactRepo) {
		this.contactRepo = contactRepo;
	}
	
	@Override
	public boolean supports(Class<?> clazz) {
		return Contact.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Contact contact = (Contact) target;
		if (contactRepo.exists(contact.getContactid())) {
			errors.reject("Contact already exists!");
		}
	}

}
