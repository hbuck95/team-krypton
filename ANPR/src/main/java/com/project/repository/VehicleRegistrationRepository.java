package com.project.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.project.entity.VehicleRegistrationEntity;

@Repository
public interface VehicleRegistrationRepository extends MongoRepository<VehicleRegistrationEntity, Long> {

}
