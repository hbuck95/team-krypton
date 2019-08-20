package com.project.entities;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "eposTransactions_subset")
public class EpostransactionEntity {

	private String timestamp;
	private int eposId;
	private Long bankCardNumber;
	private int payeeAccount;
	private int amount;

	public EpostransactionEntity() {
		super();
	}

	public EpostransactionEntity(String timestamp, int eposId, Long bankCardNumber, int payeeAccount, int amount) {
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

	public int getEposId() {
		return eposId;
	}

	public void setEposId(int eposId) {
		this.eposId = eposId;
	}

	public Long getBankCardNumber() {
		return bankCardNumber;
	}

	public void setBankCardNumber(Long bankCardNumber) {
		this.bankCardNumber = bankCardNumber;
	}

	public int getPayeeAccount() {
		return payeeAccount;
	}

	public void setPayeeAccount(int payeeAccount) {
		this.payeeAccount = payeeAccount;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}
}
