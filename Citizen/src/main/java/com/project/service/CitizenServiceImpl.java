package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.entity.Citizen;
import com.project.repository.CitizenRepo;

@Service
public class CitizenServiceImpl implements CitizenService {

	private CitizenRepo repo;

	@Autowired
	public CitizenServiceImpl(CitizenRepo repository) {
		this.repo = repository;

	}

	@Override
	public List<Citizen> getAllCitizen() {
		return repo.findAll();
	}

	@Override
	public Citizen getCitizen(Citizen citizen) {
		String forenames = citizen.getForenames();
		String surname = citizen.getSurname();
		String homeAddress = citizen.getHomeAddress();
		Citizen citizens = repo.findByForenames(forenames, surname, homeAddress);
		return citizens;
	}
}
