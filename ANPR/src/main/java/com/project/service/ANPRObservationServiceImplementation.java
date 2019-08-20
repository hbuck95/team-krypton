package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.entity.ANPRObservationEntity;
import com.project.repository.ANPRObservationRepository;

@Service
public class ANPRObservationServiceImplementation implements ANPRObservationService {

	private ANPRObservationRepository repo;

	@Autowired
	public ANPRObservationServiceImplementation(ANPRObservationRepository repo) {
		this.repo = repo;
	}

	@Override
	public List<ANPRObservationEntity> findByVehicleRegistrationNumber(String vehicleRegistrationNumber) {
		return repo.findByVehicleRegistrationNumber(vehicleRegistrationNumber);
	}

}
