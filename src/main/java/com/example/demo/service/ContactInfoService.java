package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.ContactInfo;
import com.example.demo.repository.ContactInfoRepository;

@Service
public class ContactInfoService {

	@Autowired
	private ContactInfoRepository contactInfoRepo;
	
	public List<ContactInfo> findAllContactInfo() {
		List<ContactInfo> contactInfos = new ArrayList<ContactInfo>();
		contactInfoRepo.findAll().forEach(contactInfos::add);
		
		return contactInfos;
	}
	
	public ContactInfo findContactInfoById(Long contactInfoId) {
		return contactInfoRepo.findOne(contactInfoId);
	}
}
