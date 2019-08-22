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
	public List<MobileCallRecordsEntity> getCallRecordsOfSuspect(String suspectPhoneNumber) {
		// String callerMSISDN = mobileCallRecordsEntity.getCallerMSISDN();
		List<MobileCallRecordsEntity> callRecordsForSuspect = repo.findByCallerMSISDN(suspectPhoneNumber);
		return callRecordsForSuspect;
	}

	@Override
	public List<MobileCallRecordsEntity> getCallRecordsOfAssociate(MobileCallRecordsEntity mobileCallRecordsEntity) {
		String receiverMSISDN = mobileCallRecordsEntity.getReceiverMSISDN();
		List<MobileCallRecordsEntity> callRecordsForAssociate = repo.findByreceiverMSISDN(receiverMSISDN);
		return callRecordsForAssociate;
	}

}
