package com.project.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.project.entity.VehicleEntity;

public interface VehicleRepo extends MongoRepository<VehicleEntity, Long> {

	VehicleEntity findVehicleRegistrationNo(String vehicleRegistrationNo);
}
