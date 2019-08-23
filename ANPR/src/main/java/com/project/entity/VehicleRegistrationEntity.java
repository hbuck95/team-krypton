package com.project.entity;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "vehicleregistration")
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

	public void setRegistrationId(String registrationId) {
		this.registrationId = registrationId;
	}

	public String getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(String registrationDate) {
		this.registrationDate = registrationDate;
	}

	public String getVehicleRegistrationNo() {
		return vehicleRegistrationNo;
	}

	public void setVehicleRegistrationNo(String vehicleRegistrationNo) {
		this.vehicleRegistrationNo = vehicleRegistrationNo;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getDriverLicenceID() {
		return driverLicenceID;
	}

	public void setDriverLicenceID(String driverLicenceID) {
		this.driverLicenceID = driverLicenceID;
	}

	public void setForenames(String forenames) {
		this.forenames = forenames;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getForenames() {
		return forenames;
	}

	public String getSurname() {
		return surname;
	}

}
