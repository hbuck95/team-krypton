package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.entities.AtmtransactionsEntity;
import com.project.entities.BankCardEntity;
import com.project.entities.EpostransactionEntity;
import com.project.entities.PeopleBankAccountEntity;
import com.project.service.AtmTransactionsService;
import com.project.service.BankAccountHoldersService;
import com.project.service.BankCardService;
import com.project.service.EpostransactionsService;

@RestController
@RequestMapping("/transactions")
public class TransactionsController {

	private BankAccountHoldersService bahService;
	private BankCardService bcService;
	private EpostransactionsService etService;
	private AtmTransactionsService atService;

	@Autowired
	public TransactionsController(BankAccountHoldersService bahService, BankCardService bcService,
			EpostransactionsService etService, AtmTransactionsService atService) {
		this.bahService = bahService;
		this.bcService = bcService;
		this.etService = etService;
		this.atService = atService;
	}

	@PostMapping("/getAccountHolder")
	public PeopleBankAccountEntity getAccountHolder(@RequestBody PeopleBankAccountEntity peopleBankAccountEntity) {
		return bahService.getBankHolder(peopleBankAccountEntity);
	}

	@PostMapping("/getBankCard")
	public BankCardEntity getBankCard(@RequestBody BankCardEntity bankCardEntity) {
		return bcService.getBankCard(bankCardEntity);
	}

	@PostMapping("/getEposTransactions")
	public List<EpostransactionEntity> getEpostransactions(@RequestBody EpostransactionEntity epostransactionsEntity) {
		return etService.gettransactions(epostransactionsEntity);
	}

	@PostMapping("/getAtmTransactions")
	public List<AtmtransactionsEntity> getAtmTransactions(@RequestBody AtmtransactionsEntity atmTransactionsEntity) {
		return atService.getTransactions(atmTransactionsEntity);
	}
}
