package com.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.entities.BankCardEntity;
import com.project.entities.PeopleBankAccountEntity;
import com.project.service.BankAccountHoldersService;
import com.project.service.BankCardService;

@RestController
@RequestMapping("/transcations")
public class TranscationsController {

	private BankAccountHoldersService bahService;
	private BankCardService bcService;

	@Autowired
	public TranscationsController(BankAccountHoldersService bahService, BankCardService bcService) {
		this.bahService = bahService;
		this.bcService = bcService;
	}

	@PostMapping("/getAccountHolder")
	public PeopleBankAccountEntity getAccountHolder(@RequestBody PeopleBankAccountEntity peopleBankAccountEntity) {
		return bahService.getBankHolder(peopleBankAccountEntity);
	}

	@PostMapping("/getBankCard")
	public BankCardEntity getBankCard(@RequestBody BankCardEntity bankCardEntity) {
		return bcService.getBankCard(bankCardEntity);
	}

}
