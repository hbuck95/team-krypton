package com.project.entities;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "peoplemobile")
public class PeopleMobileEntity {

	private String forenames;
	private String surname;
	private String dateOfBirth;
	private String address;
	private String phoneNumber;
	private String network;

	public PeopleMobileEntity() {
		super();
	}

	public PeopleMobileEntity(String forenames, String surname, String dateOfBirth, String address, String phoneNumber,
			String network) {
		super();
		this.forenames = forenames;
		this.surname = surname;
		this.dateOfBirth = dateOfBirth;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.network = network;
	}

	public String getForenames() {
		return forenames;
	}

	public void setForenames(String forenames) {
		this.forenames = forenames;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getNetwork() {
		return network;
	}

	public void setNetwork(String network) {
		this.network = network;
	}
}
