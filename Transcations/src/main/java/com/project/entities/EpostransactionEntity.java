package com.project.entities;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "epostransactions")
public class EpostransactionEntity {

	private String timestamp;
	private int eposId;
	private Long bankCardNumber;
	private int payeeAccount;
	private double amount;

	public EpostransactionEntity() {
		super();
	}

	public EpostransactionEntity(String timestamp, int eposId, Long bankCardNumber, int payeeAccount, double amount) {
		super();
		this.timestamp = timestamp;
		this.eposId = eposId;
		this.bankCardNumber = bankCardNumber;
		this.payeeAccount = payeeAccount;
		this.amount = amount;
	}

	public int getEposId() {
		return eposId;
	}

	public Long getBankCardNumber() {
		return bankCardNumber;
	}

}
