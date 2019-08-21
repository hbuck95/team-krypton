package com.project.entity;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "vehicleRegistration_subset")
public class VehicleRegistrationEntity {

	@Field("registrationID")
	String registrationId;
	String registrationDate;
	String vehicleRegistrationNo;
	String make;
	String model;
	String colour;
	String forenames;
	String surname;
	String address;
	String dateOfBirth;
	String driverLicenceID;

	public VehicleRegistrationEntity(String registrationId, String registrationDate, String vehicleRegistrationNo,
			String make, String model, String colour, String forenames, String surname, String address,
			String dateOfBirth, String driverLicenceID) {

		this.registrationId = registrationId;
		this.registrationDate = registrationDate;
		this.vehicleRegistrationNo = vehicleRegistrationNo;
		this.make = make;
		this.model = model;
		this.colour = colour;
		this.forenames = forenames;
		this.surname = surname;
		this.address = address;
		this.dateOfBirth = dateOfBirth;
		this.driverLicenceID = driverLicenceID;
	}

	public VehicleRegistrationEntity() {

	}

	public String getForenames() {
		return forenames;
	}

	public String getSurname() {
		return surname;
	}

}
