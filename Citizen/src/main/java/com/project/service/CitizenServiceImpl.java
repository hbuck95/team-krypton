package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import com.project.entity.Citizen;
import com.project.repository.CitizenRepo;

public class CitizenServiceImpl implements CitizenService{

	private CitizenRepo repo;
	private RestTemplate restTemplate;

	
	@Autowired
	public CitizenServiceImpl(CitizenRepo repository, RestTemplate restTemplate) {
		this.repo = repository;
		this.restTemplate = restTemplate;

	}


	@Override
	public List<Citizen> getCitizen() {
	return repo.findAll();
	}
	
	
}
