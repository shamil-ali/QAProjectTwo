package com.qa.swp.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Vehicle {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column
	private String registration;
	
	@Column
	private String type;
	
	@Column
	private String job;
	
//	@Column
//	private String contactNumber;

	public Vehicle(Integer id, String registration, String type, String job) {
		super();
		this.id = id;
		this.registration = registration;
		this.type = type;
		this.job = job;
//		this.contactNumber = contactNumber;
	}

	public Vehicle() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRegistration() {
		return registration;
	}

	public void setRegistration(String registration) {
		this.registration = registration;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}
	
//	public String getContactNumber() {
//		return contactNumber;
//	}
//	
//	public void setContactNumber(String contactNumber) {
//		this.contactNumber = contactNumber;
//	}

	@Override
	public String toString() {
		return "Vehicle [id=" + id + ", registration=" + registration + ", type=" + type + ", job=" + job + "]";
	}
	
//	 + ",contactNumber=" + contactNumber
}
