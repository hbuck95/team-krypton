package com.project.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.entity.VehicleRegistrationEntity;
import com.project.repository.VehicleRegistrationRepository;

@Service
public class VehicleRegistrationServiceImplementation implements VehicleRegistrationService {

	private VehicleRegistrationRepository repo;

	@Override
	public List<VehicleRegistrationEntity> findByForenamesAndSurname(String forenames, String surname) {
		return repo.findByForenamesAndSurname(forenames, surname);
	}

}
