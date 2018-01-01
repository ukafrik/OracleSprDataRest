package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.ContactInfo;


@Repository
public interface ContactInfoRepository extends CrudRepository<ContactInfo, Long> {

}
