package com.project.entities;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "celltower_subset")
public class CellTowerEntity {

	private int cellTowerId;
	private String operator;
	private String type;
	private int latitude;
	private int longitude;

	public CellTowerEntity() {
		super();
	}

	public CellTowerEntity(int cellTowerId, String operator, String type, int latitude, int longitude) {
		super();
		this.cellTowerId = cellTowerId;
		this.operator = operator;
		this.type = type;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public int getCellTowerId() {
		return cellTowerId;
	}

	public void setCellTowerId(int cellTowerId) {
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

	public int getLatitude() {
		return latitude;
	}

	public void setLatitude(int latitude) {
		this.latitude = latitude;
	}

	public int getLongitude() {
		return longitude;
	}

	public void setLongitude(int longitude) {
		this.longitude = longitude;
	}
}
