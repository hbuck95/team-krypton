package com.project.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.project.entity.VehicleEntity;

@Repository
public interface VehicleRepo extends MongoRepository<VehicleEntity, Long> {

	@Query("{ 'vehicleRegistrationNo' : ?0}")
	VehicleEntity findbyVehicleRegistrationNo(String vehicleRegistrationNo);
}
