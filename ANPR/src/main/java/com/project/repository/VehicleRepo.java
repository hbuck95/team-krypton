package com.project.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.project.entity.VehicleEntity;

@Repository
public interface VehicleRepo extends MongoRepository<VehicleEntity, Long> {

	VehicleEntity findVehicleRegistrationNo(String vehicleRegistrationNo);
}
