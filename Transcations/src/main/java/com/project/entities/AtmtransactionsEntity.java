package com.project.entities;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "atmtransaction")
public class AtmtransactionsEntity {

	@Field("timestamp")
	private String timeStamp;
	private int atmId;
	private Long bankCardNumber;
	private String type;
	private int amount;

	public AtmtransactionsEntity() {
		super();

	}

	public int getAtmId() {
		return atmId;
	}

	public AtmtransactionsEntity(String timeStamp, int atmId, Long bankCardNumber, String type, int amount) {
		super();
		this.timeStamp = timeStamp;
		this.atmId = atmId;
		this.bankCardNumber = bankCardNumber;
		this.type = type;
		this.amount = amount;
	}

	public String getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public void setAtmId(int atmId) {
		this.atmId = atmId;
	}

	public void setBankCardNumber(Long bankCardNumber) {
		this.bankCardNumber = bankCardNumber;
	}

	public Long getBankCardNumber() {
		return bankCardNumber;
	}

}
