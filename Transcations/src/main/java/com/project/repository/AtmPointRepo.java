package com.project.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.project.entities.AtmPointEntity;

public interface AtmPointRepo extends MongoRepository<AtmPointEntity, Long> {

	AtmPointEntity findByAtmId(int atmId);

}
