package com.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.entities.BankCardEntity;
import com.project.repository.BankCardsRepo;

@Service
public class BankCardServiceImpl implements BankCardService {

	private BankCardsRepo repo;

	@Autowired
	public BankCardServiceImpl(BankCardsRepo repo) {
		this.repo = repo;
	}

	@Override
	public BankCardEntity getBankCard(BankCardEntity bankCardEntity) {
		int accountNumber = bankCardEntity.getAccountNumber();
		BankCardEntity bankCard = repo.findByAccountNumber(accountNumber);
		return bankCard;
	}

}
