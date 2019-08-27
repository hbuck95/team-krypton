package com.project.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.project.entity.Citizen;

@Repository
public interface CitizenRepo extends MongoRepository<Citizen, Long> {

	@Query("{ 'forenames' : ?0, 'surname' : ?1, 'homeAddress' : ?2}")
	Citizen findbyNamesAndAddress(String forenames, String surname, String homeAddress);
}
