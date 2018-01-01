package com.example.demo.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.example.demo.entity.ContactInfo;
import com.example.demo.repository.ContactInfoRepository;

@Component
public class ContactInfoValidator implements Validator {

	private ContactInfoRepository contactInfoRepo;
	
	@Autowired
	public ContactInfoValidator(ContactInfoRepository contactRepo) {
		this.contactInfoRepo = contactRepo;
	}
	
	@Override
	public boolean supports(Class<?> clazz) {
		return ContactInfo.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ContactInfo contactInfo = (ContactInfo) target;
		if (contactInfoRepo.exists(contactInfo.getId())) {
			errors.reject("ContactInfo already exists!");
		}
	}

}
