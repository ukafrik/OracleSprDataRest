package com.example.demo.entity;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;


/**
 * The persistent class for the CONTACT database table.
 * 
 */
@Entity
@Table(name="CONTACT")
@NamedQuery(name="Contact.findAll", query="SELECT c FROM Contact c")
public class Contact implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="CONTACT_CONTACTID_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CONTACT_CONTACTID_GENERATOR")
	@Column(unique=true, nullable=false, length=30)
	private String contactid;

	@Column(length=150)
	private String address;

	@Column(length=50)
	private String city;

	@Column(length=20)
	private String phone;

	@Column(length=1)
	private String testflag;

	@Column(nullable=false, length=10)
	private String zipcode;

	@JsonManagedReference
	//bi-directional many-to-one association to Customer
	@ManyToOne
	@JoinColumn(name="CUSTOMERID", nullable=false)
	private Customer customer;

	public Contact() {
	}

	public String getContactid() {
		return this.contactid;
	}

	public void setContactid(String contactid) {
		this.contactid = contactid;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getTestflag() {
		return this.testflag;
	}

	public void setTestflag(String testflag) {
		this.testflag = testflag;
	}

	public String getZipcode() {
		return this.zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

}