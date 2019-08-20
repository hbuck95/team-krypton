package com.project.entity;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "celltower_subset")
public class CellTowersEntity {

	private String cellTowerId;
	private String operator;
	private String type;
	private String latitude;
	private String longitude;
	
	
public CellTowersEntity() {
	
}


public CellTowersEntity(String cellTowerId, String operator, String type, String latitude, String longitude) {
	super();
	this.cellTowerId = cellTowerId;
	this.operator = operator;
	this.type = type;
	this.latitude = latitude;
	this.longitude = longitude;
}


public String getCellTowerId() {
	return cellTowerId;
}


public void setCellTowerId(String cellTowerId) {
	this.cellTowerId = cellTowerId;
}


public String getOperator() {
	return operator;
}


public void setOperator(String operator) {
	this.operator = operator;
}


public String getType() {
	return type;
}


public void setType(String type) {
	this.type = type;
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
