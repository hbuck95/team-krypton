package com.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.entities.PeopleBankAccountEntity;
import com.project.service.BankAccountHoldersService;

@RestController
@RequestMapping("/transcations")
public class TranscationsController {

	private BankAccountHoldersService bahService;

	@Autowired
	public TranscationsController(BankAccountHoldersService bahService) {
		this.bahService = bahService;
	}

	@PostMapping("/getAccountHolder")
	public PeopleBankAccountEntity getAccountHolder(@RequestBody PeopleBankAccountEntity peopleBankAccountEntity) {
		return bahService.getBankHolder(peopleBankAccountEntity);
	}

}
