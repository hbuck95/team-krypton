package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.entities.EposTranscationEntity;
import com.project.repository.EposTranscationsRepo;

@Service
public class EposTranscationsServiceImpl implements EposTranscationsService {

	private EposTranscationsRepo repo;

	@Autowired
	public EposTranscationsServiceImpl(EposTranscationsRepo repo) {
		this.repo = repo;
	}

	@Override
	public List<EposTranscationEntity> getTranscations(EposTranscationEntity eposTranscationEntity) {
		int bankCardNumber = eposTranscationEntity.getBankCardNumber();
		List<EposTranscationEntity> transcations = repo.findByBankCardNumber(bankCardNumber);
		return transcations;
	}
}
