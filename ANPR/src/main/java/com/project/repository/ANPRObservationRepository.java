package com.project.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.project.entity.ANPRObservationEntity;

@Repository
public interface ANPRObservationRepository extends MongoRepository<ANPRObservationEntity, Long> {

	ANPRObservationEntity findByVehicleRegistrationNumber(String VehicleRegistrationNumber);

}
