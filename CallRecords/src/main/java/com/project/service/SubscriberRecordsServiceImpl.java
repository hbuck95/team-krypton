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

	@Override
	public List<SubscriberRecordsEntity> findByForenameSurname(SubscriberRecordsEntity srEntity) {
		String forenames = srEntity.getForenames();
		String surname = srEntity.getSurname();
		return repo.findByForenameSurname(forenames, surname);
	}
	@Override
	public List<SubscriberRecordsEntity> findByForenameSurnameDoBAdd(SubscriberRecordsEntity srEntity) {
		String forenames = srEntity.getForenames();
		String surname = srEntity.getSurname();
		String dateOfBirth = srEntity.getDateOfBirth();
		String address = srEntity.getAddress();
		
		return repo.findByForenameSurnameDoBAdd(forenames, surname, dateOfBirth, address);
	}


}
