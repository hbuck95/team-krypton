package com.project.entities;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "peoplebankaccount_subset")
public class PeopleBankAccountEntity {

	private int bankAccountId;
	private int accountNumber;
	private String bank;
	private String forenames;
	private String surname;
	private String dateOfBirth;
	private String homeAddress;

	public PeopleBankAccountEntity() {
		super();
	}

	public PeopleBankAccountEntity(int bankAccountId, int accountNumber, String bank, String forenames, String surname,
			String dateOfBirth, String homeAddress) {
		super();
		this.bankAccountId = bankAccountId;
		this.accountNumber = accountNumber;
		this.bank = bank;
		this.forenames = forenames;
		this.surname = surname;
		this.dateOfBirth = dateOfBirth;
		this.homeAddress = homeAddress;
	}

	public String getForenames() {
		return forenames;
	}

	public String getSurname() {
		return surname;
	}

	public String getHomeAddress() {
		return homeAddress;
	}

}
