package com.project.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.project.entity.Citizen;

@Repository
public interface CitizenRepo extends MongoRepository<Citizen, Long> {

	@Query(value = "SELECT c FROM Citizen c WHERE c.forenames= :forenames and c.surname= :surname and c.homeAddress= :homeAddress")
	Citizen findCitizen(@Param("forenames") String forenames, @Param("surname") String surname,
			@Param("homeAddress") String homeAddress);

}
