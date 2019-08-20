package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.entity.VehicleRegistrationEntity;
import com.project.repository.VehicleRegistrationRepository;

@Service
public class VehicleRegistrationServiceImplementation implements VehicleRegistrationService {

	private VehicleRegistrationRepository repo;

	@Autowired
	public VehicleRegistrationServiceImplementation(VehicleRegistrationRepository repository) {
		this.repo = repository;
	}

	@Override
	public List<VehicleRegistrationEntity> findByForenamesAndSurname(
			VehicleRegistrationEntity vehicleRegistrationEntity) {

		String forenames = vehicleRegistrationEntity.getForenames();
		String surname = vehicleRegistrationEntity.getSurname();

		return repo.findByForenamesAndSurname(forenames, surname);
	}

	@Override
	public List<VehicleRegistrationEntity> getAll() {
		return repo.findAll();
	}

}
