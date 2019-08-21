package com.project.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.project.entities.PeopleMobileEntity;

public interface PeopleMobileRepository extends MongoRepository<PeopleMobileEntity, Long> {

	PeopleMobileEntity findByPhoneNumber(String phoneNumber);

}
