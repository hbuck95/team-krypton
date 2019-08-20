package com.project.service;

import java.util.List;

import com.project.entities.AtmtransactionsEntity;

public interface AtmTransactionsService {

	List<AtmtransactionsEntity> getTransactions(AtmtransactionsEntity atmTransactionsEntity);

}
