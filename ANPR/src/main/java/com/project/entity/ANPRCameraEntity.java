package com.project.entity;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "anprcamera_subset")
public class ANPRCameraEntity {

	String anprId;
	String streetName;
	String latitude;
	String longitude;

	public ANPRCameraEntity(String anprId, String streetName, String latitude, String longitude) {
		this.anprId = anprId;
		this.streetName = streetName;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public ANPRCameraEntity() {

	}

	public String getAnprId() {
		return anprId;
	}

	public String getStreetName() {
		return streetName;
	}

	public String getLatitude() {
		return latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setAnprId(String anprId) {
		this.anprId = anprId;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

}
