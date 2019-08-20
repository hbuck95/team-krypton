package com.project.entities;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "eposTransactions_subset")
public class EposTranscationEntity {

	private String timestamp;
	private int eposId;
	private int bankCradNumber;
	private int payeeAccount;
	private int amount;

	public EposTranscationEntity() {
		super();
	}

	public EposTranscationEntity(String timestamp, int eposId, int bankCradNumber, int payeeAccount, int amount) {
		super();
		this.timestamp = timestamp;
		this.eposId = eposId;
		this.bankCradNumber = bankCradNumber;
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

	public int getBankCradNumber() {
		return bankCradNumber;
	}

	public void setBankCradNumber(int bankCradNumber) {
		this.bankCradNumber = bankCradNumber;
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
