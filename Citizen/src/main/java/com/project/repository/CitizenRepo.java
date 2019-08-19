package com.project.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.project.entity.Citizen;

@Repository
public interface CitizenRepo extends MongoRepository<Citizen, Long> {

	@Query("SELECT c FROM Citizen c where c.forenames= :forenames")
	Citizen findByForename(@Param("forenames") String forenames);

}
