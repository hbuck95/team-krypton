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

	public String getRegistrationId() {
		return registrationId;
	}

	public String getRegistrationDate() {
		return registrationDate;
	}

	public String getVehicleRegistrationNo() {
		return vehicleRegistrationNo;
	}

	public String getMake() {
		return make;
	}

	public String getModel() {
		return model;
	}

	public String getColour() {
		return colour;
	}

	public String getForenames() {
		return forenames;
	}

	public String getSurname() {
		return surname;
	}

	public String getAddress() {
		return address;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public String getDriverLicenceID() {
		return driverLicenceID;
	}

	public void setRegistrationId(String registrationId) {
		this.registrationId = registrationId;
	}

	public void setRegistrationDate(String registrationDate) {
		this.registrationDate = registrationDate;
	}

	public void setVehicleRegistrationNo(String vehicleRegistrationNo) {
		this.vehicleRegistrationNo = vehicleRegistrationNo;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	public void setForenames(String forenames) {
		this.forenames = forenames;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public void setDriverLicenceID(String driverLicenceID) {
		this.driverLicenceID = driverLicenceID;
	}

}
