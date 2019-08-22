package com.project.entities;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "bankcard")
public class BankCardEntity {

	private int bankcardId;
	private Long cardNumber;
	private String sortCode;
	private int bankAccountId;
	private int accountNumber;
	private String bank;

	public BankCardEntity() {
		super();
	}

	public BankCardEntity(int bankcardId, Long cardNumber, String sortCode, int bankAccountId, int accountNumber,
			String bank) {
		super();
		this.bankcardId = bankcardId;
		this.cardNumber = cardNumber;
		this.sortCode = sortCode;
		this.bankAccountId = bankAccountId;
		this.accountNumber = accountNumber;
		this.bank = bank;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

}
