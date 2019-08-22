package com.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.entity.VehicleEntity;
import com.project.repository.VehicleRepo;

@Service
public class VehicleServiceImpl implements VehicleService {

	private VehicleRepo repo;

	@Autowired
	public VehicleServiceImpl(VehicleRepo repo) {
		this.repo = repo;
	}

	@Override
	public VehicleEntity findVehicleByRegistration(VehicleEntity vehicleEntity) {
		String vehicleRegistrationNo = vehicleEntity.getVehicleRegistrationNo();
		return repo.findVehicleRegistrationNo(vehicleRegistrationNo);
	}

}
