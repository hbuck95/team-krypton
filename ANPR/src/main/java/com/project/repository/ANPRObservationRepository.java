package com.project.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ANPRObservationRepository extends MongoRepository<ANPRObservationRepository, Long> {

}
