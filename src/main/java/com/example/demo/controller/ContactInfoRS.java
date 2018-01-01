package com.example.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.ContactInfo;
import com.example.demo.service.ContactInfoService;

@RestController(value="/oraclesprdatarest/contactInfo")
public class ContactInfoRS {

	@Autowired
	private ContactInfoService contactInfoService;
	
	@GetMapping("/findAllContactInfo")
	public ResponseEntity<List<ContactInfo>> findAllContactInfo() {
		List<ContactInfo> contactInfos = contactInfoService.findAllContactInfo();
		
		return new ResponseEntity<List<ContactInfo>>(contactInfos, HttpStatus.OK);
	}
	
	@GetMapping("/finaContactInfoById/{contactId}")
	public ResponseEntity<ContactInfo> findContact(@Valid @PathVariable Long contactId) {
		ContactInfo contactInfo = contactInfoService.findContactInfoById(contactId);
		
		return new ResponseEntity<ContactInfo>(contactInfo, HttpStatus.OK);
	}
}
