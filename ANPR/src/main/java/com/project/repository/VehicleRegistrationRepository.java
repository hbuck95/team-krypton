package com.project.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.project.entity.VehicleRegistrationEntity;

@Repository
public interface VehicleRegistrationRepository extends MongoRepository<VehicleRegistrationEntity, Long> {

	@Query("{ 'forenames' : ?0, 'surname' : ?1, 'address' : ?2}")
	List<VehicleRegistrationEntity> findByForenames(String forenames, String surname, String address);

	VehicleRegistrationEntity findByVehicleRegistrationNo(String vehicleRegistrationNo);

}
