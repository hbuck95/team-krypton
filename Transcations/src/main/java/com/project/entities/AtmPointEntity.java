package com.project.entities;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "atmpoint")
public class AtmPointEntity {

	private int atmId;
	private String operator;
	private String streetName;
	private String postcode;
	private String latitude;
	private String longitude;

	public AtmPointEntity() {
		super();

	}

	public AtmPointEntity(int atmId, String operator, String streetName, String postcode, String latitude,
			String longitude) {
		super();
		this.atmId = atmId;
		this.operator = operator;
		this.streetName = streetName;
		this.postcode = postcode;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public int getAtmId() {
		return atmId;
	}

	public void setAtmId(int atmId) {
		this.atmId = atmId;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

}
