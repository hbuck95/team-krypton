package com.project.service;

import java.util.List;

import com.project.entity.ANPRObservationEntity;

public interface ANPRObservationService {

	List<ANPRObservationEntity> findByVehicleRegistrationNumber(String vehicleRegistrationNumber);

}
