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

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public int getPayeeAccount() {
		return payeeAccount;
	}

	public void setPayeeAccount(int payeeAccount) {
		this.payeeAccount = payeeAccount;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public void setEposId(int eposId) {
		this.eposId = eposId;
	}

	public void setBankCardNumber(Long bankCardNumber) {
		this.bankCardNumber = bankCardNumber;
	}

	public int getEposId() {
		return eposId;
	}

	public Long getBankCardNumber() {
		return bankCardNumber;
	}

}
