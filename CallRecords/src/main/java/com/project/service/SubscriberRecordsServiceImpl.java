package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.project.entity.SubscriberRecordsEntity;
import com.project.repository.SubscriberRecordsRepository;

public class SubscriberRecordsServiceImpl implements SubscriberRecordsService {

	private SubscriberRecordsRepository repo;
	
	
	@Autowired
	public SubscriberRecordsServiceImpl(SubscriberRecordsRepository repo) {
		this.repo = repo;
		
	}


	@Override
	public List<SubscriberRecordsEntity> findByPhoneNumber(SubscriberRecordsEntity srEntity) {
	String phoneNumber = srEntity.getPhoneNumber();
	return repo.findByPhoneNumber(phoneNumber);
	
	}
	
	
	
}
