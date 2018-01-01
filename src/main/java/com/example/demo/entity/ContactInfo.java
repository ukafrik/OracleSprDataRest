package com.example.demo.entity;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.Min;


/**
 * The persistent class for the CONTACTINFO database table.
 * 
 */
@Entity
@Table(name="CONTACTINFO")
@NamedQuery(name="ContactInfo.findAll", query="SELECT c FROM ContactInfo c")
public class ContactInfo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="CONTACTINFO_ID_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CONTACTINFO_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=10)
	@Min(1)
	private long id;

	@Column(length=255)
	private String email;

	@Column(length=255)
	private String name;

	@Column(length=255)
	private String phonenumber;

	public ContactInfo() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhonenumber() {
		return this.phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

}