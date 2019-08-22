package com.project.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.project.entities.EposEntity;

public interface EposRepo extends MongoRepository<EposEntity, Long> {

	@Query("{'id': ?0}")
	EposEntity findById(int id);

}
