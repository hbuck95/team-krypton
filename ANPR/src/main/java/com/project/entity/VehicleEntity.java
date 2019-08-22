package com.project.entity;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "vehicles")
public class VehicleEntity {

	private String vehicleRegistrationNo;
	private String make;
	private String model;
	private String colour;

	public VehicleEntity() {
		super();
	}

	public VehicleEntity(String vehicleRegistrationNo, String make, String model, String colour) {
		super();
		this.vehicleRegistrationNo = vehicleRegistrationNo;
		this.make = make;
		this.model = model;
		this.colour = colour;
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

}
