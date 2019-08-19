package com.project.entity;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "vehicleObservations_subset")
public class ANPRObservationEntity {

	String ANPRPointId;
	String timeStamp;
	String vehicleRegistrationNo;

	public ANPRObservationEntity(String aNPRPointId, String timeStamp, String vehicleRegistrationNo) {
		super();
		ANPRPointId = aNPRPointId;
		this.timeStamp = timeStamp;
		this.vehicleRegistrationNo = vehicleRegistrationNo;
	}

	public ANPRObservationEntity() {

	}

	public String getANPRPointId() {
		return ANPRPointId;
	}

	public String getTimeStamp() {
		return timeStamp;
	}

	public String getVehicleRegistrationNo() {
		return vehicleRegistrationNo;
	}

	public void setANPRPointId(String aNPRPointId) {
		ANPRPointId = aNPRPointId;
	}

	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}

	public void setVehicleRegistrationNo(String vehicleRegistrationNo) {
		this.vehicleRegistrationNo = vehicleRegistrationNo;
	}

}
