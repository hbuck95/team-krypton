package com.project.entity;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "vehicleobservations")
public class ANPRObservationEntity {

	int ANPRPointId;
	@Field("timestamp")
	String timeStamp;
	String vehicleRegistrationNumber;

	public ANPRObservationEntity(int aNPRPointId, String timeStamp, String vehicleRegistrationNumber) {
		super();
		ANPRPointId = aNPRPointId;
		this.timeStamp = timeStamp;
		this.vehicleRegistrationNumber = vehicleRegistrationNumber;
	}

	public ANPRObservationEntity() {

	}

	public String getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}

	public void setANPRPointId(int aNPRPointId) {
		ANPRPointId = aNPRPointId;
	}

	public void setVehicleRegistrationNumber(String vehicleRegistrationNumber) {
		this.vehicleRegistrationNumber = vehicleRegistrationNumber;
	}

	public String getVehicleRegistrationNumber() {
		return vehicleRegistrationNumber;
	}

	public int getANPRPointId() {
		return ANPRPointId;
	}

}
