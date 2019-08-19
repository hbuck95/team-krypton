package com.project.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.project.entity.Citizen;

@Repository
public interface CitizenRepo extends MongoRepository<Citizen, Long> {

}
