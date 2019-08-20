package com.project.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.project.entity.SubscriberRecordsEntity;

public interface SubscriberRecordsRepository extends MongoRepository<SubscriberRecordsEntity, Long>{

}
