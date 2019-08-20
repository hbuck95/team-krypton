package com.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.entities.PeopleBankAccountEntity;
import com.project.repository.BankAccountHoldersRepo;

@Service
public class BankAccountHoldersServiceImpl implements BankAccountHoldersService {

	private BankAccountHoldersRepo repo;

	@Autowired
	public BankAccountHoldersServiceImpl(BankAccountHoldersRepo repo) {
		this.repo = repo;
	}

	@Override
	public PeopleBankAccountEntity getBankHolder(PeopleBankAccountEntity peopleBankAccountEntity) {
		String forenames = peopleBankAccountEntity.getForenames();
		String surname = peopleBankAccountEntity.getSurname();
		String homeAddress = peopleBankAccountEntity.getHomeAddress();
		PeopleBankAccountEntity accountHolder = repo.findByForenames(forenames, surname, homeAddress);
		return accountHolder;
	}

}
