package com.project.entity;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "vehicleObservations_subset")
public class ANPRObservationEntity {

	String ANPRPointId;
	String timeStamp;
	String vehicleRegistrationNumber;

	public ANPRObservationEntity(String aNPRPointId, String timeStamp, String vehicleRegistrationNumber) {
		super();
		ANPRPointId = aNPRPointId;
		this.timeStamp = timeStamp;
		this.vehicleRegistrationNumber = vehicleRegistrationNumber;
	}

	public ANPRObservationEntity() {

	}

	public String getANPRPointId() {
		return ANPRPointId;
	}

	public String getTimeStamp() {
		return timeStamp;
	}

	public String getVehicleRegistrationNumber() {
		return vehicleRegistrationNumber;
	}

	public void setANPRPointId(String aNPRPointId) {
		ANPRPointId = aNPRPointId;
	}

	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}

	public void setVehicleRegistrationNumber(String vehicleRegistrationNumber) {
		this.vehicleRegistrationNumber = vehicleRegistrationNumber;
	}

}
