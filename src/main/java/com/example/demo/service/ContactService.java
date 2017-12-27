package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Contact;
import com.example.demo.repository.ContactRepository;

@Service
public class ContactService {

	@Autowired
	ContactRepository contactRepo;
	
	public List<Contact> findAllContacts() {
		
		List<Contact> contacts = new ArrayList<Contact>();
		contactRepo.findAll().forEach(contacts::add);
		
		return contacts;
	}
}
