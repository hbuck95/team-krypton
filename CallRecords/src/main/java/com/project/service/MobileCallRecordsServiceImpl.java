package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.entities.MobileCallRecordsEntity;
import com.project.repository.MobileCallRecordsRepo;

@Service
public class MobileCallRecordsServiceImpl implements MobileCallRecordsService {

	private MobileCallRecordsRepo repo;

	@Autowired
	public MobileCallRecordsServiceImpl(MobileCallRecordsRepo repo) {
		this.repo = repo;
	}

	@Override
	public List<MobileCallRecordsEntity> getCallRecordsOfSuspect(MobileCallRecordsEntity mobileCallRecordsEntity) {
		String callerMSISDN = mobileCallRecordsEntity.getCallerMSISDN();
		List<MobileCallRecordsEntity> callRecordsForSuspect = repo.findByCallerMSISDN(callerMSISDN);
		return callRecordsForSuspect;
	}

	@Override
	public List<MobileCallRecordsEntity> getCallRecordsOfAssosiate(MobileCallRecordsEntity mobileCallRecordsEntity) {
		String receiverMSISDN = mobileCallRecordsEntity.getReceiverMSISDN();
		List<MobileCallRecordsEntity> callRecordsForAssosiate = repo.findByCallerMSISDN(receiverMSISDN);
		return callRecordsForAssosiate;
	}

}
