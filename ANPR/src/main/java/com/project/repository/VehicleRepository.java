package com.project.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.project.entity.VehicleEntity;

@Repository
public interface VehicleRepository extends MongoRepository<VehicleEntity, Long> {

}
