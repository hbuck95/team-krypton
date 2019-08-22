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

}
