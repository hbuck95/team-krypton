package com.project.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.project.entities.EposEntity;

public interface EposRepo extends MongoRepository<EposEntity, Long> {

	EposEntity findById(int id);

}
