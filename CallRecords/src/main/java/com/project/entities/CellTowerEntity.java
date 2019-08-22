package com.project.entities;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "celltower")
public class CellTowerEntity {

	private int cellTowerId;
	private String operator;
	private String type;
	private String latitude;
	private String longitude;

	public CellTowerEntity() {
		super();
	}

	public CellTowerEntity(int cellTowerId, String operator, String type, String latitude, String longitude) {
		super();
		this.cellTowerId = cellTowerId;
		this.operator = operator;
		this.type = type;
		this.latitude = latitude;
		this.longitude = longitude;
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

	public void setCellTowerId(int cellTowerId) {
		this.cellTowerId = cellTowerId;
	}

	public int getCellTowerId() {
		return cellTowerId;
	}

}
