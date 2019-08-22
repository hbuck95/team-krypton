package com.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.entities.PeopleMobileEntity;
import com.project.repository.PeopleMobileRepository;

@Service
public class PeopleMobileServiceImpl implements PeopleMobileService {

	private PeopleMobileRepository repo;

	@Autowired
	public PeopleMobileServiceImpl(PeopleMobileRepository repo) {
		this.repo = repo;
	}

	@Override
	public PeopleMobileEntity getAssociate(PeopleMobileEntity peopleMobileEntity) {
		String phoneNumber = peopleMobileEntity.getPhoneNumber();
		PeopleMobileEntity associate = repo.findByPhoneNumber(phoneNumber);
		return associate;
	}

	@Override
	public PeopleMobileEntity getPhoneNumber(PeopleMobileEntity peopleMobileEntity) {
		String forenames = peopleMobileEntity.getForenames();
		String surname = peopleMobileEntity.getSurname();
		String address = peopleMobileEntity.getAddress();
		PeopleMobileEntity phoneNumber = repo.findByForenames(forenames, surname, address);
		return phoneNumber;
	}

}
