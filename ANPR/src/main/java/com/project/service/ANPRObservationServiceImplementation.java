package com.project.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.entity.ANPRObservationEntity;
import com.project.entity.VehicleRegistrationEntity;
import com.project.repository.ANPRObservationRepository;

@Service
public class ANPRObservationServiceImplementation implements ANPRObservationService {

	private ANPRObservationRepository repo;

	@Autowired
	public ANPRObservationServiceImplementation(ANPRObservationRepository repo) {
		this.repo = repo;
	}

	@Override
	public List<ANPRObservationEntity> findByVehicleRegistrationNumber(
			List<VehicleRegistrationEntity> vehicleRegistrationEntity) {
		List<ANPRObservationEntity> vehicles = new ArrayList<ANPRObservationEntity>();
		for (int i = 0; i < vehicleRegistrationEntity.size(); i++) {
			String vehicleRegistrationNumber = vehicleRegistrationEntity.get(i).getVehicleRegistrationNo();
			List<ANPRObservationEntity> vehicle = repo.findByVehicleRegistrationNumber(vehicleRegistrationNumber);
			vehicles.addAll(vehicle);
		}
		return vehicles;
	}

}
