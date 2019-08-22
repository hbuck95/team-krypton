package com.project.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.project.entities.PeopleMobileEntity;

public interface PeopleMobileRepository extends MongoRepository<PeopleMobileEntity, Long> {

	PeopleMobileEntity findByPhoneNumber(String phoneNumber);

	@Query("{ 'forenames' : ?0, 'surname' : ?1, 'address' : ?2}")
	PeopleMobileEntity findByForenames(String forenames, String surname, String address);

}
