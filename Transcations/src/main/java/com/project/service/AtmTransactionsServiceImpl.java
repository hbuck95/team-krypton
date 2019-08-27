package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.entities.AtmtransactionsEntity;
import com.project.repository.AtmTransactionsRepo;

@Service
public class AtmTransactionsServiceImpl implements AtmTransactionsService {

	private AtmTransactionsRepo repo;

	@Autowired
	public AtmTransactionsServiceImpl(AtmTransactionsRepo repo) {
		this.repo = repo;
	}

	@Override
	public List<AtmtransactionsEntity> getTransactions(AtmtransactionsEntity atmTransactionsEntity) {
		Long bankCardNumber = atmTransactionsEntity.getBankCardNumber();
		List<AtmtransactionsEntity> transactions = repo.findByBankCardNumber(bankCardNumber);
		return transactions;
	}

}
