package com.project.entity;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "anprcamera")
public class ANPRCameraEntity {

	Integer anprId;
	String streetName;
	String latitude;
	String longitude;

	public ANPRCameraEntity(Integer anprId, String streetName, String latitude, String longitude) {
		this.anprId = anprId;
		this.streetName = streetName;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public ANPRCameraEntity() {

	}

	public Integer getAnprId() {
		return anprId;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
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

	public void setAnprId(Integer anprId) {
		this.anprId = anprId;
	}

}
