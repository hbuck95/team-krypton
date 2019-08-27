package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.entities.EpostransactionEntity;
import com.project.repository.EpostransactionsRepo;

@Service
public class EpostransactionsServiceImpl implements EpostransactionsService {

	private EpostransactionsRepo repo;

	@Autowired
	public EpostransactionsServiceImpl(EpostransactionsRepo repo) {
		this.repo = repo;
	}

	@Override
	public List<EpostransactionEntity> gettransactions(EpostransactionEntity epostransactionEntity) {
		Long bankCardNumber = epostransactionEntity.getBankCardNumber();
		List<EpostransactionEntity> transactions = repo.findByBankCardNumber(bankCardNumber);
		return transactions;
	}
}
