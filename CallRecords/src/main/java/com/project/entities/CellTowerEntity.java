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

	public int getCellTowerId() {
		return cellTowerId;
	}


}
