package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Contact;
import com.example.demo.service.ContactService;

@RestController(value="/oraclesprdatarest")
public class ContactRS {

	@Autowired
	private ContactService contactService;
	
	@GetMapping("/findAllContacts")
	public List<Contact> getAllContacts() {
		return contactService.findAllContacts();
	}
}
