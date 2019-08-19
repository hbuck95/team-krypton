package com.project.entity;

public class VehicleEntity {

	String vehicleRegistrationNo;
	String make;
	String model;
	String colour;
	
	public VehicleEntity(String vehicleRegistrationNo, String make, String model, String colour) {
		this.vehicleRegistrationNo = vehicleRegistrationNo;
		this.make = make;
		this.model = model;
		this.colour = colour;
	}
	
	public VehicleEntity() {
		
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

}
