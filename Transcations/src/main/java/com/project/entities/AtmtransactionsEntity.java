package com.project.entities;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "atmTransactions")
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

	public AtmtransactionsEntity(String timeStamp, int atmId, Long bankCardNumber, String type, int amount) {
		super();
		this.timeStamp = timeStamp;
		this.atmId = atmId;
		this.bankCardNumber = bankCardNumber;
		this.type = type;
		this.amount = amount;
	}

	public Long getBankCardNumber() {
		return bankCardNumber;
	}

}
