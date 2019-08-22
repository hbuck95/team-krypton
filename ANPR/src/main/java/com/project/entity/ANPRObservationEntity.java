package com.project.entity;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "vehicleObservations")
public class ANPRObservationEntity {

	String ANPRPointId;
	@Field("timestamp")
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

	public String getVehicleRegistrationNumber() {
		return vehicleRegistrationNumber;
	}

}
