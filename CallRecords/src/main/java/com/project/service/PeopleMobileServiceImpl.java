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
	public PeopleMobileEntity getAssosiate(PeopleMobileEntity peopleMobileEntity) {
		String phoneNumber = peopleMobileEntity.getPhoneNumber();
		PeopleMobileEntity assosiate = repo.findByPhoneNumber(phoneNumber);
		return assosiate;
	}

}
