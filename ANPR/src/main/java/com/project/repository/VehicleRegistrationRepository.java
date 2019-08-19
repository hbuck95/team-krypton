package com.project.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.project.entity.VehicleRegistrationEntity;

@Repository
public interface VehicleRegistrationRepository extends MongoRepository<VehicleRegistrationEntity, Long> {

	List<VehicleRegistrationEntity> findByForenamesAndSurname(String forenames, String surname);

}
