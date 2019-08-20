package com.project.entities;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "bankcard_subset")
public class BankCardEntity {

	private int bankcardId;
	private Long cardNumber;
	private String sortcode;
	private int bankAccountId;
	private int accountNumber;
	private String bank;

	public BankCardEntity() {
		super();
	}

	public BankCardEntity(int bankcardId, Long cardNumber, String sortcode, int bankAccountId, int accountNumber,
			String bank) {
		super();
		this.bankcardId = bankcardId;
		this.cardNumber = cardNumber;
		this.sortcode = sortcode;
		this.bankAccountId = bankAccountId;
		this.accountNumber = accountNumber;
		this.bank = bank;
	}

	public int getBankcardId() {
		return bankcardId;
	}

	public void setBankcardId(int bankcardId) {
		this.bankcardId = bankcardId;
	}

	public Long getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(Long cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getSortcode() {
		return sortcode;
	}

	public void setSortcode(String sortcode) {
		this.sortcode = sortcode;
	}

	public int getBankAccountId() {
		return bankAccountId;
	}

	public void setBankAccountId(int bankAccountId) {
		this.bankAccountId = bankAccountId;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getBank() {
		return bank;
	}

	public void setBank(String bank) {
		this.bank = bank;
	}
}
