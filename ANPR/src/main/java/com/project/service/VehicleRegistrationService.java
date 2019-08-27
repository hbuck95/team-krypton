package com.project.service;

import java.util.List;

import com.project.entity.VehicleRegistrationEntity;

public interface VehicleRegistrationService {

	public List<VehicleRegistrationEntity> findByForenamesAndSurname(
			VehicleRegistrationEntity vehicleRegistrationEntity);

	public List<VehicleRegistrationEntity> getAll();

	public VehicleRegistrationEntity findByRegistration(VehicleRegistrationEntity vehicleRegistrationEntity);

}
