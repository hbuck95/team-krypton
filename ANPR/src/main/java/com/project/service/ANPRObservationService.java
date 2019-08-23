package com.project.service;

import java.util.List;

import com.project.entity.ANPRObservationEntity;
import com.project.entity.VehicleRegistrationEntity;

public interface ANPRObservationService {

	List<ANPRObservationEntity> findByVehicleRegistrationNumber(
			List<VehicleRegistrationEntity> vehicleRegistrationEntity);

}
